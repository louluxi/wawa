package com.irandoo.support.alipay.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class AliPayPrivateRoom implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 760798229515519460L;
	private Long id;
	private Long room_id;
	private Long creator;
	private Long room_name;
	private String room_type;
	private String status;
	private String duration;
	private Long money_minute;
	private String coin_once;
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
	public Long getRoom_id() {
		return room_id;
	}
	public void setRoom_id(Long room_id) {
		this.room_id = room_id;
	}
	public Long getCreator() {
		return creator;
	}
	public void setCreator(Long creator) {
		this.creator = creator;
	}
	public Long getRoom_name() {
		return room_name;
	}
	public void setRoom_name(Long room_name) {
		this.room_name = room_name;
	}
	public String getRoom_type() {
		return room_type;
	}
	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public Long getMoney_minute() {
		return money_minute;
	}
	public void setMoney_minute(Long money_minute) {
		this.money_minute = money_minute;
	}
	public String getCoin_once() {
		return coin_once;
	}
	public void setCoin_once(String coin_once) {
		this.coin_once = coin_once;
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
