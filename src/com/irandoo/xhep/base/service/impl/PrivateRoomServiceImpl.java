package com.irandoo.xhep.base.service.impl;



import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.irandoo.xhep.base.mapper.PrivateRoomMapper;
import com.irandoo.xhep.base.model.PrivateRoom;
import com.irandoo.xhep.base.service.PrivateRoomService;

@Service("privateRoomService")
@Transactional
public class PrivateRoomServiceImpl extends BaseServiceImpl<PrivateRoom> implements PrivateRoomService {

	@Autowired
	private PrivateRoomMapper privateRoomMapper ;	
	@Resource
	public void setSuperBaseMapper(PrivateRoomMapper privateRoomMapper ) {
		// TODO Auto-generated method stub
		super.setBaseMapper(privateRoomMapper);
		this.privateRoomMapper = privateRoomMapper;
	}

}
