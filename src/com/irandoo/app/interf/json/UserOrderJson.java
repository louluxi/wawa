package com.irandoo.app.interf.json;

import java.io.Serializable;

/**
  * <p>Title: 用户订单</p>
  * <p>Description: </p>
  * <p>Company: irandoo</p> 
  * @author ager
  * @date 2018-1-9下午3:12:47
  */
public class UserOrderJson implements Serializable{
	private static final long serialVersionUID = -897990014861203748L;
	private String id;
	private String userId;
	private String orderType;
	private String orderCode;
	private String merchId;
	private String saleCode;
	private String addressId;
	private String status;
	private String expressNo;
	private String expressCompany;
	private String sendUserId;
	private String addrId;
	private String wawaId;//添加一个会员娃娃的编号
	public String getAddrId() {
		return addrId;
	}
	public void setAddrId(String addrId) {
		this.addrId = addrId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public String getOrderType() {
		return orderType;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public String getMerchId() {
		return merchId;
	}
	public String getSaleCode() {
		return saleCode;
	}
	public String getAddressId() {
		return addressId;
	}
	public String getStatus() {
		return status;
	}
	public String getExpressNo() {
		return expressNo;
	}
	public String getExpressCompany() {
		return expressCompany;
	}
	public String getSendUserId() {
		return sendUserId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public void setMerchId(String merchId) {
		this.merchId = merchId;
	}
	public void setSaleCode(String saleCode) {
		this.saleCode = saleCode;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setExpressNo(String expressNo) {
		this.expressNo = expressNo;
	}
	public void setExpressCompany(String expressCompany) {
		this.expressCompany = expressCompany;
	}
	public void setSendUserId(String sendUserId) {
		this.sendUserId = sendUserId;
	}
	public String getWawaId() {
		return wawaId;
	}
	public void setWawaId(String wawaId) {
		this.wawaId = wawaId;
	}
	
}
