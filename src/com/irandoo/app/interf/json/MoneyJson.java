package com.irandoo.app.interf.json;

import java.io.Serializable;

public class MoneyJson implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9097798024820857603L;
	
	private String timeValue;
	private String money;
	
	
	
	public String getTimeValue() {
		return timeValue;
	}
	public void setTimeValue(String timeValue) {
		this.timeValue = timeValue;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	
	

}
