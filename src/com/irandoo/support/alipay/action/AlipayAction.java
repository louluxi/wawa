package com.irandoo.support.alipay.action;


import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.irandoo.support.alipay.AliPayStringUtil;
import com.irandoo.support.alipay.AlipayConfig;
import com.irandoo.support.alipay.model.AliPayMeal;
import com.irandoo.support.alipay.model.AliPayPrivateRoom;
import com.irandoo.support.alipay.model.AliPayRechargeOrder;
import com.irandoo.support.alipay.model.AliPayRechargeRecord;
import com.irandoo.support.alipay.model.AliPayUserAccount;
import com.irandoo.support.alipay.service.AliPayPrivateRoomService;
import com.irandoo.support.alipay.service.AliPayRechargeOrderService;
import com.irandoo.support.alipay.service.AliPayRechargeRecordService;
import com.irandoo.support.alipay.service.AliPayUserAccountService;
import com.irandoo.support.alipay.service.AlipayMealService;
import com.irandoo.support.wxpay.util.OrderUtil;
import com.irandoo.xhep.base.action.BaseAction;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 * Created by yuel on 2018/1/13.
 */
@Controller("alipayAction")
@Scope("prototype")
public class AlipayAction extends BaseAction {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -8387949031781625220L;
	private Log logger = LogFactory.getLog(AlipayAction.class);
	@Autowired
    private AliPayPrivateRoomService aliPayPrivateRoomService;//私有房间
    @Autowired
    private AlipayMealService alipayMealService;//查询套餐
    @Autowired
    private  AliPayUserAccountService aliPayUserAccountService;//个人账户
    @Autowired
    private AliPayRechargeOrderService aliPayRechargeOrderService;//充值流水
    @Autowired
    private  AliPayRechargeRecordService aliPayRechargeRecordService;//充值流水
    //支付宝支付
    public String payAuth(){
    	logger.debug("enter payAuth method");
    	String orderStr = null;
		String errmsg = null;
		String result = null;
    	Map orderMap = new HashMap();
    	try {
    	/* ==========================1.获取app端数据 开始================================ */
    	Map<String,Object> paramMap = getInterfMap();
    	String meal_id =  paramMap.get("meal_id")+"";//获取套餐id
    	String user_id = paramMap.get("userId")+"";//获取用户id
    	String receive_user_id = paramMap.get("receive_user_id")+"";//获取充值人id 
    	String room_id = paramMap.get("room_id")+"";//房间id 
    	String private_room_id =  paramMap.get("private_room_id")+"";//包房id
    	String channelName = paramMap.get("channelName")+"";//充值类型
    	/* ==========================获取app端数据 结束================================ */
    	logger.info("private_room_id......"+private_room_id);
    	logger.info("user_id......"+user_id);
    	/* ==========================设置被充值人 开始================================ */
    	if (AliPayStringUtil.isEmpty(private_room_id)){
    	  AliPayPrivateRoom aliPayPrivateRoom =	aliPayPrivateRoomService.getInfoById(Long.valueOf(private_room_id));
    	  logger.info("aliPayPrivateRoom...getCreator"+aliPayPrivateRoom.getCreator()+"");
    	  receive_user_id = aliPayPrivateRoom.getCreator()+"";
    	}else {
    		receive_user_id = user_id;
    	}
    	/* ==========================设置被充值人 结束================================ */
    	logger.info("receive_user_id............"+receive_user_id);
    	/* ==========================2.根据套餐id获取该套餐的详情 开始================================ */
    	AliPayMeal aliPayMeal = null;
    	if (AliPayStringUtil.isEmpty(meal_id)) {
    		 aliPayMeal = alipayMealService.getInfoById(Long.valueOf(meal_id));
    	}
    	/* ==========================根据套餐id获取该套餐的详情 结束================================ */
        
    	/* ==========================3.获取业务参数 开始================================ */
    	String outtradeno = OrderUtil.createOrderId();
        String APP_ID = AlipayConfig.app_id;
        String APP_PRIVATE_KEY = AlipayConfig.private_key;
        String ALIPAY_PUBLIC_KEY = AlipayConfig.ali_public_key;
        String myServerUrl = AlipayConfig.service;
        logger.info("myServerUrl"+myServerUrl);
        String CHARSET = AlipayConfig.input_charset;
        String serverUrl = AlipayConfig.serverUrl;
        String sign_type = AlipayConfig.sign_type;


        //String sellerId = AlipayConfig.seller;
        /* ==========================3.获取业务参数 结束================================ */
        
        /* ==========================4.添加充值订单 开始================================ */
        //参数说明  ：订单号,房间id,包房id,充值人id,被充值人id,套餐id,支付金额,支付方式
       AliPayRechargeOrder aliPayRechargeOrder = 
    		   aliPayRechargeOrderService.addRecharageOrder(outtradeno, room_id,
    		   private_room_id, user_id,
    		   receive_user_id,Long.valueOf(meal_id),aliPayMeal.getPrice(),
    		   channelName);
       aliPayRechargeOrderService.insert(aliPayRechargeOrder);
        /* ==========================4.添加充值订单 结束================================ */
       
       //实例化客户端 https://openapi.alipay.com/gateway.do
        AlipayClient alipayClient = new DefaultAlipayClient(serverUrl, APP_ID, APP_PRIVATE_KEY, "json", CHARSET, ALIPAY_PUBLIC_KEY, sign_type);
        //实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
        AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
        //SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
        AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
        model.setBody(aliPayMeal.getRemark());//描述信息
        model.setSubject(aliPayMeal.getName());//商品标题
        model.setOutTradeNo(outtradeno);//商家订单编号
        model.setTimeoutExpress("30m");//超时关闭该订单时间
        model.setTotalAmount(String.valueOf(aliPayMeal.getPrice()));//订单总金额String.valueOf(aliPayMeal.getPrice())
        model.setProductCode("QUICK_MSECURITY_PAY");//销售产品码，商家和支付宝签约的产品码，为固定值QUICK_MSECURITY_PAY
        //model.setSellerId(sellerId);//商家id
        request.setBizModel(model);
        request.setNotifyUrl(myServerUrl);
        try {
            //这里和普通的接口调用不同，使用的是sdkExecute
            AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
            orderStr = response.getBody();
           // System.out.println(orderStr);//就是result 可以直接给客户端请求，无需再做处理。
            logger.debug("订单返回结果"+orderStr);
            result = "0";
 		    errmsg = "订单成功";
 		    orderMap.put("orderStr", orderStr);
 		   return returnJson(orderMap, result, errmsg);
        } catch (AlipayApiException e) {
        	result = "-1";
 		    errmsg = "订单失败";
 		    logger.debug("在返回签名支付时失败");
            e.printStackTrace();
        }
        
    	} catch (Exception e) {
    		result = "-1";
			errmsg = "订单失败";
			logger.debug("订单失败");
		   	e.printStackTrace();
	    }
    	logger.info("orderMap:"+orderMap);
    	return returnJson(orderMap, result, errmsg);
    }
    /**
     * 回调
     * @return
     */
    public String alipayCallback() {
    	logger.debug("enter alipayCallback method");
    	logger.info("enter alipayCallback method");
        String alipaypublicKey = AlipayConfig.ali_public_key;
        String charset = AlipayConfig.input_charset;
        String sign_type = AlipayConfig.sign_type;
        //获取支付宝POST过来反馈信息
      //获取支付宝POST过来反馈信息
    	Map<String,String> params = new HashMap<String,String>();
    	Map requestParams = request.getParameterMap();
    	logger.info("requestParams:"+requestParams);
    	
    	for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
    		String name = (String) iter.next();
    		String[] values = (String[]) requestParams.get(name);
    		String valueStr = "";
    		for (int i = 0; i < values.length; i++) {
    			valueStr = (i == values.length - 1) ? valueStr + values[i]
    					: valueStr + values[i] + ",";
    		}
    		params.put(name, valueStr);
    	}

    	logger.info("params :"+params);
    	//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
    		//商户订单号
    	String out_trade_no = null;
    	String trade_no = null;
    	Double amount = null;
    	String trade_status = null;
    		try {
				 out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
				 trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
				 amount =Double.parseDouble(new String(request.getParameter("buyer_pay_amount").getBytes("ISO-8859-1"),"UTF-8"));
				 trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");
    		} catch (UnsupportedEncodingException e2) {
				e2.printStackTrace();
			}
    		//支付宝交易号 

    		logger.info("out_trade_no="+out_trade_no);
    		logger.info("trade_no="+trade_no);
    		logger.info("amount="+amount);

    		
    		
    		//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//
    		//计算得出通知验证结果
    		//boolean AlipaySignature.rsaCheckV1(Map<String, String> params, String publicKey, String charset, String sign_type)
    		boolean verify_result = false;
    		logger.info("verify_result:"+verify_result);
			try {
				verify_result = AlipaySignature.rsaCheckV1(params, alipaypublicKey, charset,sign_type);
			} catch (AlipayApiException e) {
				e.printStackTrace();
			}
    		logger.info("verify_result="+verify_result);
    		if(verify_result){//验证成功
    			//////////////////////////////////////////////////////////////////////////////////////////
    			//请在这里加上商户的业务逻辑程序代码
    			if (trade_status.equals("TRADE_SUCCESS")){ //交易成功    
    			//——请根据您的业务逻辑来编写程序（以下代码仅作参考）——
    			logger.info("verify_result jin ru cheng gong verify_result:"+verify_result);
    			int tempCount = 0;
                if (AliPayStringUtil.isEmpty(out_trade_no)) {//获取充值订单类型
                	Map map = new HashMap<>();
                	map.put("order_id", out_trade_no);
                	tempCount =  aliPayRechargeOrderService.getRechargeOrderCount(map);
                 }
                //==========================先判断是否已经回调处理 结束================================ 
                  logger.info("tempCount ="+tempCount);
    			if(tempCount==1||String.valueOf(tempCount).equals("1")){
    				
    				AliPayRechargeOrder rechargeOrder = aliPayRechargeOrderService.getAliPayRechargeOrderById(out_trade_no);//获取套餐
    				
    				if (amount.longValue() == rechargeOrder.getPay_money().longValue()) {//判断支付金额是否和套餐金额相等，防止钓鱼

               	   logger.info("amount="+amount);
               	   
                  //  ==========================根据订单号获取充值订单表 开始================================ 
                   Long receive_user_id = rechargeOrder.getReceive_user_id();
                   logger.info("alipay receive_user_id:"+receive_user_id);
                  //  ==========================根据订单号获取充值订单表 开始================================ 
                                     
                   // ==========================根据套餐id获取套餐参数 开始================================ 
                   //获取套餐id
                   Long meal_id = rechargeOrder.getMeal_id();
                   logger.info("alipay meal_id:"+meal_id);
                   AliPayMeal aliPayMeal = alipayMealService.getInfoById(Long.valueOf(meal_id)); 
                   logger.info("aliPayMeal"+aliPayMeal);
                   // ==========================根据套餐id获取套餐参数 结束================================ 
                   
                   // ==========================根据被充值人id获取被充值人账户，并更新充值人娃娃币数量 开始================================ 
                   AliPayUserAccount aliPayUserAccount = aliPayUserAccountService.getInfoById(Long.valueOf(receive_user_id));
                  
                 //账户原有的娃娃币
                   Long amount_Account = aliPayUserAccount.getBalance()==null?0:aliPayUserAccount.getBalance();
                   //充值的娃娃币
                   Long User_EXCHANGE_COIN = aliPayMeal.getDoll_coin()==null?0:aliPayMeal.getDoll_coin();
                   //赠送的娃娃币
                   Long User_REWARD_COIN = aliPayMeal.getReward_coin()==null?0:aliPayMeal.getReward_coin();
                   //计算总的娃娃币数量
                   Long All_User_Coin= amount_Account + User_EXCHANGE_COIN + User_REWARD_COIN; 
                   logger.info("alipay userAccount:"+aliPayUserAccount);
                   //判断冲值金额是否大于0,修改玩家娃娃币总数
                    if (All_User_Coin>0) {
                   	 aliPayUserAccount.setBalance(All_User_Coin);
                        aliPayUserAccountService.update(aliPayUserAccount);
                    } 
                   //==========================根据被充值人id获取被充值人账户，并更新充值人娃娃币数量 结束================================ 
                    
                   // ==========================支付成功更新充值订单表状态（成功）开始================================
                    AliPayRechargeOrder aliPayRechargeOrder = new AliPayRechargeOrder();
                    if (AliPayStringUtil.isEmpty(out_trade_no)) {
                    	logger.info("更新订单状态为成功");
                    	aliPayRechargeOrder.setOrder_id(out_trade_no);
                    	aliPayRechargeOrder.setState(2);
                    	aliPayRechargeOrderService.update(aliPayRechargeOrder);
                    }
                    logger.info("更新套餐状态成功");
                    // ==========================支付成功更新充值订单表状态（成功）结束================================ 
                    
                    // ==========================添加流水表 开始================================ 
                    //获得充值流水表所需的参数
                    Long ROOM_id = rechargeOrder.getRoom_id();//房间id
                    Long USER_id = rechargeOrder.getBuy_user_id();//用户id
                    Long MEAL_id = rechargeOrder.getMeal_id();//套餐id
                    String recharge_order_id = rechargeOrder.getOrder_id();//充值订单id
                    logger.info("alipay recharge_order_id:"+recharge_order_id);
                    Long Recharge_user_Id = rechargeOrder.getReceive_user_id();//充值人id
                    logger.info("alipay Recharge_user_Id:"+Recharge_user_Id);
                    Long ORDER_MONEY =  aliPayMeal.getPrice();//订单金额
                    logger.info("ORDER_MONEY:"+ORDER_MONEY);
                    Integer EXCHANGE_COIN = Integer.valueOf(String.valueOf(aliPayMeal.getDoll_coin()));//兑换娃娃币
                    Integer reward_coin = Integer.valueOf(String.valueOf(aliPayMeal.getReward_coin()));//奖励娃娃币
                   // Integer PAY_MONEY = Integer.valueOf(amount);//支付金额
                    Long PAY_MONEY  = rechargeOrder.getPay_money();//支付金额
                    logger.info("PAY_MONEY:"+PAY_MONEY);
                    AliPayRechargeRecord aliPayRechargeRecord = aliPayRechargeRecordService.addRechargeRecord (ROOM_id,USER_id,MEAL_id,recharge_order_id,Recharge_user_Id,ORDER_MONEY,EXCHANGE_COIN,PAY_MONEY,reward_coin); 
                    aliPayRechargeRecordService.insert(aliPayRechargeRecord);
                    logger.info("支付流水添加成功 ........");
                    //return resultString(String.valueOf(flag));
   				//注意：
   				//如果签约的是可退款协议，退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
   				//如果没有签约可退款协议，那么付款完成后，支付宝系统发送该交易状态通知。
   			} else {
   				     logger.info("充值金额与套餐金额不符");
   			  }
    		} else if (tempCount==2||String.valueOf(tempCount).equals("2")) {
    				//判断该笔订单是否在商户网站中已经做过处理
    					//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
    					//请务必判断请求时的total_fee、seller_id与通知时获取的total_fee、seller_id为一致的
    					//如果有做过处理，不执行商户的业务程序
    				logger.info("已经处理过此订单  verify_result:"+verify_result);
    				//注意：
    				//如果签约的是可退款协议，那么付款完成后，支付宝系统发送该交易状态通知。
    		}else {
    				
    				logger.info("此订单处理失败  verify_result:"+verify_result);
    			
    		}
    			
    			logger.info("业务处理完毕");
    			//——请根据您的业务逻辑来编写程序（以上代码仅作参考）——
    			
    		} else {//交易失败
    			 verify_result = false;
    			 AliPayRechargeOrder aliPayRechargeOrder = new AliPayRechargeOrder();
                 //订单状态更新为失败
    			 if (AliPayStringUtil.isEmpty(out_trade_no)) {
                 	logger.info("更新订单状态为交易失败");
                 	aliPayRechargeOrder.setOrder_id(out_trade_no);
                 	aliPayRechargeOrder.setState(0);
                 	aliPayRechargeOrderService.update(aliPayRechargeOrder);
                 }
    			logger.info("交易失败  :"+verify_result);
    		}
    		return resultString(String.valueOf(verify_result));
    		//////////////////////////////////////////////////////////////////////////////////////////
    		}else{//验证失败
    			logger.info("验签失败 :"+verify_result);
    		}
    		return resultString(String.valueOf(verify_result));
    }


}
