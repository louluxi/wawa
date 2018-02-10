package com.irandoo.xhep.base.json;

import java.util.Date;

import com.irandoo.base.json.RandooJsonBean;

public class JTo extends RandooJsonBean{

	@Override
	public JTo createBean() {
		// TODO Auto-generated method stub
		return new JTo();
	}
	
	public JTo(){};
	
	public JTo(String to,String toType){
		setTo(to);
		setToType(toType);
	}
	
	public String getTo() {
		return (String)get("to");
	}
	public void setTo(String to) {
		set("to",to);
	}
	public String getToType() {
		return (String)get("toType");
	}
	public void setToType(String toType) {
		set("toType",toType);
	}
	
}
