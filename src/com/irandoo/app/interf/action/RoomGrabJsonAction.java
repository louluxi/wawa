package com.irandoo.app.interf.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.irandoo.app.interf.service.RoomGrabJsonService;
import com.irandoo.xhep.base.action.BaseAction;

/**
  * <p>Title: 抓中记录接口</p>
  * <p>Description: </p>
  * <p>Company: irandoo</p> 
  * @author ager
  * @date 2018-1-8下午4:43:55
  */
@Controller("roomGrabJsonAction")
@Scope("prototype")
public class RoomGrabJsonAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	@Autowired
    private RoomGrabJsonService roomGrabJsonService;
    
	public String getRoomGrab() {
		return returnJson(roomGrabJsonService.getAllList(getInterfMap()), "0", "");
	}
    
}
