package com.irandoo.app.interf.json;

import java.io.Serializable;

/**
  * <p>Title: 设备json</p>
  * <p>Description: </p>
  * <p>Company: irandoo</p> 
  * @author ager
  * @date 2018-1-17上午10:03:40
  */
public class DeviceJson implements Serializable{
	private static final long serialVersionUID = -897990014861203748L;
	private String id;
	private String deviceType;
	private String deviceCode;
	private String deviceNum;
	private String batchNum;
	private String deviceName;
	private String ip;
	private String port;
	private String upUrl;
	private String upPort;
	private String upFold;
	private String upFile;
	private String rtmpPlay;
	private String communicationType;
	private String coinOnce;
	private String roomId;
	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public String getId() {
		return id;
	}
	public String getDeviceType() {
		return deviceType;
	}
	public String getDeviceCode() {
		return deviceCode;
	}
	public String getDeviceNum() {
		return deviceNum;
	}
	public String getBatchNum() {
		return batchNum;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public String getIp() {
		return ip;
	}
	public String getPort() {
		return port;
	}
	public String getUpUrl() {
		return upUrl;
	}
	public String getUpPort() {
		return upPort;
	}
	public String getUpFold() {
		return upFold;
	}
	public String getUpFile() {
		return upFile;
	}
	public String getRtmpPlay() {
		return rtmpPlay;
	}
	public String getCommunicationType() {
		return communicationType;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}
	public void setDeviceCode(String deviceCode) {
		this.deviceCode = deviceCode;
	}
	public void setDeviceNum(String deviceNum) {
		this.deviceNum = deviceNum;
	}
	public void setBatchNum(String batchNum) {
		this.batchNum = batchNum;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public void setUpUrl(String upUrl) {
		this.upUrl = upUrl;
	}
	public void setUpPort(String upPort) {
		this.upPort = upPort;
	}
	public void setUpFold(String upFold) {
		this.upFold = upFold;
	}
	public void setUpFile(String upFile) {
		this.upFile = upFile;
	}
	public void setRtmpPlay(String rtmpPlay) {
		this.rtmpPlay = rtmpPlay;
	}
	public void setCommunicationType(String communicationType) {
		this.communicationType = communicationType;
	}
	public String getCoinOnce() {
		return coinOnce;
	}
	public void setCoinOnce(String coinOnce) {
		this.coinOnce = coinOnce;
	}
}
