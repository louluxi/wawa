package com.irandoo.app.interf.util;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.irandoo.app.interf.json.RoomGrabJson;
import com.irandoo.app.interf.json.RoomJson;
import com.irandoo.app.interf.json.UserJson;
import com.irandoo.app.interf.service.RoomGrabJsonService;
import com.irandoo.app.interf.service.UserJsonService;

/**
  * 监测玩游戏过程是否正常
  * <p>Title: </p>
  * <p>Description: </p>
  * <p>Company: irandoo</p> 
  * @author ager
  * @date 2018-1-30下午1:24:23
 */
public class GameEvent extends Thread {
	
	/**
	 * 监测玩游戏过程是否正常
	 * @param afterTime
	 * @param snapid
	 */
	public static void checkGame(String afterTime, String snapid, String userId){
		Thread thread = new GameEvent(afterTime, snapid, userId);
		thread.start();
	}
	
	public GameEvent(String afterTime, String snapid, String userId) {
		this.afterTime = afterTime;
		this.snapid = snapid;
		this.userId = userId;
	}
	
	public void run() {
		try {
			long sleepTime = Long.valueOf(afterTime);
			Thread.sleep(sleepTime);
			
			WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
	        RoomGrabJsonService roomGrabJsonService = (RoomGrabJsonService) wac.getBean("roomGrabJsonService");
	        UserJsonService userJsonService = (UserJsonService) wac.getBean("userJsonService");
    		Map<String,Object> map = new HashMap<String,Object>();
    		map.put("userId", userId);
    		/********************根据用户id获取抓取记录最新的一条***********************/
    		List<RoomGrabJson> grabList = roomGrabJsonService.getBySnapId(map);
    		RoomGrabJson roomGrabJson = grabList.get(0);
    		/********************如果最新的一条抓取记录的游戏码跟开启定时点的游戏码一致，表示该用户没有再玩一局，释放房间状态***********************/
    		if(snapid.equals(roomGrabJson.getSnapid())){
    			/************获取用户详情************/
    			UserJson userJson = userJsonService.getInfoById(Long.valueOf(roomGrabJson.getUserId()));
    			
    			/************设置房间状态为空闲************/
    			RoomJson paramJson = new RoomJson();
    			paramJson.setId(roomGrabJson.getRoomId());
    			paramJson.setRoomCode(roomGrabJson.getRoomCode());
    			paramJson.setStatus("0");
    			RoomJson.setRoomById(paramJson, userJson);
    			if("2".equals(roomGrabJson.getStatus())){
        	    	/*************更新对应抓取记录的状态**************/
        			roomGrabJson.setStatus("0");
        			roomGrabJson.setGrabTime(new Date());
        			roomGrabJsonService.update(roomGrabJson);
        		}
    		}
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private String afterTime;
	private String snapid;
	private String userId;
	public static void main(String[] args) {
//		checkGame("5000", "123456");
	}
}