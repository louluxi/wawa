package com.irandoo.app.interf.action;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.irandoo.app.interf.json.RoomBarrageJson;
import com.irandoo.app.interf.json.UserJson;
import com.irandoo.app.interf.service.RoomBarrageJsonService;
import com.irandoo.app.interf.service.UserJsonService;
import com.irandoo.app.interf.util.MqUtil;
import com.irandoo.xhep.base.action.BaseAction;

/**
  * <p>Title: 弹幕相关接口</p>
  * <p>Description: </p>
  * <p>Company: irandoo</p> 
  * @author ager
  * @date 2018-1-25上午1:08:24
  */
@Controller("roomBarrageJsonAction")
@Scope("prototype")
public class RoomBarrageJsonAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	@Autowired
    private RoomBarrageJsonService roomBarrageJsonService;
	@Autowired
	private UserJsonService userJsonService;
    
	public String getRoomBarrage() {
		return returnJson(roomBarrageJsonService.getAllList(getInterfMap()), "0", "");
	}
	public String setRoomBarrage() {
		Map<String,Object> map = getInterfMap();
		String roomId = map.get("roomId") + "";
		String roomCode = map.get("roomCode") + "";
		String userId = map.get("userId") + "";
		String content = map.get("content") + "";
		
		/*************推送消息**************/
		UserJson userJson = userJsonService.getInfoById(Long.valueOf(userId));
		Map<String, Object> messageMap = new HashMap<String, Object>();
		messageMap.put("userId", userId);
		messageMap.put("userName", userJson.getNickName());
		messageMap.put("userIcon", userJson.getUserIcon());
		messageMap.put("msg", content);
		MqUtil.sendMq(roomCode, "2", messageMap);
		
		/*************将消息保存到数据库**************/
		RoomBarrageJson roomBarrageJson = new RoomBarrageJson();
		roomBarrageJson.setRoomId(roomId);
		roomBarrageJson.setUserId(userId);
		roomBarrageJson.setContent(content);
		roomBarrageJsonService.insert(roomBarrageJson);
		
		return returnJson("", "0", "");
	}
}
