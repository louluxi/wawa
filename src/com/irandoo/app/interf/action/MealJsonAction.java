package com.irandoo.app.interf.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.irandoo.app.interf.service.MealJsonService;
import com.irandoo.xhep.base.action.BaseAction;
/**
  * <p>Title: 套餐接口</p>
  * <p>Description: </p>
  * <p>Company: irandoo</p> 
  * @author ager
  * @date 2018-1-8下午4:43:55
  */
@Controller("mealJsonAction")
@Scope("prototype")
public class MealJsonAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	@Autowired
    private MealJsonService mealJsonService;
    
	public String getMeal() {
		return returnJson(mealJsonService.getAllList(getInterfMap()), "0", "");
	}
    
}
