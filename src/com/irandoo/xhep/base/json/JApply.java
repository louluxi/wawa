package com.irandoo.xhep.base.json;

import java.util.Date;

import com.irandoo.base.json.RandooJsonBean;

public class JApply extends RandooJsonBean{

	@Override
	public JApply createBean() {
		// TODO Auto-generated method stub
		return new JApply();
	}
	
	
	
	public Long getSchemeId() {
		return (Long)get("schemeId");
	}
	public void setSchemeId(Long schemeId) {
		set("schemeId",schemeId);
	}
	public long getId() {
		return (Long)get("id");
	}
	public void setId(long id) {
		set("id",id);
	}
	public String getCode() {
		return (String)get("code");
	}
	public void setCode(String code) {
		set("code",code);
	}
	public String getCourse() {
		return (String)get("course");
	}
	public void setCourse(String course) {
		set("course",course);
	}
	public String getType() {
		return (String)get("type");
	}
	public void setType(String type) {
		set("type",type);
	}
	public String getStatus() {
		return (String)get("status");
	}
	public void setStatus(String status) {
		set("status",status);
	}
	public int getWeekNo() {
		return (Integer)get("weekNo");
	}
	public void setWeekNo(int weekNo) {
		set("weekNo",weekNo);
	}
	public int getWeekday() {
		return (Integer)get("weekday");
	}
	public void setWeekday(int weekday) {
		set("weekday",weekday);
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
	public String getRemark() {
		return (String)get("remark");
	}
	public void setRemark(String remark) {
		set("remark",remark);
	}
	public String getApplyer() {
		return (String)get("applyer");
	}
	public void setApplyer(String applyer) {
		set("applyer",applyer);
	}
	public Date getCreateTime() {
		return (Date)get("createTime");
	}
	public void setCreateTime(Date createTime) {
		set("createTime",createTime);
	}
	public String getAuditor() {
		return (String)get("auditor");
	}
	public void setAuditor(String auditor) {
		set("auditor",auditor);
	}
	public String getOpinion() {
		return (String)get("opinion");
	}
	public void setOpinion(String opinion) {
		set("opinion",opinion);
	}
	public String getAuditStatus() {
		return (String)get("auditStatus");
	}
	public void setAuditStatus(String auditStatus) {
		set("auditStatus",auditStatus);
	}
	public Date getAuditTime() {
		return (Date)get("auditTime");
	}
	public void setAuditTime(Date auditTime) {
		set("auditTime",auditTime);
	}
}
