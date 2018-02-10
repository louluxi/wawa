package com.irandoo.xhep.base.json;

import com.irandoo.base.json.RandooJsonBean;

public class JCourse extends RandooJsonBean
{
	@Override
	public JCourse createBean()
	{
		return new JCourse();
	}
	
	public void setId(long id)
	{
		set("id", id);
	}
	
	public long getId()
	{
		return (Long)get("id");
	}
	
	public void setCourseCode(String code)
	{
		set("courseCode", code);
	}
	
	public String getCourseCode()
	{
		return (String)get("courseCode");
	}
	
	public void setCourseName(String name)
	{
		set("courseName", name);
	}
	
	public String getCourseName()
	{
		return (String)get("courseName");
	}
	
	public void setCredit(float credit)
	{
		set("credit", credit);
	}
	
	public float getCredit()
	{
		return (Float)get("credit");
	}
	
	public void setPeriod(float period)
	{
		set("period", period);
	}
	
	public float getPeriod()
	{
		return (Float)get("period");
	}
}
