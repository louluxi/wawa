package com.irandoo.app.interf.service;

import java.util.Map;

import com.irandoo.app.interf.json.RoomJson;
import com.irandoo.xhep.base.service.BaseService;

/**
  * <p>Title: </p>
  * <p>Description: </p>
  * <p>Company: irandoo</p> 
  * @author ager
  * @date 2018-1-8下午4:53:24
  */
public interface RoomJsonService extends BaseService<RoomJson> {

	RoomJson enterRoom(Map<String, Object> map);

}
