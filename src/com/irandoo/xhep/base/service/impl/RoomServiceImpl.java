package com.irandoo.xhep.base.service.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.irandoo.xhep.base.mapper.RoomMapper;
import com.irandoo.xhep.base.model.Merch;
import com.irandoo.xhep.base.model.Room;
import com.irandoo.xhep.base.model.RoomClass;
import com.irandoo.xhep.base.model.RoomClassRef;
import com.irandoo.xhep.base.model.RoomMerch;
import com.irandoo.xhep.base.service.RoomService;
@Service("roomService")
@Transactional
public class RoomServiceImpl extends BaseServiceImpl<Room> implements RoomService {

	@Autowired
	private RoomMapper roomMapper;
	
	@Resource
	public void setSuperBaseMapper(RoomMapper roomMapper) {
		// TODO Auto-generated method stub
		super.setBaseMapper(roomMapper);
		this.roomMapper = roomMapper;
	}
	@Transactional
	public int updatePutaway (HashMap map) {
	   return roomMapper.updatePutaway(map);
	}
	@Override
	public List<RoomClass> getRoomClassName() {
		// TODO Auto-generated method stub
		return roomMapper.getRoomClassName();
	}
	@Override
	@Transactional
	public int updateRoomClassRefById(Map map) {
		// TODO Auto-generated method stub
		return roomMapper.updateRoomClassRefById(map);
	}
	@Override
	public Long getDeviceIdByRoomId(Long id) {
		// TODO Auto-generated method stub
		return roomMapper.getDeviceIdByRoomId(id);
	}
	@Override
	public Long getFrontCameraIdByRoomId(Long id) {
		// TODO Auto-generated method stub
		return roomMapper.getFrontCameraIdByRoomId(id);
	}
	@Override
	public Long getSideCameraIdByRoomId(Long id) {
		// TODO Auto-generated method stub
		return roomMapper.getSideCameraIdByRoomId(id);
	}
	@Override
	@Transactional
	public int updateDevicecode(Map map) {
		// TODO Auto-generated method stub
		return roomMapper.updateDevicecode(map);
	}
	@Override
	public Long getMerchTypeIdByRoomId(Long id) {
		// TODO Auto-generated method stub
		return roomMapper.getMerchTypeIdByRoomId(id);
	}
	@Override
	@Transactional
	public int updateMerchTypeCode(Map map) {
		// TODO Auto-generated method stub
		return roomMapper.updateMerchTypeCode(map);
	}
	@Override
	@Transactional
	public int updateMerchNum(Map map) {
		// TODO Auto-generated method stub
		return roomMapper.updateMerchNum(map);
	}
	@Override
	public Long getDeviceIdByDeviceCode(String device_code) {
		// TODO Auto-generated method stub
		return roomMapper.getDeviceIdByDeviceCode(device_code);
	}
	@Override
	public Long getMerchIdByMerchTypeCode(String type_code) {
		// TODO Auto-generated method stub
		return roomMapper.getMerchIdByMerchTypeCode(type_code);
	}
	@Override
	@Transactional
	public int insertRoomMerch(RoomMerch roomMerch) {
		// TODO Auto-generated method stub
		return roomMapper.insertRoomMerch(roomMerch);
	}
	@Override
	public int insertRoomClassRef(RoomClassRef roomClassRef) {
		// TODO Auto-generated method stub
		return roomMapper.insertRoomClassRef(roomClassRef);
	}
	@Override
	public int updateRoomCodeByRoomId(Map map) {
		// TODO Auto-generated method stub
		return roomMapper.updateRoomCodeByRoomId(map);
	}
	@Override
	public int selputawayByRoomId(Long id) {
		// TODO Auto-generated method stub
		return roomMapper.selputawayByRoomId(id);
	}
	@Override
	public List<Merch> selmerch() {
		// TODO Auto-generated method stub
		return roomMapper.selmerch();
	}
	@Override
	public int deleteRoomMerch(Long id) {
		// TODO Auto-generated method stub
		return roomMapper.deleteRoomMerch(id);
	}
	@Override
	public int deleteRoomClass(Long id) {
		// TODO Auto-generated method stub
		return roomMapper.deleteRoomClass(id);
	};
}
