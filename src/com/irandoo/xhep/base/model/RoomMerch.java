package com.irandoo.xhep.base.model;

import java.io.Serializable;

public class RoomMerch implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8306670030634240430L;
    private Long id;
    private Long room_id;
    private Long merch_id;
    private Integer merch_num;
    private String  status;
    private String corp_code;
    private String roomName;
    private String roomCode;
    private String merchName;
    private String className;
    private Long classID;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getRoom_id() {
		return room_id;
	}
	public void setRoom_id(Long room_id) {
		this.room_id = room_id;
	}
	public Long getMerch_id() {
		return merch_id;
	}
	public void setMerch_id(Long merch_id) {
		this.merch_id = merch_id;
	}
	public Integer getMerch_num() {
		return merch_num;
	}
	public void setMerch_num(Integer merch_num) {
		this.merch_num = merch_num;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCorp_code() {
		return corp_code;
	}
	public void setCorp_code(String corp_code) {
		this.corp_code = corp_code;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public String getRoomCode() {
		return roomCode;
	}
	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}
	public String getMerchName() {
		return merchName;
	}
	public void setMerchName(String merchName) {
		this.merchName = merchName;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public Long getClassID() {
		return classID;
	}
	public void setClassID(Long classID) {
		this.classID = classID;
	}
    
}
