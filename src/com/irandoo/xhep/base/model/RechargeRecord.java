package com.irandoo.xhep.base.model;

import java.io.Serializable;
import java.sql.Timestamp;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 充值流水实体类
 * @author sun
 * 2018年1月11日19:50:38
 */

public class RechargeRecord implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1759015609543479542L;
	private Long id;
    private Long room_id;
    private Long user_id;
    private Long meal_id;
    private String recharge_order_id;
    private Long recharge_user_id;
    private Long order_money;
    private Integer exchange_coin;
    private Integer reward_coin;
    private String pay_type;
    private Long pay_money;
    private Integer type;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Timestamp recharge_time;
    private String corp_code;
	private String remark;
	private String payStyleShow;
	private String payTypeShow;
    private String userName;
    private String rechargeuserName;
    
    public Long getId() {
		return id;
	} 
	public String getRecharge_order_id() {
		return recharge_order_id;
	}

	public void setRecharge_order_id(String recharge_order_id) {
		this.recharge_order_id = recharge_order_id;
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
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public Long getMeal_id() {
		return meal_id;
	}
	public void setMeal_id(Long meal_id) {
		this.meal_id = meal_id;
	}
	public Long getRecharge_user_id() {
		return recharge_user_id;
	}
	public void setRecharge_user_id(Long recharge_user_id) {
		this.recharge_user_id = recharge_user_id;
	}


	public Integer getExchange_coin() {
		return exchange_coin;
	}
	public void setExchange_coin(Integer exchange_coin) {
		this.exchange_coin = exchange_coin;
	}
	public Integer getReward_coin() {
		return reward_coin;
	}
	public void setReward_coin(Integer reward_coin) {
		this.reward_coin = reward_coin;
	}

	public String getPay_type() {
		return pay_type;
	}
	public void setPay_type(String pay_type) {
		this.pay_type = pay_type;
	}
	public Long getOrder_money() {
		return order_money;
	}
	public void setOrder_money(Long order_money) {
		this.order_money = order_money;
	}
	public Long getPay_money() {
		return pay_money;
	}
	public void setPay_money(Long pay_money) {
		this.pay_money = pay_money;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Timestamp getRecharge_time() {
		return recharge_time;
	}
	public void setRecharge_time(Timestamp recharge_time) {
		this.recharge_time = recharge_time;
	}
	public String getCorp_code() {
		return corp_code;
	}
	public void setCorp_code(String corp_code) {
		this.corp_code = corp_code;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getPayStyleShow() {
		return payStyleShow;
	}
	public void setPayStyleShow(String payStyleShow) {
		this.payStyleShow = payStyleShow;
	}
	public String getPayTypeShow() {
		return payTypeShow;
	}
	public void setPayTypeShow(String payTypeShow) {
		this.payTypeShow = payTypeShow;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRechargeuserName() {
		return rechargeuserName;
	}
	public void setRechargeuserName(String rechargeuserName) {
		this.rechargeuserName = rechargeuserName;
	}
    
    
    
}
