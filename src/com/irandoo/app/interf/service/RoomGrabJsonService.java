package com.irandoo.app.interf.service;

import java.util.List;
import java.util.Map;

import com.irandoo.app.interf.json.RoomGrabJson;
import com.irandoo.xhep.base.service.BaseService;

/**
  * <p>Title: </p>
  * <p>Description: </p>
  * <p>Company: irandoo</p> 
  * @author ager
  * @date 2018-1-8下午5:56:23
  */
public interface RoomGrabJsonService extends BaseService<RoomGrabJson> {

	List<RoomGrabJson> getBySnapId(Map<String, Object> map);
	/**
	 * 获取抓取记录最新10条
	 * @param map
	 * @return
	 */
	List<RoomGrabJson> getRoomGrabList(Map<String,Object> map);

}
