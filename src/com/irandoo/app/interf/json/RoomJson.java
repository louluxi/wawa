package com.irandoo.app.interf.json;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.irandoo.app.interf.service.RoomJsonService;
import com.irandoo.app.interf.util.MqUtil;

/**
  * <p>Title: 房间json</p>
  * <p>Description: </p>
  * <p>Company: irandoo</p> 
  * @author ager
  * @date 2018-1-8上午10:48:41
  */
public class RoomJson implements Serializable{
	private static final long serialVersionUID = -897990014861203748L;
	private String id;
	private String deviceId;
	private String frontId;
	private String sideId;
	private String frontPlayUrl;
	private String sidePlayUrl;
	private String roomCode;
	private String roomName;
	private String roomDesc;
	private String roomIcon;
	private String backgroundMusic;
	private String backgroundImg;
	private String merchDescImg;
	private String maxUserNum;
	private String coinOnce;
	private String isPrivate;
	private String status;
	private String merchDesc;
	private String roomPersonNum;
	private List<RoomOnlineJson> personList;
	private List<RoomGrabJson> grabList;
	
	private String userId;
	private String snapId;
	
	public String getSnapId() {
		return snapId;
	}
	public void setSnapId(String snapId) {
		this.snapId = snapId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getRoomPersonNum() {
		return roomPersonNum;
	}
	public void setRoomPersonNum(String roomPersonNum) {
		this.roomPersonNum = roomPersonNum;
	}
	public String getMerchDescImg() {
		return merchDescImg;
	}
	public void setMerchDescImg(String merchDescImg) {
		this.merchDescImg = merchDescImg;
	}
	public List<RoomOnlineJson> getPersonList() {
		return personList;
	}
	public List<RoomGrabJson> getGrabList() {
		return grabList;
	}
	public void setPersonList(List<RoomOnlineJson> personList) {
		this.personList = personList;
	}
	public void setGrabList(List<RoomGrabJson> grabList) {
		this.grabList = grabList;
	}
	public String getFrontPlayUrl() {
		return frontPlayUrl;
	}
	public String getSidePlayUrl() {
		return sidePlayUrl;
	}
	public void setFrontPlayUrl(String frontPlayUrl) {
		this.frontPlayUrl = frontPlayUrl;
	}
	public void setSidePlayUrl(String sidePlayUrl) {
		this.sidePlayUrl = sidePlayUrl;
	}
	public String getId() {
		return id;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public String getFrontId() {
		return frontId;
	}
	public String getSideId() {
		return sideId;
	}
	public String getRoomCode() {
		return roomCode;
	}
	public String getRoomName() {
		return roomName;
	}
	public String getRoomDesc() {
		return roomDesc;
	}
	public String getRoomIcon() {
		return roomIcon;
	}
	public String getBackgroundMusic() {
		return backgroundMusic;
	}
	public String getBackgroundImg() {
		return backgroundImg;
	}
	public String getMaxUserNum() {
		return maxUserNum;
	}
	public String getCoinOnce() {
		return coinOnce;
	}
	public String getIsPrivate() {
		return isPrivate;
	}
	public String getStatus() {
		return status;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public void setFrontId(String frontId) {
		this.frontId = frontId;
	}
	public void setSideId(String sideId) {
		this.sideId = sideId;
	}
	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public void setRoomDesc(String roomDesc) {
		this.roomDesc = roomDesc;
	}
	public void setRoomIcon(String roomIcon) {
		this.roomIcon = roomIcon;
	}
	public void setBackgroundMusic(String backgroundMusic) {
		this.backgroundMusic = backgroundMusic;
	}
	public void setBackgroundImg(String backgroundImg) {
		this.backgroundImg = backgroundImg;
	}
	public void setMaxUserNum(String maxUserNum) {
		this.maxUserNum = maxUserNum;
	}
	public void setCoinOnce(String coinOnce) {
		this.coinOnce = coinOnce;
	}
	public void setIsPrivate(String isPrivate) {
		this.isPrivate = isPrivate;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public static Map<String, RoomJson> roomMap = new HashMap<String,RoomJson>();
	
	/**
	 * 获取房间，第一次查数据库，并放入内存，后面直接从内存获取
	 * @param roomId
	 * @return
	 */
	public static RoomJson getRoomById(String roomId){
		RoomJson roomJson = null;
		synchronized (roomMap) {
			roomJson = roomMap.get(roomId);
			if(null == roomJson){
				WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
		        RoomJsonService roomJsonService = (RoomJsonService) wac.getBean("roomJsonService");
				roomJson = roomJsonService.getInfoById(Long.parseLong(roomId));
				roomMap.put(roomId, roomJson);
			}
		}
		return roomJson;
	}
	
	/**
	 * 设置房间游戏人
	 * @param roomId
	 * @param userId
	 */
	public static void setGameUserByRoomId(String roomId, String userId){
		RoomJson roomJson = null;
		synchronized (roomMap) {
			roomJson = roomMap.get(roomId);
			synchronized (roomJson) {
				roomJson.setUserId(userId);
			}
		}
	}

	/**
	 * 设置房间单次游戏码
	 * @param snapId
	 * @param State
	 */
	public static void setRoomSnapId(String roomId, String snapId){
		RoomJson roomJson = null;
		synchronized (roomMap) {
			roomJson = roomMap.get(roomId);
			synchronized (roomJson) {
				roomJson.setSnapId(snapId);
			}
		}
	}
	
	
	/**
	 * 移除房间单次游戏码
	 * @param snapId
	 */
	public static void removeRoomSnapId(String roomId){
		RoomJson roomJson = null;
		synchronized (roomMap) {
			roomJson = roomMap.get(roomId);
			if(null != roomJson){
				roomJson.setSnapId(null);
			}
		}
	}
	
	/**
	 * 设置房间状态，并发消息到消息队列，更新数据库房间状态（新建一个线程，不影响主线程效率）
	 * @param paramRoom
	 * @param userJson
	 * @return
	 */
	public static RoomJson setRoomById(RoomJson paramRoom, UserJson userJson){
		RoomJson roomJson = null;
		Map<String, Object> resultMap = null;
		WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
		RoomJsonService roomJsonService = (RoomJsonService) wac.getBean("roomJsonService");
		synchronized (roomMap) {
			roomJson = roomMap.get(paramRoom.getId());
			synchronized (roomJson) {
				if(null == roomJson){
					roomJson = roomJsonService.getInfoById(Long.parseLong(paramRoom.getId()));
					roomJson.setUserId(userJson.getUserId());//设置房间游戏人
					roomMap.put(paramRoom.getId(), roomJson);
				}else{
					roomJson.setStatus(paramRoom.getStatus());//状态设置为0 - 空闲中； 1 - 使用中
					roomJson.setSnapId(paramRoom.getSnapId());//设置房间游戏码
					roomJson.setUserId(userJson.getUserId());//设置房间游戏人
					
					resultMap = new HashMap<String, Object>();
					resultMap.put("status", paramRoom.getStatus());
					resultMap.put("userId", userJson.getUserId());
					resultMap.put("userName", userJson.getUserName());
					resultMap.put("userIcon", userJson.getUserIcon());
					
					new Thread(paramRoom.getId()+"_"+paramRoom.getStatus()){
						@Override
						public void run() {
							WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
					        RoomJsonService roomJsonService = (RoomJsonService) wac.getBean("roomJsonService");
					        String name = Thread.currentThread().getName();
					        RoomJson roomJson = roomJsonService.getInfoById(Long.valueOf(name.split("_")[0]));
					        roomJson.setStatus(name.split("_")[1]);
					        roomJsonService.update(roomJson);
						}
					}.start();
				}
				if(null != paramRoom.getRoomCode() && !"".equals(paramRoom.getRoomCode())){
					MqUtil.sendMq(paramRoom.getRoomCode(), "1", resultMap);
				}
			}
		}
		return roomJson;
	}
	public String getMerchDesc() {
		return merchDesc;
	}
	public void setMerchDesc(String merchDesc) {
		this.merchDesc = merchDesc;
	}
}
