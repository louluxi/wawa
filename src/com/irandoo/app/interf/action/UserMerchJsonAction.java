package com.irandoo.app.interf.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.irandoo.app.interf.service.UserMerchJsonService;
import com.irandoo.xhep.base.action.BaseAction;

/**
  * <p>Title: 我的娃娃接口</p>
  * <p>Description: </p>
  * <p>Company: irandoo</p> 
  * @author ager
  * @date 2018-1-8下午4:43:55
  */
@Controller("userMerchJsonAction")
@Scope("prototype")
public class UserMerchJsonAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	@Autowired
    private UserMerchJsonService userMerchJsonService;
    
	public String getUserMerch() {
		return returnJson(userMerchJsonService.getAllList(getInterfMap()), "0", "");
	}
    
}
