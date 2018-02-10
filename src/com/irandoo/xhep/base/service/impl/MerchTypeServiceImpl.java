package com.irandoo.xhep.base.service.impl;


import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irandoo.xhep.base.mapper.MerchTypeMapper;
import com.irandoo.xhep.base.model.MerchType;
import com.irandoo.xhep.base.service.MerchTypeService;
@Service
public class MerchTypeServiceImpl extends BaseServiceImpl<MerchType> implements MerchTypeService {
	
	@Autowired
	private MerchTypeMapper merchTypeMapper;
    
	@Resource
	public void setSuperBaseMapper(MerchTypeMapper merchTypeMapper) {
		super.setBaseMapper(merchTypeMapper);
		this.merchTypeMapper = merchTypeMapper;
	}

	

}
