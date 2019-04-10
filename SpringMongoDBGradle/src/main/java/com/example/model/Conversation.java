package com.example.model;

import org.springframework.data.annotation.Id;

public class Conversation {
	@Id
	private int sid;
	private int uid;
	private String from;
	private String to;
	private String subject;
	private String body;
	private String label;
	private String invisibleTo;
	private boolean read;
	private boolean sentToDraft;

	public boolean isSentToDraft() {
		return sentToDraft;
	}

	public void setSentToDraft(boolean sentToDraft) {
		this.sentToDraft = sentToDraft;
	}

	public boolean isRead() {
		return read;
	}

	public void setRead(boolean read) {
		this.read = read;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getInvisibleTo() {
		return invisibleTo;
	}

	public void setInvisibleTo(String invisibleTo) {
		this.invisibleTo = invisibleTo;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
}
