package com.irandoo.xhep.base.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class CorpRole implements Serializable{
	private static final long serialVersionUID = -4710464036362603199L;
	private Long id;
	private Corp corp_id;
	private Role role_id;
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
	public Role getRole_id() {
		return role_id;
	}
	public void setRole_id(Role role_id) {
		this.role_id = role_id;
	}
	
}
