package com.irandoo.xhep.anth.util;

/***
 * @description：生成userCode工具类
 * @author sun
 *
 */

public class UserCodeUtil {
	
	public static String createUserCode(String userId){
		String str="";
		switch (userId.length()) {
			case 1:
				str="w000000"+userId;
				break;
	
			case 2:
				str="w00000"+userId;
				break;
			
			case 3:
				str="w0000"+userId;
				break;
			
			case 4:
				str="w000"+userId;
				break;
			
			case 5:
				str="w00"+userId;
				break;
			
		    case 6:
		    	str="w0"+userId;
			break;
			
		    case 7:
		    	str="w"+userId;	
				break;
			}
		 return str;
	}

}
