package com.irandoo.app.interf.service;

import java.util.List;
import java.util.Map;

import com.irandoo.app.interf.json.DeviceJson;
import com.irandoo.xhep.base.service.BaseService;

/**
  * <p>Title: </p>
  * <p>Description: </p>
  * <p>Company: irandoo</p> 
  * @author ager
  * @date 2018-1-25上午12:29:11
  */
public interface DeviceJsonService extends BaseService<DeviceJson> {
	List<DeviceJson> getDeviceByRoom(Map<String,Object> map);
}
