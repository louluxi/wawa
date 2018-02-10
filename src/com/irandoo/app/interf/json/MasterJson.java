package com.irandoo.app.interf.json;

import java.io.Serializable;

/**
  * <p>Title: 娃娃达人</p>
  * <p>Description: </p>
  * <p>Company: irandoo</p> 
  * @author ager
  * @date 2018-1-8上午11:02:20
  */
public class MasterJson implements Serializable{
	private static final long serialVersionUID = -897990014861203748L;
	private String openId;
	private String userId;
	private String userName;
	private String userIcon;
	private String mastNum;
	private String successNum;
	public String getSuccessNum() {
		return successNum;
	}
	public void setSuccessNum(String successNum) {
		this.successNum = successNum;
	}
	public String getOpenId() {
		return openId;
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
	public String getMastNum() {
		return mastNum;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
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
	public void setMastNum(String mastNum) {
		this.mastNum = mastNum;
	}
}
