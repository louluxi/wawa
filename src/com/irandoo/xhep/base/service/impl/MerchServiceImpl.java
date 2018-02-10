package com.irandoo.xhep.base.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irandoo.xhep.base.mapper.MerchMapper;
import com.irandoo.xhep.base.model.Merch;
import com.irandoo.xhep.base.model.MerchType;
import com.irandoo.xhep.base.service.MerchService;
@Service("merchService")
public class MerchServiceImpl extends BaseServiceImpl<Merch> implements MerchService {

	@Autowired
	private MerchMapper merchMapper;
	
	@Resource
	public void setSuperBaseMapper(MerchMapper merchMapper) {
		// TODO Auto-generated method stub
		super.setBaseMapper(merchMapper);
		this.merchMapper = merchMapper;
	}

	@Override
	public List<MerchType> selMerchType() {
		// TODO Auto-generated method stub
		return merchMapper.selMerchType();
	}
}
