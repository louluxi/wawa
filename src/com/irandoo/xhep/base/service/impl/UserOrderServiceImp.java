package com.irandoo.xhep.base.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.irandoo.xhep.base.mapper.UserOrderMapper;
import com.irandoo.xhep.base.model.UserOrder;
import com.irandoo.xhep.base.service.UserOrderService;
import com.opensymphony.xwork2.interceptor.annotations.Allowed;

@Service("userOrderService")
public class UserOrderServiceImp extends BaseServiceImpl<UserOrder> implements UserOrderService{
    @Allowed
	private UserOrderMapper userOrderMapper;
       
    @Resource
	public void setSuperBaseMapper(UserOrderMapper userOrderMapper){
	     super.setBaseMapper(userOrderMapper);
	     this.userOrderMapper = userOrderMapper;
	}
	
}
