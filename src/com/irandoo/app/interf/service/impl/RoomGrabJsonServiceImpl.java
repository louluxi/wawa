package com.irandoo.app.interf.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irandoo.app.interf.json.RoomGrabJson;
import com.irandoo.app.interf.mapper.RoomGrabJsonMapper;
import com.irandoo.app.interf.service.RoomGrabJsonService;
import com.irandoo.xhep.base.service.impl.BaseServiceImpl;

/**
  * <p>Title: </p>
  * <p>Description: </p>
  * <p>Company: irandoo</p> 
  * @author ager
  * @date 2018-1-8下午5:38:33
  */
@Service("roomGrabJsonService")
public class RoomGrabJsonServiceImpl extends BaseServiceImpl<RoomGrabJson> implements RoomGrabJsonService {
	
	@Autowired
	private RoomGrabJsonMapper roomGrabJsonMapper;
    
    @Resource
    public void setSuperBaseMapper(RoomGrabJsonMapper roomGrabJsonMapper) {
		super.setBaseMapper(roomGrabJsonMapper);
		this.roomGrabJsonMapper = roomGrabJsonMapper;
	}

    @Override
    public List<RoomGrabJson> getBySnapId(Map<String,Object> map){
    	return roomGrabJsonMapper.getBySnapId(map);
    }

	@Override
	public List<RoomGrabJson> getRoomGrabList(Map<String, Object> map) {
		return roomGrabJsonMapper.getRoomGrabList(map);
	}
}
