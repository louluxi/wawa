package com.irandoo.app.interf.util;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesUtil {
	 public static Map<String,Object> map = new HashMap<String,Object>();
	 public static Object getMsgProValByKey(String key){ 
		 if(map.get(key) != null){
			 return map.get(key);
		 }
	     Properties prop = new Properties();   
	     String s = "";
	     try{
	    	 InputStream in = PropertiesUtil.class.getClassLoader().getResourceAsStream("msgInterf.properties");  
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
	 public static Object getDevProValByKey(String key){ 
		 if(map.get(key) != null){
			 return map.get(key);
		 }
	     Properties prop = new Properties();   
	     String s = "";
	     try{
	    	 InputStream in = PropertiesUtil.class.getClassLoader().getResourceAsStream("devServer.properties");  
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
