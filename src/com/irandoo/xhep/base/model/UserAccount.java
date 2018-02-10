package com.irandoo.xhep.base.model;

import java.io.Serializable;

/**
 *  账户实体类
 * @author sun
 * 2018年1月11日19:36:07
 */
public class UserAccount implements Serializable{
	private Long id;
	private Long user_id;
	private String account_type;
	private String account_name;
	private String account_desc;
	private Long balance;
	private String corp_code;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public String getAccount_type() {
		return account_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	public String getAccount_name() {
		return account_name;
	}
	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}
	public String getAccount_desc() {
		return account_desc;
	}
	public void setAccount_desc(String account_desc) {
		this.account_desc = account_desc;
	}
	public Long getBalance() {
		return balance;
	}
	public void setBalance(Long balance) {
		this.balance = balance;
	}
	public String getCorp_code() {
		return corp_code;
	}
	public void setCorp_code(String corp_code) {
		this.corp_code = corp_code;
	}

	
	
}
