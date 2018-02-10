package com.irandoo.xhep.base.json;

import com.irandoo.base.json.RandooJsonBean;

public class JScheduleInfo extends RandooJsonBean{

	@Override
	public JScheduleInfo createBean() {
		// TODO Auto-generated method stub
		return new JScheduleInfo();
	}
	
	public JTime getSchemeTimeInfo() {
		return (JTime)get("schemeTimeInfo");
	}

	public void setSchemeTimeInfo(JTime schemeTimeInfo) {
		set("schemeTimeInfo",schemeTimeInfo);
	}
	
	public JSchedule getScheduleInfo() {
		return (JSchedule)get("scheduleInfo");
	}

	public void setScheduleInfo(JSchedule scheduleInfo) {
		set("scheduleInfo",scheduleInfo);
	}

}
