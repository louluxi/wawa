package com.irandoo.xhep.base.json;

import com.irandoo.base.json.RandooJsonBean;

public class JOccupy extends RandooJsonBean{

	@Override
	public JOccupy createBean() {
		// TODO Auto-generated method stub
		return new JOccupy();
	}
	
	public String getType() {
		return (String)get("type");
	}
	public void setType(String type) {
		set("type",type);
	}
	public Long getId() {
		return (Long)get("id");
	}
	public void setId(Long id) {
		set("id",id);
	}
	public String getName() {
		return (String)get("name");
	}
	public void setName(String name) {
		set("name",name);
	}
	
}
