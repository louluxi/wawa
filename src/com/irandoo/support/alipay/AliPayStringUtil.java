package com.irandoo.support.alipay;

public class AliPayStringUtil {

	public static boolean isEmpty(String s){
		if(s!=null&&!"".equals(s)&&!"null".equals(s))
			return true;
		return false;
	}
}
