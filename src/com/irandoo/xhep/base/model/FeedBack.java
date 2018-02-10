package com.irandoo.xhep.base.model;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class FeedBack implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 771977658567054235L;

	private Long id;
	private String q_code;
	private String q_name;
	private String title;
	private String q_content;
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date q_date;
	private String r_code;
	private String r_name;
	private String r_content;
	private String remark;
	private String r_staus;
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date r_date;
	private String corp_code;
	private String stausShow;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getQ_code() {
		return q_code;
	}
	public void setQ_code(String q_code) {
		this.q_code = q_code;
	}
	public String getQ_name() {
		return q_name;
	}
	public void setQ_name(String q_name) {
		this.q_name = q_name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getQ_date() {
		return q_date;
	}
	public void setQ_date(Date q_date) {
		this.q_date = q_date;
	}
	public String getR_code() {
		return r_code;
	}
	public void setR_code(String r_code) {
		this.r_code = r_code;
	}
	public String getR_name() {
		return r_name;
	}
	public void setR_name(String r_name) {
		this.r_name = r_name;
	}
	public String getR_content() {
		return r_content;
	}
	public void setR_content(String r_content) {
		this.r_content = r_content;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getR_date() {
		return r_date;
	}
	public void setR_date(Date r_date) {
		this.r_date = r_date;
	}
	public String getCorp_code() {
		return corp_code;
	}
	public void setCorp_code(String corp_code) {
		this.corp_code = corp_code;
	}
	public String getQ_content() {
		return q_content;
	}
	public void setQ_content(String q_content) {
		this.q_content = q_content;
	}
	public String getR_staus() {
		return r_staus;
	}
	public void setR_staus(String r_staus) {
		this.r_staus = r_staus;
	}
	public String getStausShow() {
		return stausShow;
	}
	public void setStausShow(String stausShow) {
		this.stausShow = stausShow;
	}
	
	
	
}
