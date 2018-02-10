package com.irandoo.app.interf.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.irandoo.app.interf.service.MasterJsonService;
import com.irandoo.xhep.base.action.BaseAction;

/**
  * <p>Title: 娃娃达人接口</p>
  * <p>Description: </p>
  * <p>Company: irandoo</p> 
  * @author ager
  * @date 2018-1-8下午4:43:55
  */
@Controller("masterJsonAction")
@Scope("prototype")
public class MasterJsonAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	@Autowired
    private MasterJsonService masterJsonService;
    
	public String getMaster() {
		return returnJson(masterJsonService.getAllList(getInterfMap()), "0", "");
	}
    
}
