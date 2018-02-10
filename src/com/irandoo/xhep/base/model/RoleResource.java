package com.irandoo.xhep.base.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class RoleResource implements Serializable{
	private static final long serialVersionUID = -6444029997252940008L;
	private Long id;
	private Long role_id;
	private Long resource_id;
	private Timestamp update_timestamp;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getRole_id() {
		return role_id;
	}
	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}
	public Long getResource_id() {
		return resource_id;
	}
	public void setResource_id(Long resource_id) {
		this.resource_id = resource_id;
	}
	public Timestamp getUpdate_timestamp() {
		return update_timestamp;
	}
	public void setUpdate_timestamp(Timestamp update_timestamp) {
		this.update_timestamp = update_timestamp;
	}
}
