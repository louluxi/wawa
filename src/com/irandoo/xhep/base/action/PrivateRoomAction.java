package com.irandoo.xhep.base.action;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.irandoo.xhep.base.model.Dictionary;
import com.irandoo.xhep.base.service.PrivateRoomService;
import com.irandoo.xhep.sys.service.DictionaryService;

@Controller("privateRoomAction")
@Scope("prototype")
public class PrivateRoomAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8107585640295775097L;
	private Log logger = LogFactory.getLog(PrivateRoomAction.class);
	@Autowired
	private DictionaryService dictionaryService;
	@Autowired
	private PrivateRoomService privateRoomService;
	private List<Dictionary> privateRoomTypeList;
	private List<Dictionary> privateRoomStrutsList;
	/**
	 * 加载数据
	 * @return
	 */
	public String getAjaxData() {
		String jsonData = privateRoomService.getInfoListStr(getConditionMap());
	    return toJsonData(jsonData);
	}
	/**
	 * 跳转
	 * 
	 * @return
	 */
	public String toLoadList() {
		privateRoomTypeList = dictionaryService.getByDescript("包房类型");
		privateRoomStrutsList = dictionaryService.getByDescript("包房状态");
		request.setAttribute("title", "包房");
		return SUCCESS;
	}
	public List<Dictionary> getPrivateRoomTypeList() {
		return privateRoomTypeList;
	}
	public void setPrivateRoomTypeList(List<Dictionary> privateRoomTypeList) {
		this.privateRoomTypeList = privateRoomTypeList;
	}
	public List<Dictionary> getPrivateRoomStrutsList() {
		return privateRoomStrutsList;
	}
	public void setPrivateRoomStrutsList(List<Dictionary> privateRoomStrutsList) {
		this.privateRoomStrutsList = privateRoomStrutsList;
	}
	
}
