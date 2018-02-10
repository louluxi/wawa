package com.irandoo.app.interf.json;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

/**
  * <p>Title: 弹幕</p>
  * <p>Description: </p>
  * <p>Company: irandoo</p> 
  * @author ager
  * @date 2018-1-8上午11:00:56
  */
public class RoomBarrageJson implements Serializable{
	private static final long serialVersionUID = -897990014861203748L;
	private String roomId;
	private String userId;
	private String content;
	private String id;
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date releaseTime;
	public String getRoomId() {
		return roomId;
	}
	public String getUserId() {
		return userId;
	}
	public String getContent() {
		return content;
	}
	public String getId() {
		return id;
	}
	public Date getReleaseTime() {
		return releaseTime;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}
}
