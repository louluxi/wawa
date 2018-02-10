package com.irandoo.support.alipay;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class AliPayPropertiesUtil {
	 public static Map<String,Object> map = new HashMap<String,Object>();
	 public static Object getAlipayValByKey(String key){ 
		 if(map.get(key) != null){
			 return map.get(key);
		 }
	     Properties prop = new Properties();   
	     String s = "";
	     try{
	    	 InputStream in = AliPayPropertiesUtil.class.getClassLoader().getResourceAsStream("alipay.properties");  
	         prop.load(in);     
	         s = prop.getProperty(key);
	         map.put(key, s);
	         in.close();
	     }
	     catch(Exception e){
	         System.out.println(e.getLocalizedMessage());
	     }
	     return s;
	 } 
	  
}
