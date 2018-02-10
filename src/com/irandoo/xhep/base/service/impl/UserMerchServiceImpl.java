package com.irandoo.xhep.base.service.impl;



import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irandoo.xhep.base.mapper.UserMerchMapper;
import com.irandoo.xhep.base.model.UserMerch;
import com.irandoo.xhep.base.service.UserMerchService;
@Service("userMerchService")
public class UserMerchServiceImpl extends BaseServiceImpl<UserMerch> implements UserMerchService {

	@Autowired
	private UserMerchMapper userMerchMapper;
	
	
	@Resource
	public void setSuperBaseMapper(UserMerchMapper userMerchMapper){
	     super.setBaseMapper(userMerchMapper);
	     this.userMerchMapper = userMerchMapper;
	}

}
