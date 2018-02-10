package com.irandoo.xhep.anth.util;



/**
 * @description：生成每个用户唯一的邀请码
 * @author sun
 */

public class InvitateCodeUtil {

	/**
	 *  生成邀请码
	 * @return
	 */
	public  static String createCode(){
	 String invitateCode = (int)((Math.random()*9+1)*100000)+"";
	 return invitateCode;	
	}

}
