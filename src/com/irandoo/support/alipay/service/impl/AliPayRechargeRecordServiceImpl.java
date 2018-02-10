package com.irandoo.support.alipay.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irandoo.support.alipay.AliPayStringUtil;
import com.irandoo.support.alipay.mapper.AliPayRechargeRecordMapper;
import com.irandoo.support.alipay.model.AliPayRechargeRecord;
import com.irandoo.support.alipay.service.AliPayRechargeRecordService;
import com.irandoo.xhep.base.service.impl.BaseServiceImpl;
@Service("aliPayRechargeRecordService")
public class AliPayRechargeRecordServiceImpl extends BaseServiceImpl<AliPayRechargeRecord> implements AliPayRechargeRecordService{

	@Autowired
	private AliPayRechargeRecordMapper aliPayRechargeRecordMapper;
    
    @Resource
    public void setSuperBaseMapper(AliPayRechargeRecordMapper aliPayRechargeRecordMapper) {
		super.setBaseMapper(aliPayRechargeRecordMapper);
		this.aliPayRechargeRecordMapper = aliPayRechargeRecordMapper;
	}

	@Override
	public AliPayRechargeRecord addRechargeRecord(Long ROOM_id, Long USER_id, Long MEAL_id, String recharge_order_id,
			Long Recharge_user_Id, Long ORDER_MONEY, Integer EXCHANGE_COIN, Long PAY_MONEY, Integer reward_coin) {
		// TODO Auto-generated method stub
		AliPayRechargeRecord aliPayRechargeRecord =new AliPayRechargeRecord();
		if (AliPayStringUtil.isEmpty(String.valueOf(ROOM_id))) {
        	aliPayRechargeRecord.setRoom_id(ROOM_id);
        }
		if (AliPayStringUtil.isEmpty(String.valueOf(USER_id))) {
        	aliPayRechargeRecord.setUser_id(USER_id);
        }
		if (AliPayStringUtil.isEmpty(String.valueOf(MEAL_id))) {
        	aliPayRechargeRecord.setMeal_id(MEAL_id);
        }
		if (AliPayStringUtil.isEmpty(recharge_order_id)) {
        	aliPayRechargeRecord.setRecharge_order_id(recharge_order_id);
        }
		if (AliPayStringUtil.isEmpty(String.valueOf(Recharge_user_Id))) {
        	aliPayRechargeRecord.setRecharge_user_id(Recharge_user_Id);
        }
		if (AliPayStringUtil.isEmpty(String.valueOf(ORDER_MONEY))) {
        	aliPayRechargeRecord.setOrder_money(ORDER_MONEY);
        }
		if (AliPayStringUtil.isEmpty(String.valueOf(EXCHANGE_COIN))) {
        	aliPayRechargeRecord.setExchange_coin(EXCHANGE_COIN);
        }
		if (AliPayStringUtil.isEmpty(String.valueOf(PAY_MONEY))) {
        	aliPayRechargeRecord.setPay_money(PAY_MONEY);
        }
		if (AliPayStringUtil.isEmpty(String.valueOf(reward_coin))) {
        	aliPayRechargeRecord.setReward_coin(Integer.valueOf(String.valueOf(reward_coin)));
        }
		return aliPayRechargeRecord;
	}

	
}
