package com.irandoo.xhep.base.model;

import java.io.Serializable;
import java.sql.Timestamp;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author ager
 * @version 1.0 
 */
public class Role implements Serializable{
	private static final long serialVersionUID = -3613789712273716716L;
	private Long id;
	private String role_id;
	private String role_name;
	private String role_desc;
	private Long role_type_id;
	private Integer level;
	private String search_key;
	private Integer priority;
	private String is_used;
	private Integer order_by;
	private Long parent_id;
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Timestamp update_timestamp;
	private String resourceIds;
	public String getResourceIds() {
		return resourceIds;
	}
	public void setResourceIds(String resourceIds) {
		this.resourceIds = resourceIds;
	}
	public Timestamp getUpdate_timestamp() {
		return update_timestamp;
	}
	public void setUpdate_timestamp(Timestamp update_timestamp) {
		this.update_timestamp = update_timestamp;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRole_id() {
		return role_id;
	}
	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public String getRole_desc() {
		return role_desc;
	}
	public void setRole_desc(String role_desc) {
		this.role_desc = role_desc;
	}
	public Integer getLevel() {
		return level;
	}
	public Long getRole_type_id() {
		return role_type_id;
	}
	public void setRole_type_id(Long role_type_id) {
		this.role_type_id = role_type_id;
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
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public String getIs_used() {
		return is_used;
	}
	public void setIs_used(String is_used) {
		this.is_used = is_used;
	}
	public Integer getOrder_by() {
		return order_by;
	}
	public void setOrder_by(Integer order_by) {
		this.order_by = order_by;
	}
	public Long getParent_id() {
		return parent_id;
	}
	public void setParent_id(Long parent_id) {
		this.parent_id = parent_id;
	}
	
}
