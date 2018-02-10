package com.irandoo.app.interf.action;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.irandoo.xhep.base.action.BaseAction;
import com.irandoo.xhep.base.model.Dictionary;
import com.irandoo.xhep.sys.service.DictionaryService;

/**
 * <p>Title: 包房接口</p>
 * <p>Description: </p>
 * <p>Company: irandoo</p> 
 * @author sun
 * @date 2018年1月16日10:57:11
 */
@Controller("privateRoomMoneyAction")
@Scope("prototype")
public class PrivateRoomMoneyAction extends BaseAction{

	private static final long serialVersionUID = 1L;
	@Autowired
	private DictionaryService dictionaryService;
	private List<Dictionary> moneyDescript;
	public String privateRoomMoneys(){
	    moneyDescript =dictionaryService.getByDescript("包房费用"); 
		return returnJson(moneyDescript.get(0).getDictName(), "0", "");
	}
	

	public DictionaryService getDictionaryService() {
		return dictionaryService;
	}
	public void setDictionaryService(DictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}
	
}
