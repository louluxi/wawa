package com.irandoo.app.interf.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.irandoo.app.interf.service.RechargeRecordJsonService;
import com.irandoo.xhep.base.action.BaseAction;

/**
  * <p>Title: 账户明细接口</p>
  * <p>Description: </p>
  * <p>Company: irandoo</p> 
  * @author ager
  * @date 2018-1-8下午4:43:55
  */
@Controller("rechargeRecordJsonAction")
@Scope("prototype")
public class RechargeRecordJsonAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	@Autowired
    private RechargeRecordJsonService rechargeRecordJsonService;
	public String getRechargeRecord() {
		return returnJson(rechargeRecordJsonService.getAllList(getInterfMap()), "0", "");
	}
}
