package com.irandoo.xhep.base.model;

import java.io.Serializable;

public class RoomClassJson implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3080659280814537505L;
	private String class_name;
	private Long id;
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "RoomClassJson [class_name=" + class_name + ", id=" + id + "]";
	}
	
}
