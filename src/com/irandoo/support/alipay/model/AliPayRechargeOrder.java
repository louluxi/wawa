package com.irandoo.support.alipay.model;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.sun.jna.platform.win32.Sspi.TimeStamp;

public class AliPayRechargeOrder implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2691387228612235854L;
    private Long id;
    private String order_id;
    private Long room_id;
    private Long private_room_id;
    private Long buy_user_id;
    private Long receive_user_id;
    private Long meal_id;
    private Long pay_money;
    private String pay_type;
    private Integer state;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date create_time;
    private String is_deleted;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private TimeStamp update_timestamp;
    private String corp_code;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public Long getRoom_id() {
		return room_id;
	}
	public void setRoom_id(Long room_id) {
		this.room_id = room_id;
	}
	public Long getPrivate_room_id() {
		return private_room_id;
	}
	public void setPrivate_room_id(Long private_room_id) {
		this.private_room_id = private_room_id;
	}
	public Long getBuy_user_id() {
		return buy_user_id;
	}
	public void setBuy_user_id(Long buy_user_id) {
		this.buy_user_id = buy_user_id;
	}
	public Long getReceive_user_id() {
		return receive_user_id;
	}
	public void setReceive_user_id(Long receive_user_id) {
		this.receive_user_id = receive_user_id;
	}
	public Long getMeal_id() {
		return meal_id;
	}
	public void setMeal_id(Long meal_id) {
		this.meal_id = meal_id;
	}
	
	public Long getPay_money() {
		return pay_money;
	}
	public void setPay_money(Long pay_money) {
		this.pay_money = pay_money;
	}
	public String getPay_type() {
		return pay_type;
	}
	public void setPay_type(String pay_type) {
		this.pay_type = pay_type;
	}
	
	public String getIs_deleted() {
		return is_deleted;
	}
	public void setIs_deleted(String is_deleted) {
		this.is_deleted = is_deleted;
	}
	
	public String getCorp_code() {
		return corp_code;
	}
	public void setCorp_code(String corp_code) {
		this.corp_code = corp_code;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public TimeStamp getUpdate_timestamp() {
		return update_timestamp;
	}
	public void setUpdate_timestamp(TimeStamp update_timestamp) {
		this.update_timestamp = update_timestamp;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
    
}
