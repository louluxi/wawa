package com.irandoo.xhep.base.json;

import java.util.Date;

import com.irandoo.base.json.RandooJsonBean;

public class JScheduleMakeUp extends RandooJsonBean{

	@Override
	public JScheduleMakeUp createBean() {
		// TODO Auto-generated method stub
		return new JScheduleMakeUp();
	}
	
	public long getId() {
		return (Long)get("id");
	}
	public void setId(long id) {
		set("id", id);
	}
	
	public String getCourseName() {
		return (String)get("courseName");
	}

	public void setCourseName(String courseName) {
		set("courseName",courseName);
	}

	public Date getScheduleDate() {
		return (Date)get("scheduleDate");
	}

	public void setScheduleDate(Date scheduleDate) {
		set("scheduleDate",scheduleDate);
	}

	public int getLessonNo() {
		return (Integer)get("lessonNo");
	}

	public void setLessonNo(int lessonNo) {
		set("lessonNo",lessonNo);
	}

	public int getLessonNum() {
		return (Integer)get("lessonNum");
	}

	public void setLessonNum(int lessonNum) {
		set("lessonNum",lessonNum);
	}

	public String getTeacherName() {
		return (String)get("teacherName");
	}

	public void setTeacherName(String teacherName) {
		set("teacherName",teacherName);
	}

	public String getTeacherCode() {
		return (String)get("teacherCode");
	}

	public void setTeacherCode(String teacherCode) {
		set("teacherCode",teacherCode);
	}

	public String getLocationName() {
		return (String)get("locationName");
	}

	public void setLocationName(String locationName) {
		set("locationName",locationName);
	}

	public int getStatus() {
		return (Integer)get("status");
	}

	public void setStatus(int status) {
		set("status",status);
	}
}
