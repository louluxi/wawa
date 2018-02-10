package com.irandoo.xhep.base.json;

import java.util.Date;
import java.util.List;

import com.irandoo.base.json.RandooJsonBean;

public class JChangeApply extends RandooJsonBean{

	@Override
	public JChangeApply createBean() {
		// TODO Auto-generated method stub
		return new JChangeApply();
	}
	
	public long getSchemeId() {
		return (Long)get("schemeId");
	}
	public void setSchemeId(long schemeId) {
		set("schemeId",schemeId);
	}
	public long getScheduleId() {
		return (Long)get("scheduleId");
	}
	public void setScheduleId(long scheduleId) {
		set("scheduleId",scheduleId);
	}
	public int getChangeStatus() {
		return (Integer)get("changeStatus");
	}
	public void setChangeStatus(int changeStatus) {
		set("changeStatus",changeStatus);
	}
	public int getChangeType() {
		return (Integer)get("changeType");
	}
	public void setChangeType(int changeType) {
		set("changeType",changeType);
	}
	public int getToWeekNo() {
		return (Integer)get("toWeekNo");
	}
	public void setToWeekNo(int toWeekNo) {
		set("toWeekNo",toWeekNo);
	}
	public int getToWeekDay() {
		return (Integer)get("toWeekDay");
	}
	public void setToWeekDay(int toWeekDay) {
		set("toWeekDay",toWeekDay);
	}
	public Date getToScheduleDate() {
		return (Date)get("toScheduleDate");
	}
	public void setToScheduleDate(Date toScheduleDate) {
		set("toScheduleDate",toScheduleDate);
	}
	public int getToLessonNo() {
		return (Integer)get("toLessonNo");
	}
	public void setToLessonNo(int toLessonNo) {
		set("toLessonNo",toLessonNo);
	}
	public int getToLessonNum() {
		return (Integer)get("toLessonNum");
	}
	public void setToLessonNum(int toLessonNum) {
		set("toLessonNum",toLessonNum);
	}
	public String getRemark() {
		return (String)get("remark");
	}
	public void setRemark(String remark) {
		set("remark",remark);
	}
	public Date getCreateTime() {
		return (Date)get("createTime");
	}
	public void setCreateTime(Date createTime) {
		set("createTime",createTime);
	}
	public long getApplyerId() {
		return (Long)get("applyerId");
	}
	public void setApplyerId(long applyerId) {
		set("applyerId",applyerId);
	}
	
	public boolean getMine() {
		return (Boolean)get("mine");
	}

	public void setMine(boolean mine) {
		set("mine",mine);
	}

	public String getApplyerName() {
		return (String)get("applyerName");
	}
	public void setApplyerName(String applyerName) {
		set("applyerName",applyerName);
	}
	
	public String getApplyerCode() {
		return (String)get("applyerCode");
	}

	public void setApplyerCode(String applyerCode) {
		set("applyerCode",applyerCode);
	}

	public String getApplyerAlias() {
		return (String)get("applyerAlias");
	}

	public void setApplyerAlias(String applyerAlias) {
		set("applyerAlias",applyerAlias);
	}

	public Long getPlanId() {
		return (Long)get("planId");
	}

	public void setPlanId(Long planId) {
		set("planId",planId);
	}

	public boolean isReleased() {
		return (Boolean)get("released");
	}

	public void setReleased(boolean released) {
		set("released",released);
	}

	public boolean isClassMixed() {
		return (Boolean)get("classMixed");
	}

	public void setClassMixed(boolean classMixed) {
		set("classMixed",classMixed);
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
}
