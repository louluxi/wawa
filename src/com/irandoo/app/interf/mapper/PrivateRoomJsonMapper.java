package com.irandoo.app.interf.mapper;

import java.util.List;
import java.util.Map;

import com.irandoo.app.interf.json.PrivateRoomJson;
import com.irandoo.xhep.base.mapper.BaseMapper;

public interface PrivateRoomJsonMapper extends BaseMapper{
	/**
	 *  获取所有包房
	 * @param map
	 * @return
	 */
	 List<PrivateRoomJson> getPrivateRoom(Map<String,Object> map);
	 
	 /**
	  * 获取该用户所有包房
	  * @param map
	  * @return
	  */
	 List<PrivateRoomJson> getMyPrivateRoom(Map<String,Object> map);
	 
	 /**
	  * 根据包房id获取房间id
	  * @param id
	  * @return
	  */
	 String getRoomIdById(String id);
	 
	 /**
	  * 根据房间id获取房间是否可包状态
	  * @param id
	  * @return
	  */
	 String getIsPrivateByRoomId(String id);
	 /**
	  * 返回创建包房信息
	  * @param map
	  * @return
	  */
	 List<PrivateRoomJson> returnInfo(Map<String,Object> map);
	 /**
	  * 获取包房开始以及截至时间
	  * @return
	  */
	 List<PrivateRoomJson> getExpirationDate();
 	 
}
