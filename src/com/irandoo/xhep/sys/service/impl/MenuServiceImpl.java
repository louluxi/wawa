package com.irandoo.xhep.sys.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.irandoo.xhep.base.model.Menu;
import com.irandoo.xhep.base.model.ZNodesEntity;
import com.irandoo.xhep.base.service.impl.BaseServiceImpl;
import com.irandoo.xhep.sys.mapper.MenuMapper;
import com.irandoo.xhep.sys.service.MenuService;

@Service("menuService")
public class MenuServiceImpl extends BaseServiceImpl<Menu> implements MenuService {
	@Autowired
	private MenuMapper menuMapper;
	@Resource
	public void setSuperBaseMapper(MenuMapper menuMapper) {
		 super.setBaseMapper(menuMapper);
		 this.menuMapper = menuMapper;
	}
	
	@Override
	@Transactional
	public void deleteByOne(long id) {
		menuMapper.delete(id);
	}
	
	@Override
	public List<ZNodesEntity> getZNodesData(Map<String,Object> map){
		return menuMapper.getZNodesData(map);
	}
}
