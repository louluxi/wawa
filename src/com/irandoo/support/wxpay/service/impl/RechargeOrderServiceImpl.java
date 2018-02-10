package com.irandoo.support.wxpay.service.impl;


import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irandoo.support.wxpay.mapper.RechargeOrderMapper;
import com.irandoo.support.wxpay.model.RechargeOrder;
import com.irandoo.support.wxpay.service.RechargeOrderService;
import com.irandoo.xhep.base.service.impl.BaseServiceImpl;

@Service("rechargeOrderService")
public class RechargeOrderServiceImpl extends BaseServiceImpl<RechargeOrder> implements RechargeOrderService{

	@Autowired
	private RechargeOrderMapper rechargeOrderMapper;
	

	@Resource
	public void setSuperBaseMapper(RechargeOrderMapper rechargeOrderMapper) {
		super.setBaseMapper(rechargeOrderMapper);
		this.rechargeOrderMapper = rechargeOrderMapper;
	}


	@Override
	public RechargeOrder getInfoByOrderId(String orderId) {
		
		return rechargeOrderMapper.getInfoByOrderId(orderId);
	}


	@Override
	public int updateState(RechargeOrder rechargeOrder) {
		
		return rechargeOrderMapper.updateState(rechargeOrder);
	}
}
