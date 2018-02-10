package com.irandoo.support.alipay.service;

import com.irandoo.support.alipay.model.AliPayRechargeRecord;
import com.irandoo.xhep.base.service.BaseService;

public interface AliPayRechargeRecordService extends BaseService<AliPayRechargeRecord> {

	AliPayRechargeRecord addRechargeRecord (Long ROOM_id,Long USER_id,Long MEAL_id,String recharge_order_id,Long Recharge_user_Id,Long ORDER_MONEY,Integer EXCHANGE_COIN,Long PAY_MONEY,Integer reward_coin); 
}
