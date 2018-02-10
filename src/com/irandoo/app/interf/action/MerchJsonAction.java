package com.irandoo.app.interf.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.irandoo.app.interf.service.MerchJsonService;
import com.irandoo.xhep.base.action.BaseAction;

/**
  * <p>Title: 商品接口</p>
  * <p>Description: </p>
  * <p>Company: irandoo</p> 
  * @author ager
  * @date 2018-1-8下午4:43:55
  */
@Controller("merchJsonAction")
@Scope("prototype")
public class MerchJsonAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	@Autowired
    private MerchJsonService merchJsonService;
    
	public String getMerchDetail() {
		return returnJson(merchJsonService.getAllList(getInterfMap()), "0", "");
	}
    
}
