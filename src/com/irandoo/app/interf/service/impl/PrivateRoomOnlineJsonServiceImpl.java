package com.irandoo.app.interf.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irandoo.app.interf.json.PrivateRoomOnlineJson;
import com.irandoo.app.interf.mapper.PrivateRoomOnlineJsonMapper;
import com.irandoo.app.interf.service.PrivateRoomOnlineJsonService;
import com.irandoo.xhep.base.service.impl.BaseServiceImpl;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Company: irandoo</p> 
 * @author sun
 * @date 2018年1月14日21:37:49
 */
@Service("privateRoomOnlineJsonService")
public class PrivateRoomOnlineJsonServiceImpl extends BaseServiceImpl<PrivateRoomOnlineJson> implements PrivateRoomOnlineJsonService{
	@Autowired
	private PrivateRoomOnlineJsonMapper privateRoomOnlineJsonMapper;
    
    @Resource
    public void setSuperBaseMapper(PrivateRoomOnlineJsonMapper privateRoomOnlineJsonMapper) {
		super.setBaseMapper(privateRoomOnlineJsonMapper);
		this.privateRoomOnlineJsonMapper = privateRoomOnlineJsonMapper;
	}

	@Override
	public void deletePerson(PrivateRoomOnlineJson privateRoomOnlineJson) {
		privateRoomOnlineJsonMapper.deletePerson(privateRoomOnlineJson);
	}

	@Override
	public void deleteALLByRoomId(String roomId) {
		privateRoomOnlineJsonMapper.deleteALLByRoomId(roomId);
	}
	
	
}
