package com.irandoo.xhep.base.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

public class Menu implements Serializable {
	private static final long serialVersionUID = -3613789712273716716L;
	private Long id;
	private String resource_id;
	private String resource_name;
	private String resource_desc;
	private Long resource_type_id;
	private Integer display_order;
	private Long parent_id;
	private Integer level;
	private String search_key;
	private String perm_id;
	private String url;
	private String target;
	private String is_open;
	private String is_show;
	private String icon_img;
	private String icon_open_img;
	private String is_data_control;
	private String data_control_constant;
	private String data_parent_id;
	private String is_root;
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Timestamp update_timestamp;
	
	private List<Menu> childrenList;
	private String typeShow;
	public String getTypeShow() {
		return typeShow;
	}
	public void setTypeShow(String typeShow) {
		this.typeShow = typeShow;
	}
	public List<Menu> getChildrenList() {
		return childrenList;
	}
	public void setChildrenList(List<Menu> childrenList) {
		this.childrenList = childrenList;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getResource_id() {
		return resource_id;
	}
	public void setResource_id(String resource_id) {
		this.resource_id = resource_id;
	}
	public String getResource_name() {
		return resource_name;
	}
	public void setResource_name(String resource_name) {
		this.resource_name = resource_name;
	}
	public String getResource_desc() {
		return resource_desc;
	}
	public void setResource_desc(String resource_desc) {
		this.resource_desc = resource_desc;
	}
	public Long getResource_type_id() {
		return resource_type_id;
	}
	public void setResource_type_id(Long resource_type_id) {
		this.resource_type_id = resource_type_id;
	}
	public Integer getDisplay_order() {
		return display_order;
	}
	public void setDisplay_order(Integer display_order) {
		this.display_order = display_order;
	}
	public Long getParent_id() {
		return parent_id;
	}
	public void setParent_id(Long parent_id) {
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
	public String getPerm_id() {
		return perm_id;
	}
	public void setPerm_id(String perm_id) {
		this.perm_id = perm_id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getIs_open() {
		return is_open;
	}
	public void setIs_open(String is_open) {
		this.is_open = is_open;
	}
	public String getIs_show() {
		return is_show;
	}
	public void setIs_show(String is_show) {
		this.is_show = is_show;
	}
	public String getIcon_img() {
		return icon_img;
	}
	public void setIcon_img(String icon_img) {
		this.icon_img = icon_img;
	}
	public String getIcon_open_img() {
		return icon_open_img;
	}
	public void setIcon_open_img(String icon_open_img) {
		this.icon_open_img = icon_open_img;
	}
	public String getIs_data_control() {
		return is_data_control;
	}
	public void setIs_data_control(String is_data_control) {
		this.is_data_control = is_data_control;
	}
	public String getData_control_constant() {
		return data_control_constant;
	}
	public void setData_control_constant(String data_control_constant) {
		this.data_control_constant = data_control_constant;
	}
	public String getData_parent_id() {
		return data_parent_id;
	}
	public void setData_parent_id(String data_parent_id) {
		this.data_parent_id = data_parent_id;
	}
	public String getIs_root() {
		return is_root;
	}
	public void setIs_root(String is_root) {
		this.is_root = is_root;
	}
	public Timestamp getUpdate_timestamp() {
		return update_timestamp;
	}
	public void setUpdate_timestamp(Timestamp update_timestamp) {
		this.update_timestamp = update_timestamp;
	}
	
	
	
}
