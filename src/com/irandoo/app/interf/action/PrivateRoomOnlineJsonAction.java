package com.irandoo.app.interf.action;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.irandoo.app.interf.json.PrivateRoomOnlineJson;
import com.irandoo.app.interf.service.PrivateRoomJsonService;
import com.irandoo.app.interf.service.PrivateRoomOnlineJsonService;
import com.irandoo.xhep.base.action.BaseAction;
import com.irandoo.xhep.base.model.User;
import com.irandoo.xhep.base.service.UserService;


/**
 * <p>Title: 包房接口</p>
 * <p>Description: </p>
 * <p>Company: irandoo</p> 
 * @author sun
 * @date 2018年1月13日15:13:32
 */
@Controller("privateRoomOnlineJsonAction")
@Scope("prototype")
public class PrivateRoomOnlineJsonAction extends BaseAction{
	
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
    private PrivateRoomOnlineJsonService privateRoomOnlineJsonService;
	@Autowired 
	private PrivateRoomJsonService privateRoomJsonService;
	@Autowired
	private UserService userService;
	
	
	/**
	 * @description:获取包房列表在线人员
	 * @return
	 */
	
	public String getPrivateOnlinePerson () {
		Map<String,Object> paramMap = getInterfMap();
		return returnJson(privateRoomOnlineJsonService.getAllList(paramMap),"0","");
	}
	
	/**
	 * @description:包房人员审批
	 * @return
	 */
	
	public String userCheck(){
		String o = request.getParameter("object");
		PrivateRoomOnlineJson privateRoomOnlineJson = JSON.parseObject(o, PrivateRoomOnlineJson.class);
		String result = "0";
		String errmsg = "";
		try {
		privateRoomOnlineJsonService.update(privateRoomOnlineJson);
		}
		catch (Exception e) {
			result = "-1";
			errmsg = e.getLocalizedMessage();
		}
		return returnJson("", result, errmsg);
	}
	
	/**
	 * @description:包房人员踢出
	 * @return
	 */
	public String kickedUser(){
		String o = request.getParameter("object");
		PrivateRoomOnlineJson privateRoomOnlineJson = JSON.parseObject(o, PrivateRoomOnlineJson.class);
		String result = "0";
		String errmsg = "";
		
		try {
			if(null != privateRoomOnlineJson.getId()&&!"".equals(privateRoomOnlineJson.getId())&&null != privateRoomOnlineJson.getUserId()&&!"".equals(privateRoomOnlineJson.getUserId())){
				
				privateRoomOnlineJsonService.deletePerson(privateRoomOnlineJson);
			}
		}
		catch (Exception e) {
			result = "-1";
			errmsg = e.getLocalizedMessage();
		}
		return returnJson("", result, errmsg);
	}
	
	
	/**
	 * @description:申请加入包房
	 * @return
	 * @author sun
	 */
	public String applyJoin(){
		
		String o = request.getParameter("object");
		PrivateRoomOnlineJson privateRoomOnlineJson = JSON.parseObject(o, PrivateRoomOnlineJson.class);
		String result = "0";
		String errmsg = "";
		//获取token中解出来的userId
		String userId = (String) request.getAttribute("userId");
		privateRoomOnlineJson.setUserId(userId);
        try {
        //根据userId获取用户信息	
        User user =	userService.getInfoById(Long.parseLong(userId));
        privateRoomOnlineJson.setUserIcon(user.getUser_icon());
        privateRoomOnlineJson.setUserName(user.getNick_name());
        //获取房间id
        String roomId = privateRoomJsonService.getRoomIdById(privateRoomOnlineJson.getId());
        privateRoomOnlineJson.setRoomId(roomId);
        //添加为包房的在线人员(默认为待审批状态)
        privateRoomOnlineJsonService.insert(privateRoomOnlineJson);
        }
        catch (Exception e) {
        	result = "-1";
        	errmsg = e.getLocalizedMessage();
        	e.printStackTrace();
        }
		return returnJson("", result, errmsg);
	}
	
	
	

}
