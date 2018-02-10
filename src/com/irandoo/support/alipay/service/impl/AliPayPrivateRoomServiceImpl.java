package com.irandoo.support.alipay.service.impl;



import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irandoo.support.alipay.mapper.AliPayPrivateRoomMapper;
import com.irandoo.support.alipay.model.AliPayPrivateRoom;
import com.irandoo.support.alipay.service.AliPayPrivateRoomService;
import com.irandoo.xhep.base.service.impl.BaseServiceImpl;
@Service("aliPayPrivateRoomService")
public class AliPayPrivateRoomServiceImpl extends BaseServiceImpl<AliPayPrivateRoom>
		implements AliPayPrivateRoomService {
	@SuppressWarnings("unused")
	@Autowired
	private AliPayPrivateRoomMapper aliPayPrivateRoomMapper;
    
    @Resource
    public void setSuperBaseMapper(AliPayPrivateRoomMapper aliPayPrivateRoomMapper) {
		super.setBaseMapper(aliPayPrivateRoomMapper);
		this.aliPayPrivateRoomMapper = aliPayPrivateRoomMapper;
	}
	
}
