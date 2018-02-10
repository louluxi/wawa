package com.irandoo.xhep.base.json;

import java.util.Date;

import com.irandoo.base.json.RandooJsonBean;

public class JTrack extends RandooJsonBean{
	@Override
	public JTrack createBean() {
		// TODO Auto-generated method stub
		return new JTrack();
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
	public Date getTrackTime() {
		return (Date)get("trackTime");
	}
	public void setTrackTime(Date trackTime) {
		set("trackTime",trackTime);
	}
	public int getSeqNo() {
		return (Integer)get("seqNo");
	}
	public void setSeqNo(int seqNo) {
		set("seqNo",seqNo);
	}
	
}
