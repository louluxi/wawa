package com.irandoo.app.interf.json;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class PrivateRoomJson implements Serializable{
	
	private static final long serialVersionUID = -897934374861203748L;
	
	private String id;
	private String roomId;
	private String creator;
	private String roomName;
	private String roomIcon;
	private String roomCode;
	private String roomType;
	private String duration;
	private String moneyMinute;
	private String sumMoney;	
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date startTime;
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date endTime;
	private String coinOnce;
	private String sumPerson;
	private String status;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	
	public String getRoomCode() {
		return roomCode;
	}
	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getSumMoney() {
		return sumMoney;
	}
	public void setSumMoney(String sumMoney) {
		this.sumMoney = sumMoney;
	}
	public String getCoinOnce() {
		return coinOnce;
	}
	public void setCoinOnce(String coinOnce) {
		this.coinOnce = coinOnce;
	}
	public String getRoomIcon() {
		return roomIcon;
	}
	public void setRoomIcon(String roomIcon) {
		this.roomIcon = roomIcon;
	}
	public String getSumPerson() {
		return sumPerson;
	}
	public void setSumPerson(String sumPerson) {
		this.sumPerson = sumPerson;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getMoneyMinute() {
		return moneyMinute;
	}
	public void setMoneyMinute(String moneyMinute) {
		this.moneyMinute = moneyMinute;
	}
}
