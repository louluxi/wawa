package com.irandoo.app.interf.json;

import java.io.Serializable;

/**
  * <p>Title: 用户地址</p>
  * <p>Description: </p>
  * <p>Company: irandoo</p> 
  * @author ager
  * @date 2018-1-8上午11:00:56
  */
public class UserAddrJson implements Serializable{
	private static final long serialVersionUID = -897990014861203748L;
	private String id;
	private String userId;
	private String country;
	private String province;
	private String city;
	private String area;
	private String detail;
	private String isDefault;
	private String receiver;
	private String tel;
	public String getUserId() {
		return userId;
	}
	
	public String getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getId() {
		return id;
	}
	public String getCountry() {
		return country;
	}
	public String getProvince() {
		return province;
	}
	public String getCity() {
		return city;
	}
	public String getArea() {
		return area;
	}
	public String getDetail() {
		return detail;
	}
	public String getReceiver() {
		return receiver;
	}
	public String getTel() {
		return tel;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
}
