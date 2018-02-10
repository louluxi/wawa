package com.irandoo.app.interf.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irandoo.app.interf.json.UserOrderJson;
import com.irandoo.app.interf.mapper.UserOrderJsonMapper;
import com.irandoo.app.interf.service.UserOrderJsonService;
import com.irandoo.xhep.base.service.impl.BaseServiceImpl;

/**
  * <p>Title: </p>
  * <p>Description: </p>
  * <p>Company: irandoo</p> 
  * @author ager
  * @date 2018-1-9下午8:31:51
  */
@Service("userOrderJsonService")
public class UserOrderJsonServiceImpl extends BaseServiceImpl<UserOrderJson> implements UserOrderJsonService {
	
	@SuppressWarnings("unused")
	@Autowired
	private UserOrderJsonMapper userOrderJsonMapper;
	
    @Resource
    public void setSuperBaseMapper(UserOrderJsonMapper userOrderJsonMapper) {
		super.setBaseMapper(userOrderJsonMapper);
		this.userOrderJsonMapper = userOrderJsonMapper;
	}
}
