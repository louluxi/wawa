package com.irandoo.xhep.sys.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.irandoo.xhep.base.model.Role;
import com.irandoo.xhep.base.service.impl.BaseServiceImpl;
import com.irandoo.xhep.sys.mapper.RoleMapper;
import com.irandoo.xhep.sys.service.RoleService;

@Service("roleService")
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {
	@SuppressWarnings("unused")
	@Autowired
	
	private RoleMapper roleMapper;
	@Resource
	public void setSuperBaseMapper(RoleMapper roleMapper) {
		 super.setBaseMapper(roleMapper);
		 this.roleMapper = roleMapper;
	}
	

	@Override
	@Transactional
    public void deleteOne(long id) {
    	Role role = roleMapper.getInfoById(id);
        roleMapper.delete(id);
    	roleMapper.update(role);
    }
}
