package com.irandoo.xhep.base.model;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author nuoxin
 *
 */
public class UserMerch implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5567126243200992331L;

	private String id;
	private String user_id;
	private String room_id;
	private String merch_id;
	private String grab_id;
	private String status;
	private String recharge_id;
	private String order_id;
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date grab_time;
	private String corp_code;
	private String statusShow;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getRoom_id() {
		return room_id;
	}
	public void setRoom_id(String room_id) {
		this.room_id = room_id;
	}
	public String getMerch_id() {
		return merch_id;
	}
	public void setMerch_id(String merch_id) {
		this.merch_id = merch_id;
	}
	public String getGrab_id() {
		return grab_id;
	}
	public void setGrab_id(String grab_id) {
		this.grab_id = grab_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRecharge_id() {
		return recharge_id;
	}
	public void setRecharge_id(String recharge_id) {
		this.recharge_id = recharge_id;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public Date getGrab_time() {
		return grab_time;
	}
	public void setGrab_time(Date grab_time) {
		this.grab_time = grab_time;
	}
	public String getCorp_code() {
		return corp_code;
	}
	public void setCorp_code(String corp_code) {
		this.corp_code = corp_code;
	}
	public String getStatusShow() {
		return statusShow;
	}
	public void setStatusShow(String statusShow) {
		this.statusShow = statusShow;
	}

	
	
}
