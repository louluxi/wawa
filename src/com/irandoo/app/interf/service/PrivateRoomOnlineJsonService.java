package com.irandoo.app.interf.service;

import com.irandoo.app.interf.json.PrivateRoomOnlineJson;
import com.irandoo.xhep.base.service.BaseService;

public interface PrivateRoomOnlineJsonService extends BaseService<PrivateRoomOnlineJson>{

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
