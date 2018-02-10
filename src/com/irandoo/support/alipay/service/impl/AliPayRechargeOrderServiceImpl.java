package com.irandoo.support.alipay.service.impl;


import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irandoo.support.alipay.AliPayStringUtil;
import com.irandoo.support.alipay.mapper.AliPayRechargeOrderMapper;
import com.irandoo.support.alipay.model.AliPayRechargeOrder;
import com.irandoo.support.alipay.service.AliPayRechargeOrderService;
import com.irandoo.xhep.base.service.impl.BaseServiceImpl;
@Service("aliPayRechargeOrderService")
public class AliPayRechargeOrderServiceImpl extends BaseServiceImpl<AliPayRechargeOrder>
		implements AliPayRechargeOrderService {
	
	@SuppressWarnings("unused")
	@Autowired
	private  AliPayRechargeOrderMapper aliPayRechargeOrderMapper;
	
	@Resource
    public void setSuperBaseMapper(AliPayRechargeOrderMapper aliPayRechargeOrderMapper) {
		super.setBaseMapper(aliPayRechargeOrderMapper);
		this.aliPayRechargeOrderMapper = aliPayRechargeOrderMapper;
	}
   /**
    * 订单号,房间id,包房id,充值人id,被充值人id,套餐id,支付金额,支付方式
    */
	public AliPayRechargeOrder addRecharageOrder(String outtradeno, String room_id, 
			String private_room_id,String user_id,
			String receive_user_id,Long meal_id,Long price,
			String channelName) {
		// TODO Auto-generated method stub
		AliPayRechargeOrder aliPayRechargeOrder = new AliPayRechargeOrder();
        if (AliPayStringUtil.isEmpty(outtradeno)) {
        	aliPayRechargeOrder.setOrder_id(outtradeno);
        }
        if (AliPayStringUtil.isEmpty(room_id)) {
        	aliPayRechargeOrder.setRoom_id(Long.valueOf(room_id));
        }
        if (AliPayStringUtil.isEmpty(private_room_id)) {
        	aliPayRechargeOrder.setPrivate_room_id(Long.valueOf(private_room_id));
        }
        if (AliPayStringUtil.isEmpty(user_id)) {
        	aliPayRechargeOrder.setBuy_user_id(Long.valueOf(user_id));
        }
        if (AliPayStringUtil.isEmpty(receive_user_id)) {
        	aliPayRechargeOrder.setReceive_user_id(Long.valueOf(receive_user_id));
        }
        if (AliPayStringUtil.isEmpty(String.valueOf(meal_id))) {
        	aliPayRechargeOrder.setMeal_id(meal_id);
        }
        if (AliPayStringUtil.isEmpty(String.valueOf(price))) {
        	aliPayRechargeOrder.setPay_money(price);
        }
        if (AliPayStringUtil.isEmpty(channelName)) {
        	aliPayRechargeOrder.setPay_type(channelName);
        }
		return aliPayRechargeOrder;
	}

	@Override
	public AliPayRechargeOrder getAliPayRechargeOrderById(String order_id) {
		// TODO Auto-generated method stub
		return aliPayRechargeOrderMapper.getAliPayRechargeOrderById(order_id);			
	}
	@Override
	public Integer getRechargeOrderCount(Map map) {
		// TODO Auto-generated method stub
		return aliPayRechargeOrderMapper.getRechargeOrderCount(map);
	}
	
}
