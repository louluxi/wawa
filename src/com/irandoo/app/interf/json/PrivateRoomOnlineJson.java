package com.irandoo.app.interf.json;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class PrivateRoomOnlineJson implements Serializable{
	
	private static final long serialVersionUID = -897444374868893748L;
	
	private String id;
	private String roomId;
	private String userId;
	private String userName;
	private String userIcon;
	private String status;
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date applyTime;
	public String getId() {
		return id;
	}
	public String getRoomId() {
		return roomId;
	}
	public String getUserId() {
		return userId;
	}
	public String getUserName() {
		return userName;
	}
	public String getUserIcon() {
		return userIcon;
	}
	public String getStatus() {
		return status;
	}
	public Date getApplyTime() {
		return applyTime;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setUserIcon(String userIcon) {
		this.userIcon = userIcon;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}
}
