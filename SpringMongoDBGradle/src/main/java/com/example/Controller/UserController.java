package com.example.Controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Conversation;
import com.example.model.Mails;
import com.example.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserRepository userRepository;

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public void create(@RequestBody Conversation conversation,
			@RequestParam(value = "label", required = false) String label) {
		System.out.println("uid set value: " + conversation.getFrom() + LocalDateTime.now());
		String uniqueString = conversation.getFrom() + LocalDateTime.now();
		int uniqueId = Math.abs(uniqueString.hashCode());
		conversation.setUid(uniqueId);
		conversation.setSid(uniqueId);
		conversation.setInvisibleTo("none");
		if (label !=null && label.equals("draft")) {
			conversation.setSentToDraft(true);
		}

		System.out.println();
		userRepository.save(conversation);
		System.out.println("saved conversation");
	}

	@RequestMapping(value = "/search")
	public List<Conversation> read(@RequestParam("label") String label, @RequestParam("id") String id) {// @PathVariable
																										// String
		// label) {
		System.out.println("label value and id value : " + label + ",id: " + id);

		if (label == null)
			throw new LabelNotFoundException();

		List<Conversation> user = null;
		// List mailList = new ArrayList<Mails>();
		if (label.equals("inbox")) {
			user = userRepository.findAllByToLike(id);
		}
		if (label.equals("sent")) {
			System.out.println("inside sent box");
			user = userRepository.findAllByFrom(id);
		}
		if (label.equals("unread")) {
			user = userRepository.findAllByFrom(id);
			Iterator<Conversation> iteratingUser = user.iterator();
			System.out.println("intial user in unread: " + user);
			if (user != null) {
				System.out.println("entered if " + user);
				while (iteratingUser.hasNext()) {// for (Conversation mail : iteratingUser) {
					Conversation mail = iteratingUser.next();
					System.out.println("entered for " + mail.getFrom());
					//if mail is read will be removed from unread list
					if ((mail.isRead())) {
						System.out.println("entered isread " + user);
						System.out.println("entering contains for " + mail.isRead());
						iteratingUser.remove();// user.remove(mail);
					}
				}
			}
		}
		
		if (label.equals("draft")) {
			user = userRepository.findAllByFrom(id);
			Iterator<Conversation> iteratingUser = user.iterator();
			System.out.println("intial user in unread: " + user);
			if (user != null) {
				System.out.println("entered if " + user);
				while (iteratingUser.hasNext()) {// for (Conversation mail : iteratingUser) {
					Conversation mail = iteratingUser.next();
					System.out.println("entered for " + mail.getFrom());
					//if sent to draft is false, will be removed from list
					if ((!mail.isSentToDraft())) {
						System.out.println("entered isread " + user);
						System.out.println("entering contains for " + mail.isRead());
						iteratingUser.remove();// user.remove(mail);
					}
				}
			}
		}

		if (user != null) {
			Iterator<Conversation> iteratingUser = user.iterator();
			while (iteratingUser.hasNext()) {// for (Conversation mail : iteratingUser) {
				Conversation mail = iteratingUser.next();
				System.out.println("get from mails: " + mail.getFrom());
				System.out.println("get to mails: " + mail.getTo());
				System.out.println("get to mails id : " + id);
				System.out.println("get invisible to: " + mail.getInvisibleTo());
				System.out.println("get condition " + (mail.getInvisibleTo().contains(id)));
				if ((mail.getInvisibleTo().contains(id))) {
					System.out.println("entering contains for " + mail.getFrom());
					iteratingUser.remove();// user.remove(mail);
				} /*
					 * //Current result in postman is for testing purpose, For original output this
					 * pojo with limited information will be returned else { Mails mailToShow = new
					 * Mails(); mailToShow.setFrom(mail.getFrom());
					 * mailToShow.setFrom(mail.getTo()); mailToShow.setFrom(mail.getSubject());
					 * mailToShow.setFrom(mail.getBody()); mailList.add(mailToShow); }
					 */
			}
		}
		if (label.equals("trash")) {
			user = userRepository.findAllByInvisibleToLike(id);
		}
		return user;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/readMail")
	public Conversation readMail(@RequestParam("uid") int mailNumber) {
		System.out.println("entered readMail");
		Conversation user = userRepository.findOneByUid(mailNumber);
		user.setRead(true);
		/*
		 * //Current result in postman is for testing purpose, For original output this
		 * pojo with limited information will be returned Mails mailToShow = new
		 * Mails(); mailToShow.setFrom(mail.getFrom());
		 * mailToShow.setFrom(mail.getTo()); mailToShow.setFrom(mail.getSubject());
		 * mailToShow.setFrom(mail.getBody());
		 */

		userRepository.save(user);
		return user;
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/delete")
	public void delete(@RequestParam("uid") int uid) {
		// System.out.println("Entered delete"+uid);
		Conversation mail = userRepository.findOneByUid(uid);
		// System.out.println("Found value "+mail);
		if (mail.getInvisibleTo().equals("none")) {
			mail.setInvisibleTo(mail.getFrom() + ", " + mail.getTo());
		}
		userRepository.save(mail);
	}
}
