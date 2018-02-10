package com.irandoo.app.interf.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irandoo.app.interf.json.RoomBarrageJson;
import com.irandoo.app.interf.mapper.RoomBarrageJsonMapper;
import com.irandoo.app.interf.service.RoomBarrageJsonService;
import com.irandoo.xhep.base.service.impl.BaseServiceImpl;

/**
  * <p>Title: </p>
  * <p>Description: </p>
  * <p>Company: irandoo</p> 
  * @author ager
  * @date 2018-1-8下午4:41:01
  */
@Service("roomBarrageJsonService")
public class RoomBarrageJsonServiceImpl extends BaseServiceImpl<RoomBarrageJson> implements RoomBarrageJsonService {
	
    @SuppressWarnings("unused")
	@Autowired
	private RoomBarrageJsonMapper roomBarrageJsonMapper;
    
    @Resource
    public void setSuperBaseMapper(RoomBarrageJsonMapper roomBarrageJsonMapper) {
		super.setBaseMapper(roomBarrageJsonMapper);
		this.roomBarrageJsonMapper = roomBarrageJsonMapper;
	}
}
