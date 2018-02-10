package com.irandoo.app.interf.json;

import java.io.Serializable;
import java.util.List;


/**
  * <p>Title: 房间类别</p>
  * <p>Description: </p>
  * <p>Company: irandoo</p> 
  * @author ager
  * @date 2018-1-8上午10:51:51
  */
public class RoomTypeJson implements Serializable{
	private static final long serialVersionUID = -897990014861203748L;
	private String id;
	private String className;
	private String classIcon;
	private List<RoomJson> rooms;
	public String getId() {
		return id;
	}
	public String getClassName() {
		return className;
	}
	public String getClassIcon() {
		return classIcon;
	}
	public List<RoomJson> getRooms() {
		return rooms;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public void setClassIcon(String classIcon) {
		this.classIcon = classIcon;
	}
	public void setRooms(List<RoomJson> rooms) {
		this.rooms = rooms;
	}
}
