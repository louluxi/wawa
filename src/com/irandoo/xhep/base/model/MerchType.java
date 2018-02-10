package com.irandoo.xhep.base.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class MerchType implements Serializable{

	private static final long serialVersionUID = -8243458958064101283L;
    private Long id;
    private String type_code;
    private String type_name;
    private String type_desc;
    private Long parent;
    private Integer level;
    private String icon_path;
    private String is_root;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date create_time;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Timestamp update_timestamp;
    private String corp_code;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType_code() {
		return type_code;
	}
	public void setType_code(String type_code) {
		this.type_code = type_code;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	public String getType_desc() {
		return type_desc;
	}
	public void setType_desc(String type_desc) {
		this.type_desc = type_desc;
	}
	public Long getParent() {
		return parent;
	}
	public void setParent(Long parent) {
		this.parent = parent;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public String getIcon_path() {
		return icon_path;
	}
	public void setIcon_path(String icon_path) {
		this.icon_path = icon_path;
	}
	public String getIs_root() {
		return is_root;
	}
	public void setIs_root(String is_root) {
		this.is_root = is_root;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Timestamp getUpdate_timestamp() {
		return update_timestamp;
	}
	public void setUpdate_timestamp(Timestamp update_timestamp) {
		this.update_timestamp = update_timestamp;
	}
	public String getCorp_code() {
		return corp_code;
	}
	public void setCorp_code(String corp_code) {
		this.corp_code = corp_code;
	}   
    
}
