package com.irandoo.app.interf.json;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

/**
  * <p>Title: 抓取记录</p>
  * <p>Description: </p>
  * <p>Company: irandoo</p> 
  * @author ager
  * @date 2018-1-8上午11:00:56
  */
public class RoomGrabJson implements Serializable{
	private static final long serialVersionUID = -897990014861203748L;
	private String roomId;
	private String roomCode;
	private String userId;
	private String merchId;
	private String nickName;
	private String userIcon;
	private String merchName;
	private String saleCode;
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date grabTime;
	private String status;
	private String snapid;
	private String gameType;
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGameType() {
		return gameType;
	}
	public void setGameType(String gameType) {
		this.gameType = gameType;
	}
	public String getRoomCode() {
		return roomCode;
	}
	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}
	public String getRoomId() {
		return roomId;
	}
	public String getSnapid() {
		return snapid;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public void setSnapid(String snapid) {
		this.snapid = snapid;
	}
	public String getUserId() {
		return userId;
	}
	public String getNickName() {
		return nickName;
	}
	public String getUserIcon() {
		return userIcon;
	}
	public String getMerchId() {
		return merchId;
	}
	public String getMerchName() {
		return merchName;
	}
	public String getSaleCode() {
		return saleCode;
	}
	public Date getGrabTime() {
		return grabTime;
	}
	public String getStatus() {
		return status;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public void setUserIcon(String userIcon) {
		this.userIcon = userIcon;
	}
	public void setMerchId(String merchId) {
		this.merchId = merchId;
	}
	public void setMerchName(String merchName) {
		this.merchName = merchName;
	}
	public void setSaleCode(String saleCode) {
		this.saleCode = saleCode;
	}
	public void setGrabTime(Date grabTime) {
		this.grabTime = grabTime;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
