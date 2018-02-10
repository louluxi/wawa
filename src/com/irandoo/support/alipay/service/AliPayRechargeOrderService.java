package com.irandoo.support.alipay.service;

import java.util.Map;

import com.irandoo.support.alipay.model.AliPayRechargeOrder;
import com.irandoo.xhep.base.service.BaseService;

public interface AliPayRechargeOrderService extends BaseService<AliPayRechargeOrder> {
 
	/**
	 * 添加预支付充值订单
	 * @param aliPayRechargeOrder
	 * @return
	 */
	AliPayRechargeOrder addRecharageOrder (String outtradeno,String room_id,String private_room_id,String user_id,String receive_user_id,Long meal_id,Long price,String channelName);
	/**
	 * 查询充值人和被充值人
	 */
	AliPayRechargeOrder  getAliPayRechargeOrderById (String order_id);
	
	/**
	 * 查询是否状态是待处理
	 * @param map
	 * @return
	 */
	Integer getRechargeOrderCount (Map map);
}
