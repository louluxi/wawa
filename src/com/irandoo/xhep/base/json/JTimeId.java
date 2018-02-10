package com.irandoo.xhep.base.json;

import com.irandoo.base.json.RandooJsonBean;

public class JTimeId extends RandooJsonBean{

	@Override
	public RandooJsonBean createBean() {
		// TODO Auto-generated method stub
		return new JTimeId();
	}
	public void setId(long id)
	{
		set("id", id);
	}
	
	public long getId()
	{
		return (Long)get("id");
	}
	
	public void setPlanId(long id)
	{
		set("planId", id);
	}
	
	public long getPlanId()
	{
		return (Long)get("planId");
	}
	
	public void setSchemeId(long id)
	{
		set("schemeId", id);
	}
	
	public long getSchemeId()
	{
		return (Long)get("schemeId");
	}
}
