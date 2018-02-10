package com.irandoo.app.interf.json;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

/**
  * <p>Title: 账户明细</p>
  * <p>Description: </p>
  * <p>Company: irandoo</p> 
  * @author ager
  * @date 2018-1-9下午3:17:40
  */
public class RechargeRecordJson implements Serializable{
	private static final long serialVersionUID = -897990014861203748L;
	private String id;
	private String roomId;
	private String userId;
	private String mealId;
	private String rechargeOrderId;
	private String rechargeUserId;
	private String orderMoney;
	private String exchangeCoin;
	private String rewardCoin;
	private String payType;
	private String type;
	private String payMoney;
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date rechangeTime;
	private String mealName;
	private String userName;
	public String getId() {
		return id;
	}
	public String getRoomId() {
		return roomId;
	}
	public String getUserId() {
		return userId;
	}
	public String getMealId() {
		return mealId;
	}
	public String getRechargeOrderId() {
		return rechargeOrderId;
	}
	public String getRechargeUserId() {
		return rechargeUserId;
	}
	public String getOrderMoney() {
		return orderMoney;
	}
	public String getExchangeCoin() {
		return exchangeCoin;
	}
	public String getRewardCoin() {
		return rewardCoin;
	}
	public String getPayType() {
		return payType;
	}
	public String getType() {
		return type;
	}
	public String getPayMoney() {
		return payMoney;
	}
	public Date getRechangeTime() {
		return rechangeTime;
	}
	public String getMealName() {
		return mealName;
	}
	public String getUserName() {
		return userName;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setMealId(String mealId) {
		this.mealId = mealId;
	}
	public void setRechargeOrderId(String rechargeOrderId) {
		this.rechargeOrderId = rechargeOrderId;
	}
	public void setRechargeUserId(String rechargeUserId) {
		this.rechargeUserId = rechargeUserId;
	}
	public void setOrderMoney(String orderMoney) {
		this.orderMoney = orderMoney;
	}
	public void setExchangeCoin(String exchangeCoin) {
		this.exchangeCoin = exchangeCoin;
	}
	public void setRewardCoin(String rewardCoin) {
		this.rewardCoin = rewardCoin;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setPayMoney(String payMoney) {
		this.payMoney = payMoney;
	}
	public void setRechangeTime(Date rechangeTime) {
		this.rechangeTime = rechangeTime;
	}
	public void setMealName(String mealName) {
		this.mealName = mealName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
