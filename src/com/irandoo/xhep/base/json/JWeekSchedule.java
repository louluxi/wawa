package com.irandoo.xhep.base.json;



import java.util.List;

import com.irandoo.base.json.RandooJsonBean;

public class JWeekSchedule extends RandooJsonBean{

	@Override
	public JWeekSchedule createBean() {
		// TODO Auto-generated method stub
		return new JWeekSchedule();
	}
	
	@SuppressWarnings("unchecked")
	public List<JChangeApply> getChangeApplyInfoList() {
		return (List<JChangeApply>)get("changeApplyInfoList");
	}

	public void setChangeApplyInfoList(List<JChangeApply> changeApplyInfoList) {
		set("changeApplyInfoList",changeApplyInfoList);
	}

	@SuppressWarnings("unchecked")
	public List<JScheduleInfo> getScheduleInfoList() {
		return (List<JScheduleInfo>)get("scheduleInfoList");
	}

	public void setScheduleInfoList(List<JScheduleInfo> scheduleInfoList) {
		set("scheduleInfoList",scheduleInfoList);
	}

	public JWeek getWeekInfo() {
		return (JWeek)get("weekInfo");
	}

	public void setWeekInfo(JWeek weekInfo) {
		set("weekInfo",weekInfo);
	}
	
}
