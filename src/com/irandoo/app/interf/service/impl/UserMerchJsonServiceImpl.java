package com.irandoo.app.interf.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irandoo.app.interf.json.UserMerchJson;
import com.irandoo.app.interf.mapper.UserMerchJsonMapper;
import com.irandoo.app.interf.service.UserMerchJsonService;
import com.irandoo.xhep.base.service.impl.BaseServiceImpl;

/**
  * <p>Title: </p>
  * <p>Description: </p>
  * <p>Company: irandoo</p> 
  * @author ager
  * @date 2018-1-9下午9:19:10
  */
@Service("userMerchJsonService")
public class UserMerchJsonServiceImpl extends BaseServiceImpl<UserMerchJson> implements UserMerchJsonService {
	
    @SuppressWarnings("unused")
	@Autowired
	private UserMerchJsonMapper userMerchJsonMapper;
    
    @Resource
    public void setSuperBaseMapper(UserMerchJsonMapper userMerchJsonMapper) {
		super.setBaseMapper(userMerchJsonMapper);
		this.userMerchJsonMapper = userMerchJsonMapper;
	}
}
