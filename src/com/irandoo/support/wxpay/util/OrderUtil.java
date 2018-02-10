package com.irandoo.support.wxpay.util;

import java.util.Date;

/**
 * 订单号生成工具类
 * @author sun
 *
 */
public class OrderUtil {
	/**
	 * 订单前缀
	 */
    public static final String orderPrefix="40000";
    /**
     *  生成订单号
     * @return
     */

	public static String createOrderId(){
		//2.1.当前时间 yyyyMMddHHmmss  
        String currTime = TenpayUtil.getCurrTime();  
        //2.2 8位日期  
        String strTime = currTime.substring(8, currTime.length());  
        //2.3四位随机数  
        String strRandom = TenpayUtil.buildRandom(4) + "";  
        //2.4 10位序列号,可以自行调整。  
        String strReq = strTime + strRandom;  
        //2.5 订单号
        String orderNumber=orderPrefix+TenpayUtil.formatDate(new Date())+strReq;

        return orderNumber;
	}

}
