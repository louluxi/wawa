package com.irandoo.app.interf.json;

import java.io.Serializable;

/**
  * <p>Title: 套餐json</p>
  * <p>Description: </p>
  * <p>Company: irandoo</p> 
  * @author ager
  * @date 2018-1-8上午10:58:01
  */
public class MealJson implements Serializable{
	private static final long serialVersionUID = -897990014861203748L;
	private String id;
	private String name;
	private String remark;
	private String rewardCoin;
	private String price;
	private String dollCoin;
	private String giveCoin;
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getRemark() {
		return remark;
	}
	public String getPrice() {
		return price;
	}
	public String getDollCoin() {
		return dollCoin;
	}
	public String getGiveCoin() {
		return giveCoin;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public void setDollCoin(String dollCoin) {
		this.dollCoin = dollCoin;
	}
	public void setGiveCoin(String giveCoin) {
		this.giveCoin = giveCoin;
	}
	public String getRewardCoin() {
		return rewardCoin;
	}
	public void setRewardCoin(String rewardCoin) {
		this.rewardCoin = rewardCoin;
	}
	
}
