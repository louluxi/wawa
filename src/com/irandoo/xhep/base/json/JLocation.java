package com.irandoo.xhep.base.json;

import com.irandoo.base.json.RandooJsonBean;

public class JLocation extends RandooJsonBean
{
	@Override
	public JLocation createBean()
	{
		return new JLocation();
	}
	
	public void setName(String name)
	{
		set("name", name);
	}
	
	public String getName()
	{
		return (String)get("name");
	}
	
	public void setId(long id)
	{
		set("id", id);
	}
	
	public long getId()
	{
		return (Long)get("id");
	}
	
	public void setCode(String code){
		set("code",code);
	}
	
	public String getCode(){
		return (String)get("code");
	}
}
