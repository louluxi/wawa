package com.irandoo.xhep.base.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irandoo.xhep.base.mapper.UserAddressMapper;
import com.irandoo.xhep.base.model.UserAddress;
import com.irandoo.xhep.base.service.UserAddressService;

@Service("userAddressService")
public class UserAddressServiceImp extends BaseServiceImpl<UserAddress> implements UserAddressService{

	@Autowired
	private UserAddressMapper userAddressMapper;
	
	@Resource
	public void setSuperBaseMapper(UserAddressMapper userAddressMapper){
	     super.setBaseMapper(userAddressMapper);
	     this.userAddressMapper = userAddressMapper;
	}
}
