package com.irandoo.xhep.base.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class UserRole implements Serializable {
	private static final long serialVersionUID = 4270659855143375468L;
	private Long id;
	private Long user_id;
	private Long role_id;
	private Timestamp update_timestamp;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public Long getRole_id() {
		return role_id;
	}
	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}
	public Timestamp getUpdate_timestamp() {
		return update_timestamp;
	}
	public void setUpdate_timestamp(Timestamp update_timestamp) {
		this.update_timestamp = update_timestamp;
	}
}
