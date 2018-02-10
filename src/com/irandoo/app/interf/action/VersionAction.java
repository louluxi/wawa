package com.irandoo.app.interf.action;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.irandoo.app.interf.service.VersionJsonService;
import com.irandoo.xhep.base.action.BaseAction;
@Controller("versionAction")
@Scope("prototype")
public class VersionAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9189728821989506945L;
	@Autowired
	private VersionJsonService versionJsonService;
	
	public String  lastVersion(){
          Map<String, Object> map = getInterfMap();
		return returnJson(versionJsonService.getAllList(map).get(0), "0", "");
	}
		
	public String testGame(){
		Map<String,Object> paramMap = getInterfMap();
		Map<String,Object> map = versionJsonService.testGame(paramMap);
		if(null != map.get("errmsg")){
			return returnJson("", "-1", map.get("errmsg")+"");
	   }
	
	    return returnJson(map, "0", "");	
	 }
}
