package com.irandoo.app.interf.action;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.irandoo.xhep.base.action.BaseAction;
import com.irandoo.xhep.base.service.LoginService;

@Controller("appLoginAction")
@Scope("prototype")
public class AppLoginAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6392876408246785656L;
	@Autowired
    private LoginService loginService;
    
	public String appLoginOut(){
		String result = "0";
		String errmsg = "";
		try {
			    String userId = (String) request.getAttribute("userId");
			    String id =  loginService.getIdByUserId(userId);
			    Map<String, Object> map = new HashMap<String, Object>();
			    map.put("id", id);
			    map.put("logout_time", new Date());
				loginService.updateTime(map);
		} catch (Exception e) {
			result = "-1";
			result = "退出异常";
			e.printStackTrace();
		}
		return returnJson("", result, errmsg);
	}
	
}
