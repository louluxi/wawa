package com.irandoo.app.interf.json;

import java.io.Serializable;

/**
  * <p>Title: 房间在线人员json</p>
  * <p>Description: </p>
  * <p>Company: irandoo</p> 
  * @author ager
  * @date 2018-1-8上午10:56:28
  */
public class RoomOnlineJson implements Serializable{
	private static final long serialVersionUID = -897990014861203748L;
	private String roomId;
	private String userId;
	private String userCode;
	private String userName;
	private String userIcon;
	private String isUsed;
	private String openId;
	private String city;
	private String gender;
	private String mastNum;
	private String status;
	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public String getUserId() {
		return userId;
	}
	public String getUserCode() {
		return userCode;
	}
	public String getUserName() {
		return userName;
	}
	public String getUserIcon() {
		return userIcon;
	}
	public String getIsUsed() {
		return isUsed;
	}
	public String getOpenId() {
		return openId;
	}
	public String getCity() {
		return city;
	}
	public String getGender() {
		return gender;
	}
	public String getMastNum() {
		return mastNum;
	}
	public String getStatus() {
		return status;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setUserIcon(String userIcon) {
		this.userIcon = userIcon;
	}
	public void setIsUsed(String isUsed) {
		this.isUsed = isUsed;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setMastNum(String mastNum) {
		this.mastNum = mastNum;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
