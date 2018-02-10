package com.irandoo.xhep.base.json;

import java.util.Date;
import java.util.List;

import com.irandoo.base.json.RandooJsonBean;

public class JSchedule extends RandooJsonBean{

	@Override
	public JSchedule createBean() {
		// TODO Auto-generated method stub
		return new JSchedule();
	}
	
	
	public int getWeekDay() {
		return (Integer)get("weekDay");
	}
	public void setWeekDay(int weekDay) {
		set("weekDay", weekDay);
	}
	public int getLessonNo() {
		return (Integer)get("lessonNo");
	}
	public void setLessonNo(int lessonNo) {
		set("lessonNo", lessonNo);
	}
	public int getLessonNum() {
		return (Integer)get("lessonNum");
	}
	public void setLessonNum(int lessonNum) {
		set("lessonNum", lessonNum);
	}
	public long getId() {
		return (Long)get("id");
	}
	public void setId(long id) {
		set("id", id);
	}
	
	public Date getScheduleDate() {
		return (Date)get("scheduleDate");
	}
	public void setScheduleDate(Date scheduleDate) {
		set("scheduleDate",scheduleDate);
	}
	public int getStatus() {
		return (Integer)get("status");
	}
	public void setStatus(int status) {
		set("status",status);
	}
	public boolean isMine() {
		return (Boolean)get("mine");
	}
	public void setMine(boolean mine) {
		set("mine",mine);
	}
	
	public JLocation getLocation() {
		return (JLocation)get("location");
	}


	public void setLocation(JLocation location) {
		set("location",location);
	}


	public JTeacher getTeacher() {
		return (JTeacher)get("teacher");
	}


	public void setTeacher(JTeacher teacher) {
		set("teacher",teacher);
	}
	
}
