package com.irandoo.xhep.base.action;


import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.irandoo.xhep.base.model.Dictionary;
import com.irandoo.xhep.base.service.FeedBackService;
import com.irandoo.xhep.sys.service.DictionaryService;




@Controller("feedBackAction")
@Scope("prototype")
public class FeedBackAction extends BaseAction{

	
	private static final long serialVersionUID = -2524104690633582447L;
	private Log logger = LogFactory.getLog(FeedBackAction.class);
    @Autowired
    private FeedBackService feedBackService;
    
    @Autowired
	private DictionaryService dictionaryService;
    
	private List<Dictionary> feeBackStatusList;//设备状态
    /**
	 * 加载数据
	 * 
	 * @return
	 */
	public String getAjaxData() {
		String jsonData = feedBackService.getInfoListStr(getConditionMap());
		return toJsonData(jsonData);
	}
    
	/**
	 * 跳转
	 * 
	 * @return
	 */
	public String toLoadList() {
		feeBackStatusList = dictionaryService.getByDescript("反馈意见处理状态");
		request.setAttribute("title", "反馈意见");
		return SUCCESS;
	}
	/**
	 * 删除
	 * @return
	 */
	public String delete() {
		logger.debug("enter delete");
		boolean result = true;
		String id = request.getParameter("ids");
	    try {
	    	feedBackService.deleteById(Long.valueOf(id));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = false;
		}
	    logger.debug("exit delete");

		return result(result);
	}


	public List<Dictionary> getFeeBackStatusList() {
		return feeBackStatusList;
	}


	public void setFeeBackStatusList(List<Dictionary> feeBackStatusList) {
		this.feeBackStatusList = feeBackStatusList;
	}
	


}
