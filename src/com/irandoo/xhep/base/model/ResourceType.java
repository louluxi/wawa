package com.irandoo.xhep.base.model;

import java.io.Serializable;
import java.sql.Timestamp;

import com.alibaba.fastjson.annotation.JSONField;

public class ResourceType implements Serializable{
	private static final long serialVersionUID = 7299570272464826513L;
	private Long id;
	private String resource_type_id;
	private String resource_type_name;
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
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
	public String getResource_type_id() {
		return resource_type_id;
	}
	public void setResource_type_id(String resource_type_id) {
		this.resource_type_id = resource_type_id;
	}
	public String getResource_type_name() {
		return resource_type_name;
	}
	public void setResource_type_name(String resource_type_name) {
		this.resource_type_name = resource_type_name;
	}
	
}
