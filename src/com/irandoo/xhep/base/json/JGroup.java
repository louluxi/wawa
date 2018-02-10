package com.irandoo.xhep.base.json;


import java.sql.Timestamp;
import java.util.List;

import com.irandoo.base.json.RandooJsonBean;

public class JGroup extends RandooJsonBean{

	@Override
	public JGroup createBean() {
		// TODO Auto-generated method stub
		return new JGroup();
	}
	
	
	public Long getId() {
		return (Long)get("id");
	}
	public void setId(Long id) {
		set("id",id);
	}
	public String getName() {
		return (String)get("name");
	}
	public void setName(String name) {
		set("name",name);
	}
	public String getRemark() {
		return (String)get("remark");
	}
	public void setRemark(String remark) {
		set("remark",remark);
	}
	public String getDesc() {
		return (String)get("desc");
	}
	public void setDesc(String desc) {
		set("desc",desc);
	}
	public Timestamp getCreateTime() {
		return (Timestamp)get("createTime");
	}
	public void setCreateTime(Timestamp createTime) {
		set("createTime",createTime);
	}
	public String getIsChecked() {
		return (String)get("isChecked");
	}
	public void setIsChecked(String isChecked) {
		set("isChecked",isChecked);
	}
	@SuppressWarnings("unchecked")
	public List<JUser> getUserList() {
		return (List<JUser>)get("userList");
	}
	public void setUserList(List<JUser> userList) {
		set("userList",userList);
	}
	
}
