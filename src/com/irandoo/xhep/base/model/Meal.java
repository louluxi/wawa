package com.irandoo.xhep.base.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class Meal implements Serializable{
	private static final long serialVersionUID = -7420429544161473178L;
	private Long id;
	private Long price;
	private Long doll_coin;
	private Long reward_coin;
	private String name;
	private String remark;
	private String status;
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date validity_start;
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date validity_end;
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date create_time;
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Timestamp update_timestamp;
	private String corp_code;
    private String stateShow;
   
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getReward_coin() {
		return reward_coin;
	}
	public void setReward_coin(Long reward_coin) {
		this.reward_coin = reward_coin;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Long getDoll_coin() {
		return doll_coin;
	}
	public void setDoll_coin(Long doll_coin) {
		this.doll_coin = doll_coin;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getValidity_start() {
		return validity_start;
	}
	public void setValidity_start(Date validity_start) {
		this.validity_start = validity_start;
	}
	public Date getValidity_end() {
		return validity_end;
	}
	public void setValidity_end(Date validity_end) {
		this.validity_end = validity_end;
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
	public String getStateShow() {
		return stateShow;
	}
	public void setStateShow(String stateShow) {
		this.stateShow = stateShow;
	}



	
	
	
}
