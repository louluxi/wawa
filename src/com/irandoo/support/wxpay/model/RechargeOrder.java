package com.irandoo.support.wxpay.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class RechargeOrder implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5278754276319006882L;
	private Long id;
	private String orderId;
	private Long roomId;
	private Long privateRoomId;
	private Long buyUserId;
	private Long receiveUserId;
	private Long mealId;
	private Long payMoney;
	private String payType;
	private Long state;
	private Date createTime;
	private String isDeleted;
	private Timestamp timestamp;
	private String corpCode;
	
	
	public String getCorpCode() {
		return corpCode;
	}
	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public Long getRoomId() {
		return roomId;
	}
	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}
	public Long getPrivateRoomId() {
		return privateRoomId;
	}
	public void setPrivateRoomId(Long privateRoomId) {
		this.privateRoomId = privateRoomId;
	}
	public Long getBuyUserId() {
		return buyUserId;
	}
	public void setBuyUserId(Long buyUserId) {
		this.buyUserId = buyUserId;
	}
	public Long getReceiveUserId() {
		return receiveUserId;
	}
	public void setReceiveUserId(Long receiveUserId) {
		this.receiveUserId = receiveUserId;
	}
	public Long getMealId() {
		return mealId;
	}
	public void setMealId(Long mealId) {
		this.mealId = mealId;
	}

	public Long getPayMoney() {
		return payMoney;
	}
	public void setPayMoney(Long payMoney) {
		this.payMoney = payMoney;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	public Long getState() {
		return state;
	}
	public void setState(Long state) {
		this.state = state;
	}


}
