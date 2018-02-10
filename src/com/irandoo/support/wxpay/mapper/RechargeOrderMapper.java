package com.irandoo.support.wxpay.mapper;

import com.irandoo.support.wxpay.model.RechargeOrder;
import com.irandoo.xhep.base.mapper.BaseMapper;

public interface RechargeOrderMapper extends BaseMapper{
	
	/**
	 * 根据订单号查询详细信息
	 * @param orderId
	 * @return
	 */
	RechargeOrder getInfoByOrderId(String orderId);
	
	/**
	 * 修改订单状态
	 * @param rechargeOrder
	 * @return
	 */
    int updateState(RechargeOrder rechargeOrder); 

}
