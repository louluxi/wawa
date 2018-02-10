package com.irandoo.xhep.anth.model;

import java.io.Serializable;
import java.util.Date;

public class JwtToken implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -77610629368602145L;
	private String userid;         //用户id
	private String openid;         //open_id
	private String unionid;
	private Date expires_time;       //过期时间
	private String access_token;   //认证的Token
	private String refresh_token;  //重新刷新的Token
	private String scope;          //用户授权作用域
	private String isFirstLogin;   //是否是第一次登录
	
	public JwtToken() {

	}


	public JwtToken(String openid, String unionid, Date expires_time, String access_token, String refresh_token,
			String scope) {
		super();
		this.openid = openid;
		this.unionid = unionid;
		this.expires_time = expires_time;
		this.access_token = access_token;
		this.refresh_token = refresh_token;
		this.scope = scope;
	}



	public JwtToken(String openid, String unionid, Date expires_time, String access_token, String refresh_token,
			String scope,String isFirstLogin) {
		super();
		this.openid = openid;
		this.unionid = unionid;
		this.expires_time = expires_time;
		this.access_token = access_token;
		this.refresh_token = refresh_token;
		this.scope = scope;
		this.isFirstLogin=isFirstLogin;
	}

	public JwtToken(String userid, String openid, String unionid, Date expires_time, String access_token,
			String refresh_token, String scope) {
		super();
		this.userid = userid;
		this.openid = openid;
		this.unionid = unionid;
		this.expires_time = expires_time;
		this.access_token = access_token;
		this.refresh_token = refresh_token;
		this.scope = scope;
	}
	public JwtToken(String userid, String openid, String unionid, Date expires_time, String access_token,
			String refresh_token, String scope,String isFirstLogin) {
		super();
		this.userid = userid;
		this.openid = openid;
		this.unionid = unionid;
		this.expires_time = expires_time;
		this.access_token = access_token;
		this.refresh_token = refresh_token;
		this.scope = scope;
		this.isFirstLogin=isFirstLogin;
	}




	public String getIsFirstLogin() {
		return isFirstLogin;
	}


	public void setIsFirstLogin(String isFirstLogin) {
		this.isFirstLogin = isFirstLogin;
	}


	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public Date getExpires_time() {
		return expires_time;
	}
	public void setExpires_time(Date expires_time) {
		this.expires_time = expires_time;
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
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public String getUnionid() {
		return unionid;
	}
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}



	@Override
	public String toString() {
		return "JwtToken [userid=" + userid + ", openid=" + openid + ", unionid=" + unionid + ", expires_time="
				+ expires_time + ", access_token=" + access_token + ", refresh_token=" + refresh_token + ", scope="
				+ scope + "]";
	}






}
