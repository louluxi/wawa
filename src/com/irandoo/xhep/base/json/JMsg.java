package com.irandoo.xhep.base.json;


import java.sql.Timestamp;
import java.util.List;

import com.irandoo.base.json.RandooJsonBean;

/**
 * @author LXR
 *
 */
public class JMsg extends RandooJsonBean{

	@Override
	public JMsg createBean() {
		// TODO Auto-generated method stub
		return new JMsg();
	}
		
	public int getAppendInterval() {
		return (Integer)get("appendInterval");
	}
	public void setAppendInterval(int appendInterval) {
		set("appendInterval",appendInterval);
	}
	public int getSendTimes() {
		return (Integer)get("sendTimes");
	}
	public void setSendTimes(int sendTimes) {
		set("sendTimes",sendTimes);
	}
	public Long getRecvId() {
		return (Long)get("recvId");
	}
	public void setRecvId(Long recvId) {
		set("recvId",recvId);
	}
	public String getRecvStatus() {
		return (String)get("recvStatus");
	}
	public void setRecvStatus(String recvStatus) {
		set("recvStatus",recvStatus);
	}
	public String getSendMode() {
		return (String)get("sendMode");
	}
	public void setSendMode(String sendMode) {
		set("sendMode",sendMode);
	}
	
	public String getCycleType() {
		return (String)get("cycleType");
	}
	public void setCycleType(String cycleType) {
		set("cycleType",cycleType);
	}
	public String getCycleTime() {
		return (String)get("cycleTime");
	}
	public void setCycleTime(String cycleTime) {
		set("cycleTime",cycleTime);
	}
	public Long getId() {
		return (Long)get("id");
	}
	public void setId(Long id) {
		set("id",id);
	}
	public String getTitle() {
		return (String)get("title");
	}
	public void setTitle(String title) {
		set("title",title);
	}
	public String getContent() {
		return (String)get("content");
	}
	public void setContent(String content) {
		set("content",content);
	}
	
	public String getSendStatus() {
		return (String)get("sendStatus");
	}

	public void setSendStatus(String sendStatus) {
		set("sendStatus",sendStatus);
	}
	
	public Timestamp getTriggerTime() {
		return (Timestamp)get("triggerTime");
	}
	public void setTriggerTime(Timestamp triggerTime) {
		set("triggerTime",triggerTime);
	}
	public String getTimerType() {
		return (String)get("timerType");
	}
	public void setTimerType(String timerType) {
		set("timerType",timerType);
	}
	public int getCycleInterval() {
		return (Integer)get("cycleInterval");
	}
	public void setCycleInterval(int cycleInterval) {
		set("cycleInterval",cycleInterval);
	}
	
	public String getSendUser() {
		return (String)get("sendUser");
	}
	public void setSendUser(String sendUser) {
		set("sendUser",sendUser);
	}
	public Timestamp getSendTime() {
		return (Timestamp)get("sendTime");
	}
	public void setSendTime(Timestamp sendTime) {
		set("sendTime",sendTime);
	}
	@SuppressWarnings("unchecked")
	public List<JUser> getToList() {
		return (List<JUser>)get("toList");
	}
	public void setToList(List<JUser> toList) {
		set("toList",toList);
	}
	
}
