package com.irandoo.xhep.base.model;

import java.io.Serializable;
import java.util.Date;

public class Login implements Serializable{
	private static final long serialVersionUID = -3258289657863697989L;
	private Long id;
	private String user_id;
	private String user_alias;
	private String user_name;
	private String session_id;
	private String login_mode;
	private String access_token;
	private String refresh_token;
	private String authorization;
	private String mode_type;
	private String mode_code;
	private String login_b_host;
	private String login_s_host;
	private Date login_time;
	private Date logout_time;
	private String corp_code;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_alias() {
		return user_alias;
	}
	public void setUser_alias(String user_alias) {
		this.user_alias = user_alias;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getSession_id() {
		return session_id;
	}
	public void setSession_id(String session_id) {
		this.session_id = session_id;
	}
	public String getLogin_b_host() {
		return login_b_host;
	}
	public void setLogin_b_host(String login_b_host) {
		this.login_b_host = login_b_host;
	}
	public String getLogin_s_host() {
		return login_s_host;
	}
	public void setLogin_s_host(String login_s_host) {
		this.login_s_host = login_s_host;
	}
	public Date getLogin_time() {
		return login_time;
	}
	public void setLogin_time(Date login_time) {
		this.login_time = login_time;
	}
	public Date getLogout_time() {
		return logout_time;
	}
	public void setLogout_time(Date logout_time) {
		this.logout_time = logout_time;
	}
	public String getLogin_mode() {
		return login_mode;
	}
	public void setLogin_mode(String login_mode) {
		this.login_mode = login_mode;
	}
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public String getRefresh_token() {
		return refresh_token;
	}
	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}
	public String getAuthorization() {
		return authorization;
	}
	public void setAuthorization(String authorization) {
		this.authorization = authorization;
	}
	public String getMode_type() {
		return mode_type;
	}
	public void setMode_type(String mode_type) {
		this.mode_type = mode_type;
	}
	public String getMode_code() {
		return mode_code;
	}
	public void setMode_code(String mode_code) {
		this.mode_code = mode_code;
	}
	public String getCorp_code() {
		return corp_code;
	}
	public void setCorp_code(String corp_code) {
		this.corp_code = corp_code;
	}
	
	
}
