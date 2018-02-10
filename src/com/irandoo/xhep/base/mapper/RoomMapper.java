package com.irandoo.xhep.base.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.irandoo.xhep.base.model.Merch;
import com.irandoo.xhep.base.model.RoomClass;
import com.irandoo.xhep.base.model.RoomClassRef;
import com.irandoo.xhep.base.model.RoomMerch;

public interface RoomMapper extends BaseMapper {
	
	int updatePutaway (HashMap map);
	
	/**
	 * 查询房间类别的名称
	 * @return
	 */
	List<RoomClass> getRoomClassName ();
    
	/**
	 * 通过房间id更新房间类别
	 * @param map
	 * @return
	 */
	int updateRoomClassRefById (Map map);
	
	/**
	 * 通过房间房间id查询设备id
	 * @param id
	 * @return
	 */
	Long getDeviceIdByRoomId (Long id);
	/**
	 * 通过房间房间id查询	前置摄像头id
	 * @param id
	 * @return
	 */
	Long getFrontCameraIdByRoomId (Long id);
	/**
	 * 通过房间房间id查询后置摄像头id
	 * @param id
	 * @return
	 */
	Long getSideCameraIdByRoomId (Long id);
	/**
	 * 更新设备id
	 * @param map
	 * @return
	 */
	int updateDevicecode (Map map);
	/**
	 * 通过房间房间id查询商品类型id
	 * @param id
	 * @return
	 */
	Long getMerchTypeIdByRoomId (Long id);
	/**
	 * 更新房间类别编码
	 * @param map
	 * @return
	 */
	int updateMerchTypeCode (Map map);
	/**
	 * 更新房间商品的房间商品数量
	 * @param map
	 * @return
	 */
	int updateMerchNum (Map map);
	/**
	 * 根据设备编码查询设备id
	 * @param device_code
	 * @return
	 */
	Long getDeviceIdByDeviceCode (String device_code);
	/**
	 * 根据商品类型码得到商品id
	 * @param type_code
	 * @return
	 */
	Long getMerchIdByMerchTypeCode (String type_code);
	/**
	 * 添加房间商品表
	 * @param roomMerch
	 * @return
	 */
	int insertRoomMerch (RoomMerch roomMerch);
	/**
	 * 添加房间与类别关联表
	 * @param roomClassRef
	 * @return
	 */
	int insertRoomClassRef (RoomClassRef roomClassRef);
	/**
	 * 根据房间id更新房间编号
	 * @param map
	 * @return
	 */
	int updateRoomCodeByRoomId (Map map);
	/**
	 * 根据房间id查询房间上下架状态
	 * @param id
	 * @return
	 */
	int  selputawayByRoomId (Long id);
	
	/**
	 * 查询商品表
	 */
	List<Merch> selmerch ();
	
	/**
	 * 删除房间商品表
	 * @param id
	 * @return
	 */
	int deleteRoomMerch (Long id);
	/**
	 * 删除房间类别表
	 * @param id
	 * @return
	 */
	int deleteRoomClass (Long id);
}
