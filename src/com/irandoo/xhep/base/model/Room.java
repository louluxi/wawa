package com.irandoo.xhep.base.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class Room implements Serializable {

	/**
	 *序列号
	 */
	private static final long serialVersionUID = -8517623791331049801L;
    private Long id;
    private Long device_id;
    private Long front_camera_id;
    private Long side_camera_id;
    private String room_code;
    private String room_name;
    private String room_desc;
    private Long max_user_num;
    private Integer coin_once;
    private String is_private;
    private String is_putaway;
    private String status;
    private Integer hot;
    private Integer istop;
    private Integer sort;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date create_time;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Timestamp update_timestamp;
    private String corp_code;
    private String room_icon;//房间图标
    private String background_music;//背景音乐
    private String background_img;//房间背景图片
    private String className;
    private Long classID;
    private String deviceCode;
    private String frontCode;
    private String sideCode;
    private String merchName;
    private Integer merchNum;
    private Integer userNum;
    private String frontCamera;
    private String sideCamera;
    private String deviceIp;
    private String devicePort;
    private String merchTypeCode;
    private String privateShow;
    private String putawayShow;
    private String strtusShow;
    private String istopShow;
    private String checkMerchNum;
    private String merchNumShow;
    private Long merchId;
    private Long merch_id;
    private String classIds;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getDevice_id() {
		return device_id;
	}
	public void setDevice_id(Long device_id) {
		this.device_id = device_id;
	}
	public Long getFront_camera_id() {
		return front_camera_id;
	}
	public void setFront_camera_id(Long front_camera_id) {
		this.front_camera_id = front_camera_id;
	}
	public Long getSide_camera_id() {
		return side_camera_id;
	}
	public void setSide_camera_id(Long side_camera_id) {
		this.side_camera_id = side_camera_id;
	}
	public String getRoom_code() {
		return room_code;
	}
	public void setRoom_code(String room_code) {
		this.room_code = room_code;
	}
	public String getRoom_name() {
		return room_name;
	}
	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}
	public String getRoom_desc() {
		return room_desc;
	}
	public void setRoom_desc(String room_desc) {
		this.room_desc = room_desc;
	}
	public Long getMax_user_num() {
		return max_user_num;
	}
	public void setMax_user_num(Long max_user_num) {
		this.max_user_num = max_user_num;
	}
	public Integer getCoin_once() {
		return coin_once;
	}
	public void setCoin_once(Integer coin_once) {
		this.coin_once = coin_once;
	}
	public String getIs_private() {
		return is_private;
	}
	public void setIs_private(String is_private) {
		this.is_private = is_private;
	}
	public String getIs_putaway() {
		return is_putaway;
	}
	public void setIs_putaway(String is_putaway) {
		this.is_putaway = is_putaway;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Timestamp getUpdate_timestamp() {
		return update_timestamp;
	}
	public void setUpdate_timestamp(Timestamp update_timestamp) {
		this.update_timestamp = update_timestamp;
	}
	public String getCorp_code() {
		return corp_code;
	}
	public void setCorp_code(String corp_code) {
		this.corp_code = corp_code;
	}
	public Integer getHot() {
		return hot;
	}
	public void setHot(Integer hot) {
		this.hot = hot;
	}
	public Integer getIstop() {
		return istop;
	}
	public void setIstop(Integer istop) {
		this.istop = istop;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	
	public Integer getUserNum() {
		return userNum;
	}
	public void setUserNum(Integer userNum) {
		this.userNum = userNum;
	}
	public String getSideCamera() {
		return sideCamera;
	}
	public void setSideCamera(String sideCamera) {
		this.sideCamera = sideCamera;
	}
	public String getDeviceIp() {
		return deviceIp;
	}
	public void setDeviceIp(String deviceIp) {
		this.deviceIp = deviceIp;
	}
	public String getDevicePort() {
		return devicePort;
	}
	public void setDevicePort(String devicePort) {
		this.devicePort = devicePort;
	}
	public String getMerchName() {
		return merchName;
	}
	public void setMerchName(String merchName) {
		this.merchName = merchName;
	}
	public Integer getMerchNum() {
		return merchNum;
	}
	public void setMerchNum(Integer merchNum) {
		this.merchNum = merchNum;
	}
	public String getFrontCamera() {
		return frontCamera;
	}
	public void setFrontCamera(String frontCamera) {
		this.frontCamera = frontCamera;
	}
	public String getDeviceCode() {
		return deviceCode;
	}
	public void setDeviceCode(String deviceCode) {
		this.deviceCode = deviceCode;
	}
	public String getFrontCode() {
		return frontCode;
	}
	public void setFrontCode(String frontCode) {
		this.frontCode = frontCode;
	}
	public String getSideCode() {
		return sideCode;
	}
	public void setSideCode(String sideCode) {
		this.sideCode = sideCode;
	}
	public Long getClassID() {
		return classID;
	}
	public void setClassID(Long classID) {
		this.classID = classID;
	}
	public String getMerchTypeCode() {
		return merchTypeCode;
	}
	public void setMerchTypeCode(String merchTypeCode) {
		this.merchTypeCode = merchTypeCode;
	}
	public String getRoom_icon() {
		return room_icon;
	}
	public void setRoom_icon(String room_icon) {
		this.room_icon = room_icon;
	}
	
	public String getBackground_music() {
		return background_music;
	}
	public void setBackground_music(String background_music) {
		this.background_music = background_music;
	}
	public String getBackground_img() {
		return background_img;
	}
	public void setBackground_img(String background_img) {
		this.background_img = background_img;
	}
	public String getPrivateShow() {
		return privateShow;
	}
	public void setPrivateShow(String privateShow) {
		this.privateShow = privateShow;
	}
	public String getPutawayShow() {
		return putawayShow;
	}
	public void setPutawayShow(String putawayShow) {
		this.putawayShow = putawayShow;
	}
	public String getStrtusShow() {
		return strtusShow;
	}
	public void setStrtusShow(String strtusShow) {
		this.strtusShow = strtusShow;
	}
	public String getIstopShow() {
		return istopShow;
	}
	public void setIstopShow(String istopShow) {
		this.istopShow = istopShow;
	}
	public String getCheckMerchNum() {
		return checkMerchNum;
	}
	public void setCheckMerchNum(String checkMerchNum) {
		this.checkMerchNum = checkMerchNum;
	}
	public String getMerchNumShow() {
		return merchNumShow;
	}
	public void setMerchNumShow(String merchNumShow) {
		this.merchNumShow = merchNumShow;
	}
	public Long getMerchId() {
		return merchId;
	}
	public void setMerchId(Long merchId) {
		this.merchId = merchId;
	}
	public Long getMerch_id() {
		return merch_id;
	}
	public void setMerch_id(Long merch_id) {
		this.merch_id = merch_id;
	}
	public String getClassIds() {
		return classIds;
	}
	public void setClassIds(String classIds) {
		this.classIds = classIds;
	}

 
}
