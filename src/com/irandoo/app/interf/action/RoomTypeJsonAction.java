package com.irandoo.app.interf.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.irandoo.app.interf.json.RoomTypeJson;
import com.irandoo.app.interf.service.RoomJsonService;
import com.irandoo.app.interf.service.RoomTypeJsonService;
import com.irandoo.xhep.base.action.BaseAction;

/**
  * <p>Title: 房间类别接口</p>
  * <p>Description: </p>
  * <p>Company: irandoo</p> 
  * @author ager
  * @date 2018-1-8下午4:43:55
  */
@Controller("roomTypeJsonAction")
@Scope("prototype")
public class RoomTypeJsonAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	@Autowired
    private RoomTypeJsonService roomTypeJsonService;
	
	@Autowired
	private RoomJsonService roomJsonService;
    
	public String getHomeRoomList() {
		List<RoomTypeJson> roomTypeList = new ArrayList<RoomTypeJson>();
		roomTypeList = roomTypeJsonService.getAllList(getInterfMap());
		for(RoomTypeJson roomTypeJson:roomTypeList){
			Map<String,Object> map = getInterfMap();
			map.put("typeId", roomTypeJson.getId());
			roomTypeJson.setRooms(roomJsonService.getAllList(map));
		}
		return returnJson(roomTypeList, "0", "");
	}
	
	public String getRoomTypeList(){

		return returnJson(roomTypeJsonService.getAllList(null), "0", "");
	}
    
}
