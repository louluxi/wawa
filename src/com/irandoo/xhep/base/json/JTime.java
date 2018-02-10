package com.irandoo.xhep.base.json;

import java.util.List;

import com.irandoo.base.json.RandooJsonBean;

public class JTime extends RandooJsonBean
{
	@Override
	public JTime createBean()
	{
		return new JTime();
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
	
	public void setStartWeekNo(int startWeekNo)
	{
		set("startWeekNo", startWeekNo);
	}
	
	public int getStartWeekNo()
	{
		return (Integer)get("startWeekNo");
	}
	
	public void setWeekNum(int weekNum)
	{
		set("weekNum", weekNum);
	}
	
	public int getWeekNum()
	{
		return (Integer)get("weekNum");
	}
	
	public void setWeekDay(int day)
	{
		set("weekDay", day);
	}
	
	public int getWeekDay()
	{
		return (Integer)get("weekDay");
	}
	
	public void setLessonNo(int lessonNo)
	{
		set("lessonNo", lessonNo);
	}
	
	public int getLessonNo()
	{
		return (Integer)get("lessonNo");
	}
	
	public void setLessonNum(int lessonNum)
	{
		set("lessonNum", lessonNum);
	}
	
	public int getLessonNum()
	{
		return (Integer)get("lessonNum");
	}
	
	public void setFrequency(int frequency)
	{
		set("frequency", frequency);
	}
	
	public int getFrequency()
	{
		return (Integer)get("frequency");
	}
	
	public void setReleased(boolean released)
	{
		set("released", released);
	}
	
	public boolean isReleased()
	{
		return (Boolean)get("released");
	}
	
	public void setClassMixed(boolean classMixed)
	{
		set("classMixed", classMixed);
	}
	
	public boolean isClassMixed()
	{
		return (Boolean)get("classMixed");
	}
	
	public void setClassList(List<JClass> classList)
	{
		set("classList", classList);
	}
	
	@SuppressWarnings("unchecked")
	public List<JClass> getClassList()
	{
		return (List<JClass>)get("classList");
	}
	
	public void setCourse(JCourse course)
	{
		set("course", course);
	}
	
	public JCourse getCourse()
	{
		return (JCourse)get("course");
	}
	
	public void setTeacherList(List<JTeacher> teacherList)
	{
		set("teacherList", teacherList);
	}
	
	@SuppressWarnings("unchecked")
	public List<JTeacher> getTeacherList()
	{
		return (List<JTeacher>)get("teacherList");
	}
	
	public void setLocationList(List<JLocation> locationList)
	{
		set("locationList", locationList);
	}
	
	@SuppressWarnings("unchecked")
	public List<JLocation> getLocationList()
	{
		return (List<JLocation>)get("locationList");
	}
}
