package com.irandoo.xhep.base.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;


public class Corp implements Serializable{
	private static final long serialVersionUID = 9084395122394083813L;
	private Long id;
	private String corp_code;
	private String corp_name;
	private String corp_name_pinyin;
	private String corp_nationality;
	private Corp parent_id;
	private Integer level;
	private String search_key;
	private String corp_attr;
	private Timestamp create_time;
	private String is_deleted;
	private Timestamp update_timestamp;
	private Set<Corp> children;
	private Long pid;
	public String getCorp_code() {
		return corp_code;
	}
	public void setCorp_code(String corp_code) {
		this.corp_code = corp_code;
	}
	public Timestamp getUpdate_timestamp() {
		return update_timestamp;
	}
	public void setUpdate_timestamp(Timestamp update_timestamp) {
		this.update_timestamp = update_timestamp;
	}
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public Set<Corp> getChildren() {
		return children;
	}
	public void setChildren(Set<Corp> children) {
		this.children = children;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCorp_name() {
		return corp_name;
	}
	public void setCorp_name(String corp_name) {
		this.corp_name = corp_name;
	}
	public String getCorp_name_pinyin() {
		return corp_name_pinyin;
	}
	public void setCorp_name_pinyin(String corp_name_pinyin) {
		this.corp_name_pinyin = corp_name_pinyin;
	}
	public String getCorp_nationality() {
		return corp_nationality;
	}
	public void setCorp_nationality(String corp_nationality) {
		this.corp_nationality = corp_nationality;
	}
	public Corp getParent_id() {
		return parent_id;
	}
	public void setParent_id(Corp parent_id) {
		this.parent_id = parent_id;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public String getSearch_key() {
		return search_key;
	}
	public void setSearch_key(String search_key) {
		this.search_key = search_key;
	}
	public String getCorp_attr() {
		return corp_attr;
	}
	public void setCorp_attr(String corp_attr) {
		this.corp_attr = corp_attr;
	}
	public Timestamp getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Timestamp create_time) {
		this.create_time = create_time;
	}
	public String getIs_deleted() {
		return is_deleted;
	}
	public void setIs_deleted(String is_deleted) {
		this.is_deleted = is_deleted;
	}
	
}
