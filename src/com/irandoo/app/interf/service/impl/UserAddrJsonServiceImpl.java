package com.irandoo.app.interf.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irandoo.app.interf.json.UserAddrJson;
import com.irandoo.app.interf.mapper.UserAddrJsonMapper;
import com.irandoo.app.interf.service.UserAddrJsonService;
import com.irandoo.xhep.base.service.impl.BaseServiceImpl;

/**
  * <p>Title: </p>
  * <p>Description: </p>
  * <p>Company: irandoo</p> 
  * @author ager
  * @date 2018-1-9下午8:31:51
  */
@Service("userAddrJsonService")
public class UserAddrJsonServiceImpl extends BaseServiceImpl<UserAddrJson> implements UserAddrJsonService {
	
	@SuppressWarnings("unused")
	@Autowired
	private UserAddrJsonMapper userAddrJsonMapper;
    
    @Resource
    public void setSuperBaseMapper(UserAddrJsonMapper userAddrJsonMapper) {
		super.setBaseMapper(userAddrJsonMapper);
		this.userAddrJsonMapper = userAddrJsonMapper;
	}
}
