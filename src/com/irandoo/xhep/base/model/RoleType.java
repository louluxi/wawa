package com.irandoo.xhep.base.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class RoleType implements Serializable{
	private static final long serialVersionUID = -8127503206619638877L;
	private Long id;
	private String type_id;
	private String type_name;
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
	public String getType_id() {
		return type_id;
	}
	public void setType_id(String type_id) {
		this.type_id = type_id;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	
}
