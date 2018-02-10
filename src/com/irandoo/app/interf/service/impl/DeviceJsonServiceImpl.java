package com.irandoo.app.interf.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irandoo.app.interf.json.DeviceJson;
import com.irandoo.app.interf.mapper.DeviceJsonMapper;
import com.irandoo.app.interf.service.DeviceJsonService;
import com.irandoo.xhep.base.service.impl.BaseServiceImpl;

/**
  * <p>Title: </p>
  * <p>Description: </p>
  * <p>Company: irandoo</p> 
  * @author ager
  * @date 2018-1-25上午12:29:40
  */
@Service("deviceJsonService")
public class DeviceJsonServiceImpl extends BaseServiceImpl<DeviceJson> implements DeviceJsonService {
	
	@Autowired
	private DeviceJsonMapper deviceJsonMapper;
    
    @Resource
    public void setSuperBaseMapper(DeviceJsonMapper deviceJsonMapper) {
		super.setBaseMapper(deviceJsonMapper);
		this.deviceJsonMapper = deviceJsonMapper;
	}

	@Override
	public List<DeviceJson> getDeviceByRoom(Map<String, Object> map) {
		return deviceJsonMapper.getDeviceByRoom(map);
	}
}
