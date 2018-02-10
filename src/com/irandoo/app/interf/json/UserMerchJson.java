package com.irandoo.app.interf.json;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

/**
  * <p>Title: 用户抓中记录</p>
  * <p>Description: </p>
  * <p>Company: irandoo</p> 
  * @author ager
  * @date 2018-1-8上午11:00:56
  */
public class UserMerchJson implements Serializable{
	private static final long serialVersionUID = -897990014861203748L;
	private String id;
	private String roomId;
	private String roomName;
	private String merchId;
	private String merchName;
	private String merchIcon;
	private String grabId;
	private String status;
	private String rechargeId;
	private String orderId;
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date grabTime;
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date optionTime;
	private String couldGetCoin;
	private String nowGetCoin;
	private String userId;
	public String getId() {
		return id;
	}
	public String getRoomId() {
		return roomId;
	}
	public String getRoomName() {
		return roomName;
	}
	public String getMerchId() {
		return merchId;
	}
	public String getMerchName() {
		return merchName;
	}
	public String getMerchIcon() {
		return merchIcon;
	}
	public String getGrabId() {
		return grabId;
	}
	public String getStatus() {
		return status;
	}
	public String getRechargeId() {
		return rechargeId;
	}
	public String getOrderId() {
		return orderId;
	}
	public Date getGrabTime() {
		return grabTime;
	}
	public Date getOptionTime() {
		return optionTime;
	}
	public String getCouldGetCoin() {
		return couldGetCoin;
	}
	public String getNowGetCoin() {
		return nowGetCoin;
	}
	public String getUserId() {
		return userId;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public void setMerchId(String merchId) {
		this.merchId = merchId;
	}
	public void setMerchName(String merchName) {
		this.merchName = merchName;
	}
	public void setMerchIcon(String merchIcon) {
		this.merchIcon = merchIcon;
	}
	public void setGrabId(String grabId) {
		this.grabId = grabId;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setRechargeId(String rechargeId) {
		this.rechargeId = rechargeId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public void setGrabTime(Date grabTime) {
		this.grabTime = grabTime;
	}
	public void setOptionTime(Date optionTime) {
		this.optionTime = optionTime;
	}
	public void setCouldGetCoin(String couldGetCoin) {
		this.couldGetCoin = couldGetCoin;
	}
	public void setNowGetCoin(String nowGetCoin) {
		this.nowGetCoin = nowGetCoin;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
