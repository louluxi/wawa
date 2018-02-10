package com.irandoo.app.interf.json;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

/**
  * <p>Title: 意见反馈json</p>
  * <p>Description: </p>
  * <p>Company: irandoo</p> 
  * @author ager
  * @date 2018-1-8上午10:58:01
  */
public class FeedbackJson implements Serializable{
	private static final long serialVersionUID = -897990014861203748L;
	private String qCode;
	private String qName;
	private String title;
	private String qContent;
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date qDate;
	private String rCode;
	private String rName;
	private String rContent;
	private String remark;
	private String rStatus;
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date rDate;
	public String getqCode() {
		return qCode;
	}
	public String getqName() {
		return qName;
	}
	public String getTitle() {
		return title;
	}
	public String getqContent() {
		return qContent;
	}
	public Date getqDate() {
		return qDate;
	}
	public String getrCode() {
		return rCode;
	}
	public String getrName() {
		return rName;
	}
	public String getrContent() {
		return rContent;
	}
	public String getRemark() {
		return remark;
	}
	public String getrStatus() {
		return rStatus;
	}
	public Date getrDate() {
		return rDate;
	}
	public void setqCode(String qCode) {
		this.qCode = qCode;
	}
	public void setqName(String qName) {
		this.qName = qName;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setqContent(String qContent) {
		this.qContent = qContent;
	}
	public void setqDate(Date qDate) {
		this.qDate = qDate;
	}
	public void setrCode(String rCode) {
		this.rCode = rCode;
	}
	public void setrName(String rName) {
		this.rName = rName;
	}
	public void setrContent(String rContent) {
		this.rContent = rContent;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public void setrStatus(String rStatus) {
		this.rStatus = rStatus;
	}
	public void setrDate(Date rDate) {
		this.rDate = rDate;
	}
}
