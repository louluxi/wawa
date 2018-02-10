package com.irandoo.app.interf.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.irandoo.app.interf.json.RoomGrabJson;
import com.irandoo.app.interf.json.RoomJson;
import com.irandoo.app.interf.json.RoomOnlineJson;
import com.irandoo.app.interf.json.UserJson;
import com.irandoo.app.interf.mapper.RoomGrabJsonMapper;
import com.irandoo.app.interf.mapper.RoomJsonMapper;
import com.irandoo.app.interf.mapper.RoomOnlineJsonMapper;
import com.irandoo.app.interf.mapper.UserJsonMapper;
import com.irandoo.app.interf.service.RoomJsonService;
import com.irandoo.app.interf.util.LiveUtil;
import com.irandoo.app.interf.util.MqUtil;
import com.irandoo.xhep.base.service.impl.BaseServiceImpl;


/**
  * <p>Title: </p>
  * <p>Description: </p>
  * <p>Company: irandoo</p> 
  * @author ager
  * @date 2018-1-8下午4:41:01
  */
@Service("roomJsonService")
public class RoomJsonServiceImpl extends BaseServiceImpl<RoomJson> implements RoomJsonService {
	private Log logger = LogFactory.getLog(RoomJsonServiceImpl.class);
	@Autowired
	private RoomJsonMapper roomJsonMapper;
    
    @Autowired
    private RoomOnlineJsonMapper roomOnlineJsonMapper;
    
    @Autowired
    private RoomGrabJsonMapper roomGrabJsonMapper;
    
    @Autowired
    private UserJsonMapper userJsonMapper;
    
    @Resource
    public void setSuperBaseMapper(RoomJsonMapper roomJsonMapper) {
		super.setBaseMapper(roomJsonMapper);
		this.roomJsonMapper = roomJsonMapper;
	}
    
    @Transactional
    @Override
    public RoomJson enterRoom(Map<String,Object> map){
    	String roomId = map.get("roomId") + "";
    	String roomCode = map.get("roomCode") + "";
    	String userId = map.get("userId") + "";
    	
    	/*************推送消息**************/
		UserJson userJson = userJsonMapper.getInfoById(Long.valueOf(userId));
		Map<String, Object> messageMap = new HashMap<String, Object>();
		messageMap.put("userId", userId);
		messageMap.put("userName", userJson.getNickName());
		messageMap.put("userIcon", userJson.getUserIcon());
		MqUtil.sendMq(roomCode, "3", messageMap);
		
    	/**********插入房间在线人员表***********/
		//异常情况下没有正常退出房间，判断是否此用户在此房间里面
		Map<String, Object> exitsMap = new HashMap<String, Object>();
		exitsMap.put("userId", userId);
		exitsMap.put("roomId", roomId);
		int n = roomOnlineJsonMapper.existsUser(exitsMap);
		if(n>0){
			logger.info("---已经进入房间----  room exit user");
		}else{
			RoomOnlineJson roomOnlineJson = new RoomOnlineJson();
			roomOnlineJson.setRoomId(roomId);
			roomOnlineJson.setUserId(userId);
			roomOnlineJsonMapper.insert(roomOnlineJson);
		}
		/**********获取房间基本信息***********/
		RoomJson roomJson = roomJsonMapper.getInfoById(Long.valueOf(map.get("roomId") + ""));
		roomJson.setFrontPlayUrl(LiveUtil.getLiveUrl(roomJson.getRoomCode(), "00"));
		roomJson.setSidePlayUrl(LiveUtil.getLiveUrl(roomJson.getRoomCode(), "01"));
		/**********获取房间在线人员数**************/
		int sum = roomOnlineJsonMapper.getOnlineSum(roomId);
		roomJson.setRoomPersonNum(sum+"");
		/**********获取房间在线人员***********/
		List<RoomOnlineJson> roomOnlineList = roomOnlineJsonMapper.getPesonList(map);
		roomJson.setPersonList(roomOnlineList);
		
		/**********获取房间抓中记录***********/
		List<RoomGrabJson> roomGrabList = roomGrabJsonMapper.getRoomGrabList(map);
		roomJson.setGrabList(roomGrabList);
		
		return roomJson;
    }
}
