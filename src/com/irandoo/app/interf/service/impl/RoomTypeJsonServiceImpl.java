package com.irandoo.app.interf.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irandoo.app.interf.json.RoomTypeJson;
import com.irandoo.app.interf.mapper.RoomTypeJsonMapper;
import com.irandoo.app.interf.service.RoomTypeJsonService;
import com.irandoo.xhep.base.service.impl.BaseServiceImpl;

/**
  * <p>Title: </p>
  * <p>Description: </p>
  * <p>Company: irandoo</p> 
  * @author ager
  * @date 2018-1-8下午4:41:01
  */
@Service("roomTypeJsonService")
public class RoomTypeJsonServiceImpl extends BaseServiceImpl<RoomTypeJson> implements RoomTypeJsonService {
	
    @SuppressWarnings("unused")
	@Autowired
	private RoomTypeJsonMapper roomTypeJsonMapper;
    
    @Resource
    public void setSuperBaseMapper(RoomTypeJsonMapper roomTypeJsonMapper) {
		super.setBaseMapper(roomTypeJsonMapper);
		this.roomTypeJsonMapper = roomTypeJsonMapper;
	}
}
