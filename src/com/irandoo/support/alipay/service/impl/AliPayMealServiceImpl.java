package com.irandoo.support.alipay.service.impl;



import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irandoo.support.alipay.mapper.AliPayMealMapper;
import com.irandoo.support.alipay.model.AliPayMeal;
import com.irandoo.support.alipay.service.AlipayMealService;
import com.irandoo.xhep.base.service.impl.BaseServiceImpl;
@Service("alipayMealService")
public class AliPayMealServiceImpl extends BaseServiceImpl<AliPayMeal> implements AlipayMealService {

	
	@Autowired
	private AliPayMealMapper AliPayMealMapper;
    
    @Resource
    public void setSuperBaseMapper(AliPayMealMapper AliPayMealMapper) {
		super.setBaseMapper(AliPayMealMapper);
		this.AliPayMealMapper = AliPayMealMapper;
	}
	
}
