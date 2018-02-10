package com.irandoo.xhep.base.service.impl;


import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irandoo.xhep.base.mapper.LoginMapper;
import com.irandoo.xhep.base.model.Login;
import com.irandoo.xhep.base.service.LoginService;
@Service("loginService")
public class LoginServiceImpl extends BaseServiceImpl<Login> implements LoginService {


	@Autowired
	private LoginMapper loginMapper;
	
	@Resource
	public void setSuperBaseMapper(LoginMapper loginMapper) {
		super.setBaseMapper(loginMapper);
		this.loginMapper = loginMapper;
	}

	@Override
	public void updateTime(Map<String, Object> map) {
		loginMapper.updateTime(map);	
	}

	@Override
	public String getIdByUserId(String userId) {
		
		return loginMapper.getIdByUserId(userId);
	}
	

}
