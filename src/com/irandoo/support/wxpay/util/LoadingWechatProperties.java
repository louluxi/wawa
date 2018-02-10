package com.irandoo.support.wxpay.util;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LoadingWechatProperties {
	
	private static final Log  logger = LogFactory.getLog(LoadingWechatProperties.class);  
	public static Map<String,Object> map = new HashMap<String,Object>();
		
	 public static Object getWechatValByKey(String key){ 
		 if(map.get(key) != null){
			 return map.get(key);
		 }
	     Properties prop = new Properties();   
	     String s = "";
	     try{
	    	 InputStream in = LoadingWechatProperties.class.getClassLoader().getResourceAsStream("wechat.properties");  
	         prop.load(in);     
	         s = prop.getProperty(key);
	         map.put(key, s);
	         in.close();
	     }
	     catch(Exception e){
	    	 logger.info("e.getLocalizedMessage()");
	     }
	     return s;
	 } 

}
