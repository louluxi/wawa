package com.irandoo.xhep.base.action;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.irandoo.xhep.base.model.Device;
import com.irandoo.xhep.base.model.Dictionary;
import com.irandoo.xhep.base.model.Merch;
import com.irandoo.xhep.base.model.MerchType;
import com.irandoo.xhep.base.model.Room;
import com.irandoo.xhep.base.model.RoomClass;
import com.irandoo.xhep.base.model.RoomClassRef;
import com.irandoo.xhep.base.model.RoomMerch;
import com.irandoo.xhep.base.service.MerchService;
import com.irandoo.xhep.base.service.RoomMerchService;
import com.irandoo.xhep.base.service.RoomService;
import com.irandoo.xhep.base.util.ImageUploadUtil;
import com.irandoo.xhep.base.util.StringComplemen;
import com.irandoo.xhep.sys.service.DictionaryService;

@Controller("roomAction")
@Scope("prototype")
public class RoomAction extends BaseAction {

	/**
	 * 版本号
	 */
	private static final long serialVersionUID = -5361779391809516207L;
	private Log logger = LogFactory.getLog(RoomAction.class);
	@Autowired
	private RoomService roomService;
	private Room room;//房间
	private List<RoomClass> roomClassList;//房间类别
	private List<Dictionary> roomPrivateList;//包房状态
	private List<Dictionary> roomPutawayList;//房间上架状态
    private List<Dictionary> roomStatusList;//房间状态
    private List<Dictionary> isTopList;//是否置顶
	@Autowired
    private DictionaryService dictionaryService; 
	private RoomClassRef roomClassRef;//房间与类别关联表
	private Device sideCameraDevice;//侧面摄像头
	private Device frontCameraDevice;//前面摄像头
	private Device device;//娃娃机
	private MerchType merchType;//商品类别表
	private RoomMerch roomMerch;//房间商品表
	private File roomIconfile;//房间缩略图
	private File backgroundMusicfile;//房间背景音乐
	private File backgroundfile;//房间背景图
	private String roomIconfileFileName;
	private String backgroundMusicfileFileName;
	private String backgroundfileFileName;
	private List<Merch> merchList;
	
	/**
	 * 跳转及数据字典
	 * 
	 * @return
	 */
	public String toLoadList() {
		roomPrivateList = dictionaryService.getByDescript("包房状态");
		roomPutawayList = dictionaryService.getByDescript("房间上架状态");
		roomStatusList = dictionaryService.getByDescript("房间状态");
		isTopList = dictionaryService.getByDescript("是否");
		roomClassList = roomService.getRoomClassName();
		request.setAttribute("title", "房间管理");
		return SUCCESS;
	}
	/**
	 * 加载数据
	 * @return
	 */
	public String getAjaxData() {
		String jsonData = roomService.getInfoListStr(getConditionMap());
	    return toJsonData(jsonData);
	}
	/**
	 * 删除
	 * @return
	 */
	public String delete() {
		logger.debug("enter delete");
		boolean result = true;
		String id = request.getParameter("ids");
		logger.info("id:"+id);
	    try {
	    	  if (String.valueOf(roomService.selputawayByRoomId(Long.valueOf(id))) != null && "0".equals(String.valueOf(roomService.selputawayByRoomId(Long.valueOf(id))))) {
	    		  roomService.deleteRoomClass(Long.valueOf(id));//删除房间类别关联表
	    		  roomService.deleteRoomMerch(Long.valueOf(id));//删除房间商品表
	    		  roomService.deleteById(Long.valueOf(id));//删除房间  
	    		  return result(result);
	    	  }else {
	    		  result= false;
	    		  return result(result);
	    	  }
	    		
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}
	    logger.debug("exit delete");

		return result(result);
	}
	/**
	 * 更改房间上架状态
	 * @return
	 */
	public String updatePutaway() {
		logger.debug("enter updatePutaway");
		boolean result = true;
		String id = request.getParameter("id");
		String is_putaway = request.getParameter("is_putaway");
		HashMap updatePutawayMap = new HashMap<>();
		updatePutawayMap.put("id", id);
		updatePutawayMap.put("is_putaway", is_putaway);
	    try {
	    	roomService.updatePutaway(updatePutawayMap);
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}

		return result(result);
	}
	/**
	 * 查看数据
	 * @return
	 */
	public String getInfoById() {
		logger.debug("enter getInfoById");
		String id = request.getParameter("id");
		String opt = request.getParameter("opt");
		roomPrivateList = dictionaryService.getByDescript("包房状态");
		roomPutawayList = dictionaryService.getByDescript("房间上架状态");
		roomStatusList = dictionaryService.getByDescript("房间状态");
		isTopList = dictionaryService.getByDescript("是否");
		roomClassList = roomService.getRoomClassName();
		merchList = roomService.selmerch();
		if (StringUtils.isEmpty(opt)) {
			return ERROR;
		}
		// 新增页面
		if (ADD.equals(opt)) {
			room = new Room();
			request.setAttribute("title", "房间新增");
		}
		// 修改页面
		else if (UPDATE.equals(opt)) {
			room = roomService.getInfoById(Long.parseLong(id));	
			request.setAttribute("title", "房间修改");
		}
		// 分配页面
		else if (VIEW.equals(opt)) {
			
		}
		else {
			request.setAttribute("title", "房间管理");
		}
		return SUCCESS;
	}
	
	
	/**
	 * 保存数据
	 * @return
	 */
	public String saveOrUpdate() {
		logger.debug("enter saveOrUpdate");
		if (room == null) {
			room = new Room();
		}
		if (roomClassRef == null) {
			roomClassRef = new RoomClassRef();
		}
		if (sideCameraDevice == null) {
			sideCameraDevice = new Device();
		}
		if (frontCameraDevice == null) {
			frontCameraDevice = new Device();
		}
		if (device == null) {
			device = new Device();
		}
		if (merchType == null) {
			merchType = new MerchType();
		}
		if (roomMerch == null) {
			roomMerch = new RoomMerch();
		}
		if (room.getId() == null) {
			try {
				if (device.getDevice_code() != null) {
					room.setDevice_id(roomService.getDeviceIdByDeviceCode(device.getDevice_code()));
				}
				if (frontCameraDevice.getDevice_code() != null) {
					room.setFront_camera_id(roomService.getDeviceIdByDeviceCode(frontCameraDevice.getDevice_code()));
				}
				if (sideCameraDevice.getDevice_code() != null) {
					room.setSide_camera_id(roomService.getDeviceIdByDeviceCode(sideCameraDevice.getDevice_code()));
				}
				if (roomIconfile != null) {
					String roomIcon = ImageUploadUtil.upload(roomIconfile,this.roomIconfileFileName,"room");
					room.setRoom_icon(roomIcon);
				}
				if (backgroundMusicfile != null) {
					String backgroundMusic = ImageUploadUtil.upload(backgroundMusicfile,this.backgroundMusicfileFileName,"other");
					room.setBackground_music(backgroundMusic);
				}
				if (backgroundfile !=null) {
					String background = ImageUploadUtil.upload(backgroundfile,this.backgroundfileFileName,"room");
				    room.setBackground_img(background);
				}
				if (roomMerch.getMerch_id()!= null) {
					room.setMerch_id(roomMerch.getMerch_id());
				}
				//添加房间
				roomService.insert(room);
				//添加房间商品
				if (room.getId() != null) {
					roomMerch.setRoom_id(room.getId());
					roomService.insertRoomMerch(roomMerch);
				}
				//添加房间类别关联
				if (room.getId() != null) {
					if (room.getClassIds() != null) {
						String[] classIdArr = room.getClassIds().split(",");
						for (String classId:classIdArr) {
							RoomClassRef roomClassRef = new RoomClassRef();
							roomClassRef.setRoom_id(room.getId());
							roomClassRef.setClass_id(Long.valueOf(classId.trim()));
							roomService.insertRoomClassRef(roomClassRef);
						}
					}
			
				}
			} catch (Exception e) {
				e.printStackTrace();
				return SUCCESS;
			}
			return SUCCESS;
		}else {
			try {
				if (roomIconfile != null) {
					String roomIcon = ImageUploadUtil.upload(roomIconfile,this.roomIconfileFileName,"room");
					room.setRoom_icon(roomIcon);
				}
				if (backgroundMusicfile != null) {
					String backgroundMusic = ImageUploadUtil.upload(backgroundMusicfile,this.backgroundMusicfileFileName,"other");
					room.setBackground_music(backgroundMusic);
				}
				if (backgroundfile !=null) {
					String background = ImageUploadUtil.upload(backgroundfile,this.backgroundfileFileName,"room");
				    room.setBackground_img(background);
				}
				if (roomMerch.getMerch_id()!=null) {
					room.setMerch_id(roomMerch.getMerch_id());
				}
				roomService.update(room);//更新房间
				
				//更新房间类别
				roomService.deleteRoomClass(Long.valueOf(room.getId()));//删除房间类别关联表
			
				if (room.getId() != null) {
					if (room.getClassIds() != null) {
						String[] classIdArr = room.getClassIds().split(",");
						for (String classId:classIdArr) {
							RoomClassRef roomClassRef = new RoomClassRef();
							roomClassRef.setRoom_id(room.getId());
							roomClassRef.setClass_id(Long.valueOf(classId.trim()));
							roomService.insertRoomClassRef(roomClassRef);
						}
					}

				}
				//更新设备编码 
				if (device.getDevice_code() != null) {
				  Long  deviceId = roomService.getDeviceIdByRoomId(room.getId());
				  Map deviceMap = new HashMap();
				  deviceMap.put("device_code", device.getDevice_code());
				  deviceMap.put("id", deviceId);
				  roomService.updateDevicecode(deviceMap);
				}
				//更新前置摄像头编码
				if (frontCameraDevice.getDevice_code() != null) {
					Long  frontCameraId =  roomService.getFrontCameraIdByRoomId(room.getId());
					Map   frontCameraMap = new HashMap();
					frontCameraMap.put("device_code", frontCameraDevice.getDevice_code());
					frontCameraMap.put("id", frontCameraId);
					roomService.updateDevicecode(frontCameraMap);
				}
				//更新后置摄像头
				if (sideCameraDevice.getDevice_code() != null) {
					Long  sideCameraId =  roomService.getSideCameraIdByRoomId(room.getId());
					Map   sideCameraMap = new HashMap();
					sideCameraMap.put("device_code", sideCameraDevice.getDevice_code());
					sideCameraMap.put("id", sideCameraId);
					roomService.updateDevicecode(sideCameraMap);
				}
				//跟新房间商品的商品数量
				Map   merchNumMap = new HashMap();
				merchNumMap.put("merch_num", roomMerch.getMerch_num());
				merchNumMap.put("room_id", room.getId());
				merchNumMap.put("merch_id", roomMerch.getMerch_id());
				int updateMerchNumCount = roomService.updateMerchNum(merchNumMap);
				//如果更新为零，则添加房间商品表
				if ("0".equals(String.valueOf(updateMerchNumCount))&&null != String.valueOf(updateMerchNumCount)) {
					if (room.getId() != null) {
						roomMerch.setRoom_id(room.getId());
						roomService.insertRoomMerch(roomMerch);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				return SUCCESS;
			}
			return SUCCESS;
		}
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public List<Dictionary> getRoomPrivateList() {
		return roomPrivateList;
	}
	public void setRoomPrivateList(List<Dictionary> roomPrivateList) {
		this.roomPrivateList = roomPrivateList;
	}
	public List<Dictionary> getRoomPutawayList() {
		return roomPutawayList;
	}
	public void setRoomPutawayList(List<Dictionary> roomPutawayList) {
		this.roomPutawayList = roomPutawayList;
	}
	public List<Dictionary> getRoomStatusList() {
		return roomStatusList;
	}
	public void setRoomStatusList(List<Dictionary> roomStatusList) {
		this.roomStatusList = roomStatusList;
	}
	public RoomClassRef getRoomClassRef() {
		return roomClassRef;
	}
	public void setRoomClassRef(RoomClassRef roomClassRef) {
		this.roomClassRef = roomClassRef;
	}
	public List<Dictionary> getIsTopList() {
		return isTopList;
	}
	public void setIsTopList(List<Dictionary> isTopList) {
		this.isTopList = isTopList;
	}
	public List<RoomClass> getRoomClassList() {
		return roomClassList;
	}
	public void setRoomClassList(List<RoomClass> roomClassList) {
		this.roomClassList = roomClassList;
	}
	public Device getSideCameraDevice() {
		return sideCameraDevice;
	}
	public void setSideCameraDevice(Device sideCameraDevice) {
		this.sideCameraDevice = sideCameraDevice;
	}
	public Device getFrontCameraDevice() {
		return frontCameraDevice;
	}
	public void setFrontCameraDevice(Device frontCameraDevice) {
		this.frontCameraDevice = frontCameraDevice;
	}
	public Device getDevice() {
		return device;
	}
	public void setDevice(Device device) {
		this.device = device;
	}
	public MerchType getMerchType() {
		return merchType;
	}
	public void setMerchType(MerchType merchType) {
		this.merchType = merchType;
	}
	public RoomMerch getRoomMerch() {
		return roomMerch;
	}
	public void setRoomMerch(RoomMerch roomMerch) {
		this.roomMerch = roomMerch;
	}
	public File getRoomIconfile() {
		return roomIconfile;
	}
	public void setRoomIconfile(File roomIconfile) {
		this.roomIconfile = roomIconfile;
	}
	public File getBackgroundMusicfile() {
		return backgroundMusicfile;
	}
	public void setBackgroundMusicfile(File backgroundMusicfile) {
		this.backgroundMusicfile = backgroundMusicfile;
	}
	public File getBackgroundfile() {
		return backgroundfile;
	}
	public void setBackgroundfile(File backgroundfile) {
		this.backgroundfile = backgroundfile;
	}
	public String getRoomIconfileFileName() {
		return roomIconfileFileName;
	}
	public void setRoomIconfileFileName(String roomIconfileFileName) {
		this.roomIconfileFileName = roomIconfileFileName;
	}
	public String getBackgroundMusicfileFileName() {
		return backgroundMusicfileFileName;
	}
	public void setBackgroundMusicfileFileName(String backgroundMusicfileFileName) {
		this.backgroundMusicfileFileName = backgroundMusicfileFileName;
	}
	public String getBackgroundfileFileName() {
		return backgroundfileFileName;
	}
	public void setBackgroundfileFileName(String backgroundfileFileName) {
		this.backgroundfileFileName = backgroundfileFileName;
	}
	public List<Merch> getMerchList() {
		return merchList;
	}
	public void setMerchList(List<Merch> merchList) {
		this.merchList = merchList;
	}
	
	
}
