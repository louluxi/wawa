package com.irandoo.xhep.base.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class CorpUser implements Serializable{
	private static final long serialVersionUID = 2655110879999292075L;
	private Long id;
	private Corp corp_id;
	private User user_id;
	private Timestamp update_timestamp;
	public Timestamp getUpdate_timestamp() {
		return update_timestamp;
	}
	public void setUpdate_timestamp(Timestamp update_timestamp) {
		this.update_timestamp = update_timestamp;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Corp getCorp_id() {
		return corp_id;
	}
	public void setCorp_id(Corp corp_id) {
		this.corp_id = corp_id;
	}
	public User getUser_id() {
		return user_id;
	}
	public void setUser_id(User user_id) {
		this.user_id = user_id;
	}
}
