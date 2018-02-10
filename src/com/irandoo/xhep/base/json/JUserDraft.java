package com.irandoo.xhep.base.json;

import com.irandoo.base.json.RandooJsonBean;

public class JUserDraft  extends RandooJsonBean{
	public String getToType() {
		return (String)get("toType");
	}
	public void setToType(String toType) {
		set("toType",toType);
	}
	public String getIsChecked() {
		return (String)get("isChecked");
	}
	public void setIsChecked(String isChecked) {
		set("isChecked",isChecked);
	}
	
	public String getCode() {
		return (String)get("code");
	}
	public void setCode(String code) {
		set("code",code);
	}
	public String getName() {
		return (String)get("name");
	}
	public void setName(String name) {
		set("name",name);
	}
	@Override
	public JUserDraft createBean() {
		// TODO Auto-generated method stub
		return new JUserDraft();
	}
}
