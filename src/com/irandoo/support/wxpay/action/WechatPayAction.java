package com.irandoo.support.wxpay.action;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import java.text.ParseException;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.jdom2.JDOMException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.irandoo.app.interf.json.PrivateRoomJson;
import com.irandoo.app.interf.service.PrivateRoomJsonService;
import com.irandoo.support.wxpay.handler.PrepayIdRequestHandler;
import com.irandoo.support.wxpay.model.RechargeOrder;
import com.irandoo.support.wxpay.service.RechargeOrderService;

import com.irandoo.support.wxpay.util.ConstantUtil;
import com.irandoo.support.wxpay.util.MD5Util;
import com.irandoo.support.wxpay.util.OrderUtil;
import com.irandoo.support.wxpay.util.WXUtil;
import com.irandoo.support.wxpay.util.XMLUtil;
import com.irandoo.xhep.base.action.BaseAction;
import com.irandoo.xhep.base.model.Meal;
import com.irandoo.xhep.base.model.RechargeRecord;
import com.irandoo.xhep.base.service.MealService;
import com.irandoo.xhep.base.service.RechargeRecordService;
import com.irandoo.xhep.base.service.UserAccountService;

/**
*<p>Title:WeiXinPayController </p>
*<p>Description:</p>
*<p>Company:</p> 
*@author sun
*@date 2018年1月22日10:01:19
*/
@Controller("wechatPayAction")
@Scope("prototype")
public class WechatPayAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4071603624936342541L;
	
	private Log logger = LogFactory.getLog(WechatPayAction.class);
	@Autowired
	MealService mealService;
	@Autowired
	RechargeOrderService rechargeOrderService;
	@Autowired
	UserAccountService userAccountService;
	@Autowired
	RechargeRecordService rechargeRecordService;
	@Autowired
    PrivateRoomJsonService privateRoomJsonService; 

	/**
     * 生成预支付订单，获取prepayId
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
	public String wxPay(){

	    String o = request.getParameter("object");
		Map<String,Object> paramMap = (Map<String,Object>)JSON.parse(o);
		//----------------------获取App传过来的参数-------------------
		//获取套餐id
		String meals = (String) paramMap.get("mealId");	

		Long mealId = Long.parseLong(meals);

		//获取套餐详细信息
	    Meal meal =	mealService.getInfoByMealId(mealId);
	    //获取用户id
	    String userId = (String) request.getAttribute("userId");

	    logger.info("套餐价格:"+meal.getPrice());
		//获取充值渠道
		String channelName = (String) paramMap.get("channelName");
		//房间id
		String roomId = (String) paramMap.get("roomId");
		String privateRoomId = null;
		String receiveUserId = null;
		RechargeOrder rechargeOrder =new RechargeOrder();
        if (null != paramMap.get("roomId")){//它充
        	//获取房间id
   	        roomId = (String) paramMap.get("roomId");	
   	        rechargeOrder.setRoomId(Long.parseLong(roomId));
   	       if (null != paramMap.get("privateRoomId")) {
 	        //获取包房id
 	        privateRoomId = (String) paramMap.get("privateRoomId");
 	        //根据包房id获取被充人
 	        Map<String, Object> mealmap = new HashMap<>();
 	        mealmap.put("id", privateRoomId);
 	        List<PrivateRoomJson> m =  privateRoomJsonService.returnInfo(mealmap);
 	        //获取被充人id
 			 receiveUserId = m.get(0).getCreator();;
 			 rechargeOrder.setReceiveUserId(Long.parseLong(receiveUserId));
 	         rechargeOrder.setPrivateRoomId(Long.parseLong(privateRoomId));
 		    }   
		 }else{//自充
			 receiveUserId = userId;
			 rechargeOrder.setReceiveUserId(Long.parseLong(receiveUserId));
		 }
		
		Map<String, Object> map=new HashMap<String, Object>();
		//2.5 订单号，此处用时间加随机数生成，商户根据自己情况调整，只要保持全局唯一就行  
        String strReq =OrderUtil.createOrderId();
        //设置充值订单实体
       
        rechargeOrder.setOrderId(strReq);
        rechargeOrder.setBuyUserId(Long.parseLong(userId));
        rechargeOrder.setMealId(mealId);
        rechargeOrder.setPayMoney(meal.getPrice());
        rechargeOrder.setPayType(channelName); 
        //生成交易订单
        try {
        	 rechargeOrderService.insert(rechargeOrder);
        	 logger.info("成功交易单成功!");
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("生成交易单失败!");
		}
        //获取充值金额;
        String total_fee= meal.getPrice()*100+"";             //充值金额
		String out_trade_no=strReq;                      //订单号
		String timestamp = WXUtil.getTimeStamp();        //超时时间
		String nonce_str = WXUtil.getNonceStr();         // 生成随机字符串
		//---------------------------------------------- ***** 统一下单开始 *****  -----------------------------------------------------------
		 //3.获取生成预支付订单的请求类
        PrepayIdRequestHandler prepayReqHandler = new PrepayIdRequestHandler(request, response);     
        prepayReqHandler.setParameter("appid",  ConstantUtil.APP_ID);                  //平台应用appId
        prepayReqHandler.setParameter("mch_id", ConstantUtil.MCH_ID);                  //商户号
        prepayReqHandler.setParameter("nonce_str", nonce_str);                         //随机字符串
        prepayReqHandler.setParameter("body",   ConstantUtil.BUY_BODY);                //商品描述
        prepayReqHandler.setParameter("out_trade_no", out_trade_no);                   //订单号
        prepayReqHandler.setParameter("total_fee",String.valueOf(total_fee));          //订单价格
        prepayReqHandler.setParameter("spbill_create_ip", request.getRemoteAddr());    //获取客户端ip
        prepayReqHandler.setParameter("notify_url", ConstantUtil.NOTIFY_URL);          //回调通知
        prepayReqHandler.setParameter("trade_type", "APP");                            //支付类型
        prepayReqHandler.setParameter("time_start", timestamp);                        //时间戳
        prepayReqHandler.setGateUrl(ConstantUtil.GATEURL);                             //设置预支付id的接口url
        //3.3 注意签名（sign）的生成方式，具体见官方文档（传参都要参与生成签名，且参数名按照字典序排序，最后接上APP_KEY,转化成大写）
        prepayReqHandler.setParameter("sign", prepayReqHandler.createMD5Sign());    //sign 签名
        //3.4 提交预支付,获取prepayid 
        String prepayid = null;
		try {
			prepayid = prepayReqHandler.sendPrepay();
			logger.debug("预支付订单id----:"+prepayid);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		//---------------------------------------------- ***** 统一下单 结束 *****  --------------------------------------------------------------
	    //3.5 若获取prepayid成功，将相关信息返回客户端
		String result = null;
		String errmsg = null;
	   if (prepayid != null && !prepayid.equals("")) {
		   String signs = 
                   "appid=" + ConstantUtil.APP_ID +
                   "&noncestr=" + nonce_str + 
                   "&package=Sign=WXPay"+ 
                   "&partnerid="+ ConstantUtil.PARTNER_ID + 
                   "&prepayid=" + prepayid + 
                   "&timestamp=" + timestamp+
                   "&key="+ ConstantUtil.APP_KEY;  
		   map.put("appid", ConstantUtil.APP_ID);
		   map.put("partnerid", ConstantUtil.PARTNER_ID);     //商家id
		   map.put("prepayid", prepayid);                     //预支付id
		   map.put("package", "Sign=WXPay");                  //固定常量
		   map.put("noncestr", nonce_str);                    //与请求prepayId时值一致
		   map.put("timestamp", timestamp);                   //等于请求prepayId时的time_start
		   map.put("sign", MD5Util.MD5Encode(signs, "utf8").toUpperCase());//签名方式与上面类似
		   result = "0";
		   errmsg = "";
		  } else {
		    result = "-1";
			errmsg = "获取prepayid失败";
			logger.info("获取prepayid失败");
		  }
        return returnJson(map, result, errmsg);
	}

    /**
     * 9.2 接收微信支付成功通知
     * @param request
     * @param response
     * @throws IOException
     * @throws java.io.IOException 
     * @throws ParseException 
    */
    public void getnotify()throws IOException, ParseException {
         //1.创建输入输出流
         PrintWriter writer = response.getWriter();
         InputStream inStream = request.getInputStream();
         ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = inStream.read(buffer)) != -1) {
                outSteam.write(buffer, 0, len);
            }
            outSteam.close();
            inStream.close();
            //2.将结果转换
            String result = new String(outSteam.toByteArray(), "utf-8");
            logger.info("微信支付通知结果：" + result);
            Map<String, String> map = null;
            try {
                //3.解析微信通知返回的信息
                map = XMLUtil.doXMLParse(result);
                logger.info("微信返回结果：" + map);
            } catch (JDOMException e) {
                e.printStackTrace();
            }
            // 4.若支付成功，则告知微信服务器收到通知
            if (map != null && map.get("result_code").toString().equalsIgnoreCase("SUCCESS")) {
	            String out_trade_no = map.get("out_trade_no");
	            logger.info("wechat back out_trade_no+"+out_trade_no);
	            //查询订单实体
	                  RechargeOrder rechargeOrder = rechargeOrderService.getInfoByOrderId(out_trade_no);
	           
	                 if("2".equals(rechargeOrder.getState())||2==rechargeOrder.getState()){
	                	 logger.info("已经回调成功过了.....");
	                 } else if(rechargeOrder.getState().equals("1")||rechargeOrder.getState()==1){  
	                	 //判断实付金额与订单金额是否一致
	                	 String wechatMoney = map.get("total_fee");
	                	 logger.info("订单金额 :"+rechargeOrder.getPayMoney());
	                	 String orderPayMoney = rechargeOrder.getPayMoney()*100+"";
	                	 if(orderPayMoney.equals(wechatMoney)){
	                		 //修改订单状态
			                  rechargeOrder.setState(Long.parseLong("2"));	
			                int n = rechargeOrderService.updateState(rechargeOrder);
				               if(n>0){//修改成功,执行添加账户的操作
				            	//获取充值人的id
				            	Long receiveUserId = rechargeOrder.getReceiveUserId();
				            	//根据套餐id获取套餐信息
				            	Meal meal= mealService.getInfoByMealId(rechargeOrder.getMealId());
			            	    //获取套餐里的娃娃币
				                Long doll_coin = meal.getDoll_coin();
				                //获取套餐奖励的娃娃币
				                Long reward_coin = meal.getReward_coin();
				                //执行添加娃娃币的服务
				                Map<String, Object> accountMap =new HashMap<String, Object>();
				                  accountMap.put("userId", receiveUserId);
				                  //默认充值娃娃币账户
				                  accountMap.put("accountType", 1);
				                  accountMap.put("balance", doll_coin+reward_coin);
				                int m = userAccountService.addBalance(accountMap);
				                if(m>0){//添加成功
				                	//添加充值流水
				                	RechargeRecord  rechargeRecord = new RechargeRecord();
				                	if(null!=rechargeOrder.getRoomId()){
				                		rechargeRecord.setRoom_id(rechargeOrder.getRoomId());
				                	}		               
				                	rechargeRecord.setUser_id(rechargeOrder.getBuyUserId());
			                        rechargeRecord.setMeal_id(rechargeOrder.getMealId());
			                        rechargeRecord.setRecharge_order_id(out_trade_no);
			                        rechargeRecord.setRecharge_user_id(rechargeOrder.getReceiveUserId());
			                        rechargeRecord.setOrder_money(meal.getPrice());
			                        rechargeRecord.setExchange_coin(new Integer(meal.getDoll_coin()+""));
			                        rechargeRecord.setReward_coin(new Integer(meal.getReward_coin()+""));
			                        rechargeRecord.setPay_type(rechargeOrder.getPayType());
			                        rechargeRecord.setPay_money(rechargeOrder.getPayMoney());
			                        rechargeRecord.setType(1); //默认充值充值流水为充值                	
				                	rechargeRecordService.insert(rechargeRecord);
				                }else{
				                	 logger.info(out_trade_no+"------充值账户失败-----");
				                }
	                	 }else{
	                		 logger.info("非法回调,订单金额与回调金额不一致.");
	                	 }
	                	
		            }else{
		            	 //修改订单状态(失败)
		                 rechargeOrder.setState(Long.parseLong("0"));	
		                 rechargeOrderService.updateState(rechargeOrder);
		            	 logger.info("------修改订单状态失败-----");
		              }
	               }else{
	                	logger.info("失败订单");   
	               }
            
            	  String notifyStr = XMLUtil.setXML("SUCCESS", "");
                  writer.write(notifyStr);
                  writer.flush();
            	   logger.info("------微信回调成功-----");
            	}else{
            	     
            		  String notifyStr = XMLUtil.setXML("ERROR", "");
                      writer.write(notifyStr);
                      writer.flush();
            	 logger.info("------微信回调失败-----");
            } 
    }  
}
