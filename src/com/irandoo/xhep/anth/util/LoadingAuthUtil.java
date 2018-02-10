package com.irandoo.xhep.anth.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


/**
 * @description：加载登陆授权配置文件工具类
 * @author sun
 *
 */
public class LoadingAuthUtil {
	
	public static Map<String, Object>  loading(){
		 Map<String, Object> map=new HashMap<String, Object>();
		  Properties properties=new Properties();  
	        try {  
	          InputStream in = LoadingAuthUtil.class.getClassLoader().getResourceAsStream("auth.properties");  
	      	  properties.load(in); 
	          String tokenUrl  =properties.getProperty("tokenUrl"); 
	          String appid = properties.getProperty("appid");
	          String secret = properties.getProperty("secret");
	          String refreshTokenUrl = properties.getProperty("refreshTokenUrl");
	          String userInfoUrl = properties.getProperty("userInfoUrl");
	          map.put("tokenUrl",tokenUrl );
	          map.put("appid",appid);
	          map.put("secret",secret);
	          map.put("refreshTokenUrl",refreshTokenUrl);
	          map.put("userInfoUrl",userInfoUrl);
	        } catch (FileNotFoundException e) {  
	            e.printStackTrace();  
	        } catch (IOException e) { 
	            e.printStackTrace();  
	        } 
		return map;
	}

}
