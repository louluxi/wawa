package com.irandoo.xhep.base.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irandoo.xhep.base.mapper.RoleResourceMapper;
import com.irandoo.xhep.base.model.RoleResource;
import com.irandoo.xhep.base.service.RoleResourceService;

/**
 * @author ager

 * @version : 1.0
 *
 */
@Service("roleResourceService")
public class RoleResourceServiceImpl extends BaseServiceImpl<RoleResource> implements RoleResourceService {
	
	@Autowired
	private RoleResourceMapper roleResourceMapper;
	
	@Resource
	public void setSuperBaseMapper(RoleResourceMapper roleResourceMapper){
	     super.setBaseMapper(roleResourceMapper);
	     this.roleResourceMapper = roleResourceMapper;
	}
	@Override
	public void deleteByRoleId(long id){
		roleResourceMapper.deleteByRoleId(id);
	}
}
