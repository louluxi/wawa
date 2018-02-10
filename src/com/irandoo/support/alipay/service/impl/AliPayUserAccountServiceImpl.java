package com.irandoo.support.alipay.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irandoo.support.alipay.mapper.AliPayUserAccountMapper;
import com.irandoo.support.alipay.model.AliPayUserAccount;
import com.irandoo.support.alipay.service.AliPayUserAccountService;
import com.irandoo.xhep.base.service.impl.BaseServiceImpl;
@Service("aliPayUserAccountService")
public class AliPayUserAccountServiceImpl extends BaseServiceImpl<AliPayUserAccount> implements AliPayUserAccountService{
	
	@SuppressWarnings("unused")
	@Autowired
	private AliPayUserAccountMapper aliPayUserAccountMapper;
    
    @Resource
    public void setSuperBaseMapper(AliPayUserAccountMapper aliPayUserAccountMapper) {
		super.setBaseMapper(aliPayUserAccountMapper);
		this.aliPayUserAccountMapper = aliPayUserAccountMapper;
	}
}
