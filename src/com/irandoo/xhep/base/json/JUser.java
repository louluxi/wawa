package com.irandoo.xhep.base.json;

import com.irandoo.base.json.RandooJsonBean;

public class JUser extends RandooJsonBean{

	@Override
	public JUser createBean() {
		// TODO Auto-generated method stub
		return new JUser();
	}
	
	
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
	public void setId(long id)
	{
		set("id", id);
	}
	public long getId()
	{
		return (Long)get("id");
	}
	public String getName() {
		return (String)get("name");
	}
	public void setName(String name) {
		set("name",name);
	}
}
