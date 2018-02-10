package com.irandoo.app.interf.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irandoo.app.interf.json.PrivateRoomJson;
import com.irandoo.app.interf.mapper.PrivateRoomJsonMapper;
import com.irandoo.app.interf.service.PrivateRoomJsonService;
import com.irandoo.xhep.base.service.impl.BaseServiceImpl;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Company: irandoo</p> 
 * @author sun
 * @date 2018-1-9下午8:31:51
 */
@Service("privateRoomJsonService")
public class PrivateRoomJsonServiceImpl extends BaseServiceImpl<PrivateRoomJson> implements PrivateRoomJsonService{

	
	@Autowired
	private PrivateRoomJsonMapper privateRoomJsonMapper;
    
    @Resource
    public void setSuperBaseMapper(PrivateRoomJsonMapper privateRoomJsonMapper) {
		super.setBaseMapper(privateRoomJsonMapper);
		this.privateRoomJsonMapper = privateRoomJsonMapper;
	}
	
	
	@Override
	public List<PrivateRoomJson> getPrivateRoom(Map<String, Object> map) {
		
		return privateRoomJsonMapper.getPrivateRoom(map);
	}

	@Override
	public List<PrivateRoomJson> getMyPrivateRoom(Map<String, Object> map) {
		
		return privateRoomJsonMapper.getMyPrivateRoom(map);
	}


	@Override
	public String getRoomIdById(String id) {
		
		return privateRoomJsonMapper.getRoomIdById(id);
	}


	@Override
	public String getIsPrivateByRoomId(String id) {
		
		return privateRoomJsonMapper.getIsPrivateByRoomId(id);
	}


	@Override
	public List<PrivateRoomJson> returnInfo(Map<String, Object> map) {
	
		return privateRoomJsonMapper.returnInfo(map);
	}


	@Override
	public List<PrivateRoomJson> getExpirationDate() {
	
		return privateRoomJsonMapper.getExpirationDate();
	}

}
