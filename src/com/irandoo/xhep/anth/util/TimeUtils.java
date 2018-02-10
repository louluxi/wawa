package com.irandoo.xhep.anth.util;

import java.util.Date;

/**
 *  时间工具类
 * @author sun
 *
 */
public class TimeUtils {

	/**
	 * 
	 * @param time1 过期时间
	 * @param time2 系统当前时间
	 * @return
	 */
	public static double getTimeDifference(Date time1,Date time2){
		long timeOne=time1.getTime()/60/60/1000;
		long timeTwo=time2.getTime()/60/60/1000;		
		return timeTwo-timeOne;
	}

}
