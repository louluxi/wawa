package com.irandoo.xhep.base.json;

import java.util.Date;

import com.irandoo.base.json.RandooJsonBean;

public class JCurrentWeek extends RandooJsonBean{

	@Override
	public JCurrentWeek createBean() {
		// TODO Auto-generated method stub
		return new JCurrentWeek();
	}
	
	public Date getNow() {
		return (Date)get("now");
	}
	public void setNow(Date now) {
		set("now", now);
	}
	public int getCurrentWeek() {
		return (Integer)get("currentWeek");
	}
	public void setCurrentWeek(int currentWeek) {
		set("currentWeek",currentWeek);
	}
	
}
