package com.irandoo.app.interf.action;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.irandoo.app.interf.service.CarouselJsonService;
import com.irandoo.xhep.base.action.BaseAction;

/**
  * <p>Title: 轮播图片接口</p>
  * <p>Description: </p>
  * <p>Company: irandoo</p> 
  * @author ager
  * @date 2018-1-8上午11:17:50
  */
@Controller("carouselJsonAction")
@Scope("prototype")
public class CarouselJsonAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	@Autowired
    private CarouselJsonService carouselJsonService;
    
	public String getImgList() {
		return returnJson(carouselJsonService.getAllList(new HashMap<String,Object>()), "0", "");
	}
    
}
