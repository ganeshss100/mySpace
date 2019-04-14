package com.example.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.model.Conversation;
//import com.example.model.User;

public interface UserRepository extends MongoRepository<Conversation,String>{
	//public Conversation findOneByName(String name);
	public Conversation findOne(String id);
	public List<Conversation> findAllByFrom(String id);
	public List<Conversation> findAllByToLike(String id);
	public Conversation findOneByUid(int id);
	public List<Conversation> findAllByInvisibleToLike(String id);
	public List<Conversation> findAllByRead(Boolean flag);
}
