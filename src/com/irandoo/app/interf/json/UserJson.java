package com.irandoo.app.interf.json;

import java.io.Serializable;

/**
  * <p>Title: 用户</p>
  * <p>Description: </p>
  * <p>Company: irandoo</p> 
  * @author ager
  * @date 2018-1-9下午3:12:47
  */
public class UserJson implements Serializable{
	private static final long serialVersionUID = -897990014861203748L;
	private String userId;
	private String userCode;
	private String userPwd;
	private String userName;
	private String nickName;
	private String invitateCode;
	private String invitatedCode;
	private String birthday;
	private String zip;
	private String tel;
	private String qq;
	private String wechat;
	private String userIcon;
	private String userEmail;
	private String userAge;
	private String gender;
	private String phone;
	public String getInvitatedCode() {
		return invitatedCode;
	}
	public void setInvitatedCode(String invitatedCode) {
		this.invitatedCode = invitatedCode;
	}
	public String getUserId() {
		return userId;
	}
	public String getUserCode() {
		return userCode;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public String getUserName() {
		return userName;
	}
	public String getNickName() {
		return nickName;
	}
	public String getInvitateCode() {
		return invitateCode;
	}
	public String getBirthday() {
		return birthday;
	}
	public String getZip() {
		return zip;
	}
	public String getTel() {
		return tel;
	}
	public String getQq() {
		return qq;
	}
	public String getWechat() {
		return wechat;
	}
	public String getUserIcon() {
		return userIcon;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public String getUserAge() {
		return userAge;
	}
	public String getGender() {
		return gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public void setInvitateCode(String invitateCode) {
		this.invitateCode = invitateCode;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public void setWechat(String wechat) {
		this.wechat = wechat;
	}
	public void setUserIcon(String userIcon) {
		this.userIcon = userIcon;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public void setUserAge(String userAge) {
		this.userAge = userAge;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
