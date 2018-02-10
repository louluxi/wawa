package com.irandoo.xhep.base.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.irandoo.xhep.base.service.UserMerchService;

@Controller("userMerchAction")
@Scope("prototype")
public class UserMerchAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2415617894577280889L;

	private Log logger = LogFactory.getLog(UserMerchAction.class);
	
	@Autowired
	private UserMerchService userMerchService;
	
	 /**
		 * 加载数据
		 * 
		 * @return
		 */
		public String getAjaxData() {
			String jsonData = userMerchService.getInfoListStr(getConditionMap());
			return toJsonData(jsonData);
		}
	
}
