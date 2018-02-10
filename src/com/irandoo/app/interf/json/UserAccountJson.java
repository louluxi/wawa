package com.irandoo.app.interf.json;

import java.io.Serializable;

/**
  * <p>Title: 用户账户</p>
  * <p>Description: </p>
  * <p>Company: irandoo</p> 
  * @author ager
  * @date 2018-1-17上午10:49:59
  */
public class UserAccountJson implements Serializable{
	private static final long serialVersionUID = -897990014861203748L;
	private String id;
	private String userId;
	private String accountType;
	private String accountName;
	private String accountDesc;
	private String balance;
	public String getId() {
		return id;
	}
	public String getUserId() {
		return userId;
	}
	public String getAccountType() {
		return accountType;
	}
	public String getAccountName() {
		return accountName;
	}
	public String getAccountDesc() {
		return accountDesc;
	}
	public String getBalance() {
		return balance;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public void setAccountDesc(String accountDesc) {
		this.accountDesc = accountDesc;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
}
