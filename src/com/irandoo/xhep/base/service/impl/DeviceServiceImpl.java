package com.irandoo.xhep.base.service.impl;


import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irandoo.xhep.base.mapper.DeviceMapper;
import com.irandoo.xhep.base.model.Device;
import com.irandoo.xhep.base.service.DeviceService;

@Service("deviceService")
public class DeviceServiceImpl extends BaseServiceImpl<Device> implements DeviceService {

	@Autowired
	private DeviceMapper deviceMapper;
	
	@Resource
	public void setSuperBaseMapper(DeviceMapper deviceMapper) {
		// TODO Auto-generated method stub
		super.setBaseMapper(deviceMapper);
		this.deviceMapper = deviceMapper;
	}

}
