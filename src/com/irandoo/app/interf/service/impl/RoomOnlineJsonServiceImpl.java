package com.irandoo.app.interf.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irandoo.app.interf.json.RoomOnlineJson;
import com.irandoo.app.interf.mapper.RoomOnlineJsonMapper;
import com.irandoo.app.interf.service.RoomOnlineJsonService;
import com.irandoo.xhep.base.service.impl.BaseServiceImpl;


/**
  * <p>Title: </p>
  * <p>Description: </p>
  * <p>Company: irandoo</p> 
  * @author ager
  * @date 2018-1-8下午5:16:46
  */
@Service("roomOnlineJsonService")
public class RoomOnlineJsonServiceImpl extends BaseServiceImpl<RoomOnlineJson> implements RoomOnlineJsonService {
	
	@Autowired
	private RoomOnlineJsonMapper roomOnlineJsonMapper;
    
    @Resource
    public void setSuperBaseMapper(RoomOnlineJsonMapper roomOnlineJsonMapper) {
		super.setBaseMapper(roomOnlineJsonMapper);
		this.roomOnlineJsonMapper = roomOnlineJsonMapper;
	}

	@Override
	public void deleteByUserRoom(Map<String, Object> map) {
		roomOnlineJsonMapper.deleteByUserRoom(map);
	}

	@Override
	public void insertHis(RoomOnlineJson roomOnlineJson) {
		roomOnlineJsonMapper.insertHis(roomOnlineJson);
	}

	@Override
	public int existsUser(Map<String, Object> map) {
		return roomOnlineJsonMapper.existsUser(map);
	}

	@Override
	public List<RoomOnlineJson> getPesonList(Map<String, Object> map) {
		
		return roomOnlineJsonMapper.getPesonList(map);
	}

	@Override
	public int getOnlineSum(String roomId) {
		
		return roomOnlineJsonMapper.getOnlineSum(roomId);
	}
}
