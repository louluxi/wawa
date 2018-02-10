package com.irandoo.xhep.base.json;

import com.irandoo.base.json.RandooJsonBean;

public class JTeacher extends RandooJsonBean
{
	@Override
	public JTeacher createBean()
	{
		return new JTeacher();
	}
	public void setId(long id){
		set("id",id);
	}
	public long getId(){
		return (Long)get("id");
	}
	public void setUserID(String userID){
		set("userID",userID);
	}
	public String getUserID(){
		return (String)get("userID");
	}
	public void setName(String name){
		set("name",name);
	}
	public String getName(){
		return (String)get("name");
	}
}
