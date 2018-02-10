package com.irandoo.xhep.base.json;

import java.sql.Timestamp;
import java.util.List;

import com.irandoo.base.json.RandooJsonBean;

public class JSendMsg extends RandooJsonBean{

	@Override
	public JSendMsg createBean() {
		// TODO Auto-generated method stub
		return new JSendMsg();
	}
	
	
	public int getAppendInterval() {
		return (Integer)get("appendInterval");
	}
	public void setAppendInterval(int appendInterval) {
		set("appendInterval",appendInterval);
	}
	public String getFromType() {
		return (String)get("fromType");
	}
	public void setFromType(String fromType) {
		set("fromType",fromType);
	}
	public String getSendFrom() {
		return (String)get("sendFrom");
	}
	public void setSendFrom(String sendFrom) {
		set("sendFrom",sendFrom);
	}
	public int getSendTimes() {
		return (Integer)get("sendTimes");
	}
	public void setSendTimes(int sendTimes) {
		set("sendTimes",sendTimes);
	}
	public Long getSendId() {
		return (Long)get("sendId");
	}
	public void setSendId(Long sendId) {
		set("sendId",sendId);
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
	public String getSendMode() {
		return (String)get("sendMode");
	}
	public void setSendMode(String sendMode) {
		set("sendMode",sendMode);
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

	public String getFrom() {
		return (String)get("from");
	}

	public void setFrom(String from) {
		set("from",from);
	}

	@SuppressWarnings("unchecked")
	public List<JTo> getToList() {
		return (List<JTo>)get("toList");
	}
	public void setToList(List<JTo> toList) {
		set("toList",toList);
	}

}
