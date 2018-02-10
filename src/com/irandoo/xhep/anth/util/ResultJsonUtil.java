package com.irandoo.xhep.anth.util;

public class ResultJsonUtil {
	
	public String resultObject(String code,String message,String object){
	
		String str="{\"result\":"+code+",\"errmsg\":\""+message+"\",\"date\":"+object+"}";
		
		return str;
	}
	

}
