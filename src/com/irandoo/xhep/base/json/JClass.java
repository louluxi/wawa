package com.irandoo.xhep.base.json;

import com.irandoo.base.json.RandooJsonBean;


public class JClass extends RandooJsonBean
{
	@Override
	public JClass createBean()
	{
		return new JClass();
	}
	
	public void setId(long id)
	{
		set("id", id);
	}
	
	public long getId()
	{
		return (Long)get("id");
	}
	
	public void setCorpID(String id)
	{
		set("corpID", id);
	}
	
	public String getCorpID()
	{
		return (String)get("corpID");
	}
	
	public void setName(String name)
	{
		set("name", name);
	}
	
	public String getName()
	{
		return (String)get("name");
	}
}
