package com.irandoo.xhep.base.action;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.irandoo.xhep.base.model.RoomClass;
import com.irandoo.xhep.base.service.RoomMerchService;
import com.irandoo.xhep.base.service.RoomService;

@Controller("roomMerchAction")
@Scope("prototype")
public class RoomMerchAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7832198139496970265L;
	private Log logger = LogFactory.getLog(RoomMerchAction.class); 
	@Autowired
	private RoomMerchService roomMerchService;
	@Autowired
	private RoomService roomService;
	
	private List<RoomClass> roomClassList;//房间类别
	/**
	 * 加载数据
	 * @return
	 */
	public String getAjaxData() {
		String jsonData = roomMerchService.getInfoListStr(getConditionMap());
	    return toJsonData(jsonData);
	}
	/**
	 * 跳转及数据字典
	 * 
	 * @return
	 */
	public String toLoadList() {
		roomClassList = roomService.getRoomClassName();
		request.setAttribute("title", "房间管理");
		return SUCCESS;
	}
	public List<RoomClass> getRoomClassList() {
		return roomClassList;
	}
	public void setRoomClassList(List<RoomClass> roomClassList) {
		this.roomClassList = roomClassList;
	}
	
	
}
