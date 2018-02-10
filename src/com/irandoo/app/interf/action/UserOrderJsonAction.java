package com.irandoo.app.interf.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.irandoo.app.interf.json.UserMerchJson;
import com.irandoo.app.interf.json.UserOrderJson;
import com.irandoo.app.interf.mapper.UserMerchJsonMapper;
import com.irandoo.app.interf.service.UserOrderJsonService;
import com.irandoo.support.wxpay.util.OrderUtil;
import com.irandoo.xhep.anth.filter.JwtConstants;
import com.irandoo.xhep.base.action.BaseAction;

/**
  * <p>Title: 用户订单相关接口</p>
  * <p>Description: </p>
  * <p>Company: irandoo</p> 
  * @author ager
  * @date 2018-1-8下午4:43:55
  */
@Controller("userOrderJsonAction")
@Scope("prototype")
public class UserOrderJsonAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	@Autowired
    private UserOrderJsonService userOrderJsonService;
	
	@Autowired
	private UserMerchJsonMapper userMerchJsonMapper;
	
	public String submitOrder(){
		String o = request.getParameter("object");
		UserOrderJson userOrder = JSON.parseObject(o, UserOrderJson.class);
		String userId = request.getAttribute(JwtConstants.REQUEST_KEY_USERNAME)+"";
		UserMerchJson userMerch = userMerchJsonMapper.getInfoById(Long.valueOf(userOrder.getWawaId()));
		/****判断会员娃娃的状态******/
		if (!"1".equals(userMerch.getStatus())) {
			return returnJson(userOrder, "-1", "商品不是寄存状态");
		}
		System.out.println("getMerchId"+userMerch.getMerchId());
		userOrder.setUserId(userId);
		userOrder.setOrderType("1");
		userOrder.setOrderCode(OrderUtil.createOrderId());
		userOrder.setStatus("0");
		userOrder.setMerchId(userMerch.getMerchId());
		userOrderJsonService.insert(userOrder);
		
		/****用户订单添加成功会员娃娃的添加订单******/
		if (userOrder.getId() != null) {
			userMerch.setOrderId(userOrder.getId());
			userMerch.setStatus("3");
			userMerchJsonMapper.update(userMerch);
		}
		
		return returnJson(userOrder, "0", "");
	}
}
