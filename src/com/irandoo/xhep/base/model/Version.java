package com.irandoo.xhep.base.model;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class Version implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2865149633173254552L;
	private Long id;
	private String version_code;
	private String version_child_code;
	private String platform;
	private String download_url;
	private String  tag;
	private String status;
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date create_time;
	private String corp_code;
	private String statusShow;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getVersion_code() {
		return version_code;
	}
	public void setVersion_code(String version_code) {
		this.version_code = version_code;
	}
	public String getVersion_child_code() {
		return version_child_code;
	}
	public void setVersion_child_code(String version_child_code) {
		this.version_child_code = version_child_code;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public String getDownload_url() {
		return download_url;
	}
	public void setDownload_url(String download_url) {
		this.download_url = download_url;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public String getCorp_code() {
		return corp_code;
	}
	public void setCorp_code(String corp_code) {
		this.corp_code = corp_code;
	}
	public String getStatusShow() {
		return statusShow;
	}
	public void setStatusShow(String statusShow) {
		this.statusShow = statusShow;
	}
	
	
}
