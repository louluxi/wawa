package com.irandoo.xhep.base.model;

import java.io.Serializable;
/**
 * @description：历史人员
 * @author sun
 * 
 */
import java.util.Date;

public class HisUser implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3374851396038276537L;
	
	private Long id;
	private Long room_id;
	private String user_id;
	private String user_name;
	private String user_icon;
	private Date time_in;
	private Date time_out;
	private String corp_code;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getRoom_id() {
		return room_id;
	}
	public void setRoom_id(Long room_id) {
		this.room_id = room_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_icon() {
		return user_icon;
	}
	public void setUser_icon(String user_icon) {
		this.user_icon = user_icon;
	}
	public Date getTime_in() {
		return time_in;
	}
	public void setTime_in(Date time_in) {
		this.time_in = time_in;
	}

	public Date getTime_out() {
		return time_out;
	}
	public void setTime_out(Date time_out) {
		this.time_out = time_out;
	}
	public String getCorp_code() {
		return corp_code;
	}
	public void setCorp_code(String corp_code) {
		this.corp_code = corp_code;
	}
}
