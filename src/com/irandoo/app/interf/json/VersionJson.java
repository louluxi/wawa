package com.irandoo.app.interf.json;

import java.io.Serializable;

public class VersionJson implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 454860822395018257L;
	private Long id;
	private String versionCode;
	private String versionChildCode;
	private String platform;
	private String downloadUrl;
	private String tag;
	private String status;
	private String createTime;
	private String corpCode;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getVersionCode() {
		return versionCode;
	}
	public void setVersionCode(String versionCode) {
		this.versionCode = versionCode;
	}
	public String getVersionChildCode() {
		return versionChildCode;
	}
	public void setVersionChildCode(String versionChildCode) {
		this.versionChildCode = versionChildCode;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public String getDownloadUrl() {
		return downloadUrl;
	}
	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
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
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getCorpCode() {
		return corpCode;
	}
	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}
	
	
	
	

}
