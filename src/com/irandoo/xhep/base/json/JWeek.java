package com.irandoo.xhep.base.json;

import java.sql.Date;

import com.irandoo.base.json.RandooJsonBean;

public class JWeek extends RandooJsonBean{

	@Override
	public JWeek createBean() {
		// TODO Auto-generated method stub
		return new JWeek();
	}
	
	public long getWeekNo() {
		return (Integer)get("weekNo");
	}
	public void setWeekNo(long weekNo) {
		set("weekNo",weekNo);
	}
	
	public Date getWeekFirstDay() {
		return (Date)get("weekFirstDay");
	}

	public void setWeekFirstDay(Date weekFirstDay) {
		set("weekFirstDay",weekFirstDay);
	}

	public Date getWeekLastDay() {
		return (Date)get("weekLastDay");
	}

	public void setWeekLastDay(Date weekLastDay) {
		set("weekLastDay",weekLastDay);
	}
}
