package com.irandoo.app.interf.service;

import java.util.Map;

import com.irandoo.app.interf.json.VersionJson;
import com.irandoo.xhep.base.service.BaseService;

public interface VersionJsonService extends BaseService<VersionJson>{
   
	public Map<String, Object> testGame(Map<String, Object> map);
}
