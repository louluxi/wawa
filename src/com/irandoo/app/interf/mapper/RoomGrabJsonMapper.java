package com.irandoo.app.interf.mapper;

import java.util.List;
import java.util.Map;

import com.irandoo.app.interf.json.RoomGrabJson;
import com.irandoo.xhep.base.mapper.BaseMapper;

/**
  * <p>Title: </p>
  * <p>Description: </p>
  * <p>Company: irandoo</p> 
  * @author ager
  * @date 2018-1-8上午11:12:43
  */
public interface RoomGrabJsonMapper extends BaseMapper {
	List<RoomGrabJson> getBySnapId(Map<String,Object> map);
	/**
	 * 获取抓取记录最新10条
	 * @param map
	 * @return
	 */
	List<RoomGrabJson> getRoomGrabList(Map<String,Object> map);
}
