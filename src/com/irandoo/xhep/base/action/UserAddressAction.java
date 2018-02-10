package com.irandoo.xhep.base.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.irandoo.xhep.base.model.UserAddress;
import com.irandoo.xhep.base.service.UserAddressService;
@Controller("userAddressAction")
@Scope("prototype")
public class UserAddressAction extends BaseAction{


	private static final long serialVersionUID = -1342801866160866958L;
	private Log logger = LogFactory.getLog(UserAddressAction.class);
	@Autowired
	private UserAddressService userAddressService;
	
	private UserAddress userAddress;
	
	
	/**
	 * 加载数据
	 * @return
	 */
	public String getAjaxData() {
		String jsonData = userAddressService.getInfoListStr(getConditionMap());
	    return toJsonData(jsonData);
	}
	
	
	
	
	
	
	
	

	public UserAddress getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(UserAddress userAddress) {
		this.userAddress = userAddress;
	}
	
	
}
