package com.irandoo.app.interf.util;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import abu.pool.service.Event;

import com.conn123.wawadmin.bean.judge.JGameStatus;
import com.irandoo.app.interf.json.RoomGrabJson;
import com.irandoo.app.interf.json.RoomJson;
import com.irandoo.app.interf.json.UserMerchJson;
import com.irandoo.app.interf.service.RoomGrabJsonService;
import com.irandoo.app.interf.service.UserMerchJsonService;
/**
  * 游戏结束回调工具类
  * <p>Title: </p>
  * <p>Description: </p>
  * <p>Company: irandoo</p> 
  * @author ager
  * @date 2018-1-31上午9:58:04
 */
public class GameResultProcess implements Event{
	private Log logger = LogFactory.getLog(GameResultProcess.class);
	@Override
	public void notice(Object... o) {
		logger.info("enter notice.........");
		JGameStatus gameStatus = (JGameStatus)o[0];
		logger.info("gameStatus shi ti:"+gameStatus);
		WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
        RoomGrabJsonService roomGrabJsonService = (RoomGrabJsonService) wac.getBean("roomGrabJsonService");
        UserMerchJsonService userMerchJsonService = (UserMerchJsonService) wac.getBean("userMerchJsonService");
        Map<String,Object> map1 = null;
    	/*************根据snapId游戏码，获取对应的抓取记录**************/
    	map1 = new HashMap<String,Object>();
    	map1.put("snapid", gameStatus.getSnapId());
    	logger.info("gameStatus.getSnapId():"+gameStatus.getSnapId());
    	List<RoomGrabJson> grabList = roomGrabJsonService.getBySnapId(map1);
    	if(grabList.size()>0){
    		RoomGrabJson roomGrab = grabList.get(0);
    		roomGrab.setSnapid(gameStatus.getSnapId());
    		roomGrab.setGrabTime(new Date());
    		logger.info("roomGrab mei pan duan begin++++");
    		logger.info("roomGrab.getUserId()"+roomGrab.getUserId());
    		logger.info("roomGrab.getRoomId()"+roomGrab.getRoomId());
    		logger.info("roomGrab.getMerchId()"+roomGrab.getMerchId());
    		logger.info("roomGrab.getId()"+roomGrab.getId());
    		logger.info("roomGrab mei pan duan  end+++++");
    		/*************将内存里对应房间的游戏码置空**************/
    		RoomJson.removeRoomSnapId(roomGrab.getRoomId());
    		logger.info(roomGrab+"    roomGrab ");
    		logger.info(roomGrab.getGameType()+"roomGrab gameType");
    		logger.info("pan duan shi fuo zhua zhong+gameStatus.getResult():"+gameStatus.getResult());
    		/*************判读游戏结果是否抓中，抓中则再判断是正常游戏还是练习，如果是正常游戏，则往会员娃娃表里面插入一条字段**************/
    		if(1 == gameStatus.getResult()){
    			roomGrab.setStatus("1");
    			if("0".equals(roomGrab.getGameType())){
    				logger.info("roomGrab pan duan guo  begin....");
    				logger.info("roomGrab.getUserId():"+roomGrab.getUserId());
    				logger.info("roomGrab.getRoomId():"+roomGrab.getRoomId());
    				logger.info("roomGrab.getMerchId():"+roomGrab.getMerchId());
    				logger.info("roomGrab.getId():"+roomGrab.getId());
    				logger.info("roomGrab pan duan guo end....");
    				UserMerchJson userMerchJson = new UserMerchJson();
    				userMerchJson.setUserId(roomGrab.getUserId());
    				userMerchJson.setRoomId(roomGrab.getRoomId());
    				userMerchJson.setMerchId(roomGrab.getMerchId());
    				userMerchJson.setGrabId(roomGrab.getId());
    				userMerchJson.setStatus("1");
    				userMerchJsonService.insert(userMerchJson);
    			}
    		}else{
    			logger.info("mei zhua zhong .....");
    			roomGrab.setStatus("0");
    		}
    		logger.info("geng xin zhua qu ji lu....roomGrab update");
    		roomGrabJsonService.update(roomGrab);
    	}else{
    		logger.info("未找到对应游戏记录：snapid="+gameStatus.getSnapId());
    	}
	}

}
