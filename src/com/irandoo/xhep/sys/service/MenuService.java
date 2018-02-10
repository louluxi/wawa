package com.irandoo.xhep.sys.service;

import java.util.List;
import java.util.Map;

import com.irandoo.xhep.base.model.Menu;
import com.irandoo.xhep.base.model.ZNodesEntity;
import com.irandoo.xhep.base.service.BaseService;

public interface MenuService extends BaseService<Menu>{

	void deleteByOne(long id);
	
	List<ZNodesEntity> getZNodesData(Map<String,Object> map);
}
