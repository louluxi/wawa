package com.irandoo.app.interf.mapper;

import com.irandoo.app.interf.json.PrivateRoomOnlineJson;
import com.irandoo.xhep.base.mapper.BaseMapper;

public interface PrivateRoomOnlineJsonMapper extends BaseMapper{
	/**
	 * @author sun	
	 * @param privateRoomOnlineJson
	 */
	void deletePerson(PrivateRoomOnlineJson privateRoomOnlineJson);
	
	/**
	 * @description：根据房间id删除房间所有在线人员
	 * @author sun
	 * @param roomId
	 */
	void deleteALLByRoomId(String roomId);

}
