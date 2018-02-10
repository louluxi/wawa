package com.irandoo.app.interf.action;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.irandoo.app.interf.json.RoomJson;
import com.irandoo.app.interf.json.RoomOnlineJson;
import com.irandoo.app.interf.json.UserJson;
import com.irandoo.app.interf.service.RoomJsonService;
import com.irandoo.app.interf.service.RoomOnlineJsonService;
import com.irandoo.app.interf.service.UserJsonService;
import com.irandoo.app.interf.util.LiveUtil;
import com.irandoo.app.interf.util.MqUtil;
import com.irandoo.xhep.base.action.BaseAction;

/**
  * <p>Title: 房间相关接口</p>
  * <p>Description: </p>
  * <p>Company: irandoo</p> 
  * @author ager
  * @date 2018-1-8下午4:43:55
  */
@Controller("roomJsonAction")
@Scope("prototype")
public class RoomJsonAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	@Autowired
    private RoomJsonService roomJsonService;
	@Autowired
	private RoomOnlineJsonService roomOnlineJsonService;
	@Autowired
	private UserJsonService userJsonService;
    
	public String getRoomList() {
		return returnJson(roomJsonService.getAllList(getInterfMap()), "0", "");
	}
	public String getRoomDetail() {
		Map<String,Object> map = getInterfMap();
		long id = Long.parseLong(map.get("roomId")+"");
		RoomJson roomJson = roomJsonService.getInfoById(id);
		roomJson.setFrontPlayUrl(LiveUtil.getLiveUrl(roomJson.getRoomCode(), "00"));
		roomJson.setSidePlayUrl(LiveUtil.getLiveUrl(roomJson.getRoomCode(), "01"));
		return returnJson(roomJson, "0", "");
	}
    
	public String enterRoom() {
        return returnJson(roomJsonService.enterRoom(getInterfMap()), "0", "");
	}
	
	public String outRoom() {
		Map<String,Object> map = getInterfMap();
		String roomId = map.get("roomId") + "";
		String roomCode = map.get("roomCode") + "";
		String userId = map.get("userId") + "";
		
		/*************推送消息**************/
		Map<String, Object> messageMap = new HashMap<String, Object>();
		messageMap.put("userId", userId);
		MqUtil.sendMq(roomCode, "4", messageMap);
		
		RoomOnlineJson roomOnlineJson = new RoomOnlineJson();
		roomOnlineJson.setRoomId(roomId);
		roomOnlineJson.setUserId(userId);
		roomOnlineJsonService.deleteByUserRoom(map);
		return returnJson("", "0", "");
	}
	
	public String getRoomState() {
		Map<String,Object> map = getInterfMap();
		String roomId = map.get("roomId") + "";
		RoomJson roomJson = RoomJson.getRoomById(roomId);
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("roomId", roomId);
		resultMap.put("state", roomJson.getStatus());
		return returnJson(resultMap, "0", "");
	}
	
	public String setRoomState(){
		Map<String,Object> map = getInterfMap();
		String roomId = map.get("roomId") + "";
		String roomCode = map.get("roomCode") + "";
		String state = map.get("state") + "";
		
		/************获取用户详情************/
		UserJson userJson = userJsonService.getInfoById(Long.valueOf(map.get("userId") + ""));
		
		/************设置房间状态************/
		RoomJson paramJson = new RoomJson();
		paramJson.setId(roomId);
		paramJson.setRoomCode(roomCode);
		paramJson.setStatus(state);
		RoomJson.setRoomById(paramJson, userJson);
		return returnJson("", "0", "");
	}
}
