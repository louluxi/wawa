package com.irandoo.app.interf.service;

import java.util.List;
import java.util.Map;

import com.irandoo.app.interf.json.RoomOnlineJson;
import com.irandoo.xhep.base.service.BaseService;

/**
  * <p>Title: </p>
  * <p>Description: </p>
  * <p>Company: irandoo</p> 
  * @author ager
  * @date 2018-1-8下午4:53:24
  */
public interface RoomOnlineJsonService extends BaseService<RoomOnlineJson> {
	void deleteByUserRoom(Map<String,Object> map);
	void insertHis(RoomOnlineJson roomOnlineJson);
	/**
	 * 判断用户是否正在房间中
	 * @param map
	 * @return 是否存在
	 */
	int existsUser(Map<String, Object> map);
	/**
	 * 获取最新三条在线人员
	 * @param map
	 * @return
	 */
	List<RoomOnlineJson> getPesonList(Map<String, Object> map);
	/**
	 * 根据房间id获取房间在线人员数
	 * @param roomId
	 * @return
	 */
	int getOnlineSum(String roomId);
}
