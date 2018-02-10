package com.irandoo.xhep.base.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irandoo.xhep.base.mapper.UserRoleMapper;
import com.irandoo.xhep.base.model.UserRole;
import com.irandoo.xhep.base.service.UserRoleService;

/**
 * @author ager

 * @date:2015-8-12 下午2:16:52
 * @version : 1.0
 *
 */
@Service("userRoleService")
public class UserRoleServiceImpl extends BaseServiceImpl<UserRole> implements UserRoleService {
	
	@Autowired
	private UserRoleMapper userRoleMapper;
	
	@Resource
	public void setSuperBaseMapper(UserRoleMapper userRoleMapper){
	     super.setBaseMapper(userRoleMapper);
	     this.userRoleMapper = userRoleMapper;
	}
	@Override
	public void deleteByUserId(long id){
		userRoleMapper.deleteByUserId(id);
	}
}
