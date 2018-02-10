package com.irandoo.xhep.base.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irandoo.xhep.base.mapper.UserAccountMapper;
import com.irandoo.xhep.base.model.UserAccount;
import com.irandoo.xhep.base.service.UserAccountService;

@Service("userAccountService")
public class UserAccountServiceImp extends BaseServiceImpl<UserAccount> implements UserAccountService{
	@Autowired
	private UserAccountMapper userAccountMapper;
	
	@Resource
	public void setSuperBaseMapper(UserAccountMapper userAccountMapper){
	     super.setBaseMapper(userAccountMapper);
	     this.userAccountMapper = userAccountMapper;
	}

	@Override
	public int addBalance(Map<String, Object> map) {
		
		return userAccountMapper.addBalance(map);
	}

	@Override
	public List<UserAccount> getUserList() {
		
		return userAccountMapper.getUserList();
	}

	@Override
	public List<UserAccount> detectionAccount() {
		
		return userAccountMapper.detectionAccount();
	}
	
}
