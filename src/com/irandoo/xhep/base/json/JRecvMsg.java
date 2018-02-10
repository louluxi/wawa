package com.irandoo.xhep.base.json;

import java.sql.Timestamp;
import java.util.Date;

import com.irandoo.base.json.RandooJsonBean;

public class JRecvMsg extends RandooJsonBean{

	@Override
	public JRecvMsg createBean() {
		// TODO Auto-generated method stub
		return new JRecvMsg();
	}
	
	public Long getRecvId() {
		return (Long)get("recvId");
	}
	public void setRecvId(Long recvId) {
		set("recvId",recvId);
	}
	public long getSendId() {
		return (Long)get("sendId");
	}
	public void setSendId(long sendId) {
		set("sendId",sendId);
	}
//	public String getSendUser() {
//		return (String)get("sendUser");
//	}
//
//	public void setSendUser(String sendUser) {
//		set("sendUser",sendUser);
//	}

	public String getFrom() {
		return (String)get("from");
	}
	public void setFrom(String from) {
		set("from",from);
	}
	public Timestamp getSendTime() {
		return (Timestamp)get("sendTime");
	}
	public void setSendTime(Timestamp sendTime) {
		set("sendTime",sendTime);
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
	
}
