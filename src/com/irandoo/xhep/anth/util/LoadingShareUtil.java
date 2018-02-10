package com.irandoo.xhep.anth.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class LoadingShareUtil {
	public static Map<String, Object>  loading(){
		 Map<String, Object> map=new HashMap<String, Object>();
		  Properties properties=new Properties();  
	        try {  
	          InputStream in = LoadingShareUtil.class.getClassLoader().getResourceAsStream("shareIcon.properties");  
	      	  properties.load(in); 
	          String backgroundUrl  =properties.getProperty("backgroundUrl"); 
	          String aboveUrl = properties.getProperty("aboveUrl");
	          String compoundUrl = properties.getProperty("compoundUrl");
	          String compoundName = properties.getProperty("compoundName");
	          String finalUrl = properties.getProperty("finalUrl");
	          map.put("backgroundUrl",backgroundUrl );
	          map.put("aboveUrl",aboveUrl);
	          map.put("compoundUrl",compoundUrl);
	          map.put("compoundName",compoundName);
	          map.put("finalUrl",finalUrl);
	        } catch (FileNotFoundException e) {  
	            e.printStackTrace();  
	        } catch (IOException e) { 
	            e.printStackTrace();  
	        } 
		return map;
	}
	public static Map<String, Object>  replaceloading(){
		 Map<String, Object> map=new HashMap<String, Object>();
		  Properties properties=new Properties();  
	        try {  
	          InputStream in = LoadingShareUtil.class.getClassLoader().getResourceAsStream("replaceShareIcon.properties");  
	      	  properties.load(in); 
	          String backgroundUrl  =properties.getProperty("backgroundUrl"); 
	          String aboveUrl = properties.getProperty("aboveUrl");
	          String compoundUrl = properties.getProperty("compoundUrl");
	          String compoundName = properties.getProperty("compoundName");
	          String finalUrl = properties.getProperty("finalUrl");
	          map.put("backgroundUrl",backgroundUrl );
	          map.put("aboveUrl",aboveUrl);
	          map.put("compoundUrl",compoundUrl);
	          map.put("compoundName",compoundName);
	          map.put("finalUrl",finalUrl);
	        } catch (FileNotFoundException e) {  
	            e.printStackTrace();  
	        } catch (IOException e) { 
	            e.printStackTrace();  
	        } 
		return map;
	}
}
