package com.irandoo.xhep.base.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.irandoo.xhep.base.model.Meal;
import com.irandoo.xhep.base.model.UserAccount;
import com.irandoo.xhep.base.service.MealService;
import com.irandoo.xhep.base.service.UserAccountService;

/**
 *  用户账号控制类
 * @author sun
 *  2018年1月11日19:40:35
 */
@Controller("userAccountAction")
@Scope("prototype")
public class UserAccountAction extends BaseAction{

	
	private static final long serialVersionUID = -1342801866160866958L;
	private Log logger = LogFactory.getLog(UserAccountAction.class);
	@Autowired
    UserAccountService userAccountService;
	
	UserAccount userAccount;
	
	
	
	
	/**
	 * 加载数据
	 * @return
	 */
	public String getAjaxData() {
		String jsonData = userAccountService.getInfoListStr(getConditionMap());
	    return toJsonData(jsonData);
	}
	
	
	
	
	
	
	
	
	
	
	
	

	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}
	
	
	
	
}
