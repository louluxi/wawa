package com.irandoo.xhep.base.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.irandoo.xhep.base.mapper.RoomMerchMapper;
import com.irandoo.xhep.base.model.RoomMerch;
import com.irandoo.xhep.base.service.RoomMerchService;

@Service("roomMerchService")
@Transactional
public class RoomMerchServiceImpl extends BaseServiceImpl<RoomMerch> implements RoomMerchService {

	@Autowired
	private RoomMerchMapper roomMerchMapper ;	
	@Resource
	public void setSuperBaseMapper(RoomMerchMapper roomMerchMapper) {
		// TODO Auto-generated method stub
		super.setBaseMapper(roomMerchMapper);
		this.roomMerchMapper = roomMerchMapper;
	}
}
