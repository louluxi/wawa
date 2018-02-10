package com.irandoo.app.interf.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.irandoo.app.interf.json.UserAddrJson;
import com.irandoo.app.interf.service.UserAddrJsonService;
import com.irandoo.xhep.anth.filter.JwtConstants;
import com.irandoo.xhep.base.action.BaseAction;

/**
  * <p>Title: 用户地址相关接口</p>
  * <p>Description: </p>
  * <p>Company: irandoo</p> 
  * @author ager
  * @date 2018-1-8下午4:43:55
  */
@Controller("userAddrJsonAction")
@Scope("prototype")
public class UserAddrJsonAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	@Autowired
    private UserAddrJsonService userAddrJsonService;
    
	public String getUserAddr() {
        return returnJson(userAddrJsonService.getAllList(getInterfMap()), "0", "");
	}
    
	public String createUserAddr() {
		String o = request.getParameter("object");
		UserAddrJson userAddrJson = JSON.parseObject(o, UserAddrJson.class);
		String userId = request.getAttribute(JwtConstants.REQUEST_KEY_USERNAME)+"";
		userAddrJson.setUserId(userId);
		String result = "0";
		String errmsg = "";
        try {
        	userAddrJsonService.insert(userAddrJson);
        }
        catch (Exception e) {
        	result = "-1";
        	errmsg = e.getLocalizedMessage();
        }
		return returnJson("", result, errmsg);
	}
	
	public String updateUserAddr() {
		String o = request.getParameter("object");
		UserAddrJson userAddrJson = JSON.parseObject(o, UserAddrJson.class);
		String userId = request.getAttribute(JwtConstants.REQUEST_KEY_USERNAME)+"";;
		userAddrJson.setUserId(userId);
		String result = "0";
		String errmsg = "";
		try {
			userAddrJsonService.update(userAddrJson);
		}
		catch (Exception e) {
			result = "-1";
			errmsg = e.getLocalizedMessage();
		}
		return returnJson("", result, errmsg);
	}
	
	public String deleteUserAddr() {
		String o = request.getParameter("object");
		UserAddrJson userAddrJson = JSON.parseObject(o, UserAddrJson.class);
		String userId = request.getAttribute(JwtConstants.REQUEST_KEY_USERNAME)+"";
		userAddrJson.setUserId(userId);
		String result = "0";
		String errmsg = "";
		try {
			if(null != userAddrJson.getId()&&!"".equals(userAddrJson.getId())){
				userAddrJsonService.deleteById(Long.valueOf(userAddrJson.getId()));
			}else{
				result = "-1";
				errmsg = "用户地址id为空";
			}
		}
		catch (Exception e) {
			result = "-1";
			errmsg = e.getLocalizedMessage();
		}
		return returnJson("", result, errmsg);
	}
}
