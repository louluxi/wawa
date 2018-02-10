package com.irandoo.support.alipay.mapper;



import java.util.Map;

import com.irandoo.support.alipay.model.AliPayRechargeOrder;
import com.irandoo.xhep.base.mapper.BaseMapper;

public interface AliPayRechargeOrderMapper extends BaseMapper {

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
