package com.irandoo.xhep.base.service.impl;



import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irandoo.xhep.base.mapper.RoomClassMapper;
import com.irandoo.xhep.base.model.RoomClass;
import com.irandoo.xhep.base.service.RoomClassService;
@Service("roomClassService")
public class RoomClassServiceImpl extends BaseServiceImpl<RoomClass> implements RoomClassService {

	@Autowired
	private RoomClassMapper roomClassMapper;
	
	@Resource
    public void setSuperBaseMapper(RoomClassMapper roomClassMapper) {
		super.setBaseMapper(roomClassMapper);
		this.roomClassMapper = roomClassMapper;
	}
	

}
