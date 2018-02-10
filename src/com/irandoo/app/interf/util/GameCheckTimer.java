package com.irandoo.app.interf.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.irandoo.app.interf.json.RoomGrabJson;
import com.irandoo.app.interf.json.RoomJson;
import com.irandoo.app.interf.json.UserJson;
import com.irandoo.app.interf.service.RoomGrabJsonService;
import com.irandoo.app.interf.service.RoomJsonService;
import com.irandoo.app.interf.service.UserJsonService;

/**
  * <p>Title:定时监测房间状态是否异常 </p>
  * <p>Description: </p>
  * <p>Company: irandoo</p> 
  * @author ager
  * @date 2018-1-31上午9:54:35
  */
public class GameCheckTimer extends Thread {

	@Override
	public void run() {
		WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
		RoomGrabJsonService roomGrabJsonService = (RoomGrabJsonService) wac.getBean("roomGrabJsonService");
		RoomJsonService roomJsonService = (RoomJsonService) wac.getBean("roomJsonService");
		UserJsonService userJsonService = (UserJsonService) wac.getBean("userJsonService");
		while (true) {
			try {
				Thread.sleep(60000);//一分钟监测一次
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			RoomJson roomJson = null;
			List<RoomGrabJson> grabList = null;
			Map<String, Object> map = null;
			
			/*******判断还在游戏中的房间，最近一次游戏记录时间与当前时间对比，如果超过一分钟，则把房间状态设置为空闲********/
			synchronized (RoomJson.roomMap) {
				for (RoomJson room : RoomJson.roomMap.values()) {  
					synchronized (room) {
						if("1".equals(room.getStatus())){
							map = new HashMap<String, Object>();
							map.put("checkTime", 1);//时间间隔，默认1分钟
							map.put("roomId", room.getId());
							grabList = roomGrabJsonService.getAllList(map);
							if (grabList.size() > 0) {
								/************设置房间状态************/
								RoomJson paramJson = new RoomJson();
								paramJson.setId(room.getId());
								paramJson.setRoomCode(grabList.get(0).getRoomCode());
								paramJson.setStatus("0");
								/************获取用户详情************/
				    			UserJson userJson = userJsonService.getInfoById(Long.valueOf(grabList.get(0).getUserId()));
								RoomJson.setRoomById(paramJson, userJson);
								
								/*********将数据库里面房间状态设置为空闲***********/
								roomJson = roomJsonService.getInfoById(Long.valueOf(room.getId()));
								roomJson.setStatus("0");
								roomJsonService.update(roomJson);
							}
						}
					}
				}
			}
		}
	}

}