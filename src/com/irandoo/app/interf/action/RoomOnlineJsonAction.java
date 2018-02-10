package com.irandoo.app.interf.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.irandoo.app.interf.service.RoomOnlineJsonService;
import com.irandoo.xhep.base.action.BaseAction;

/**
  * <p>Title: 房间在线接口</p>
  * <p>Description: </p>
  * <p>Company: irandoo</p> 
  * @author ager
  * @date 2018-1-8下午4:43:55
  */
@Controller("roomOnlineJsonAction")
@Scope("prototype")
public class RoomOnlineJsonAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	@Autowired
    private RoomOnlineJsonService roomOnlineJsonService;
	public String getRoomOnline() {
		return returnJson(roomOnlineJsonService.getAllList(getInterfMap()), "0", "");
	}
    
}
