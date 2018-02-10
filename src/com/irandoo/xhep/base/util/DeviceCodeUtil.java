package com.irandoo.xhep.base.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class DeviceCodeUtil {

	
 
     private static final char[] DIGITS_LOWER =
         {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
 
     /*
      * KEY+ stream_id + txTime
      */
     private static String getSafeUrl(String key, String streamId, long txTime) {
         String input = new StringBuilder().
                 append(key).
                 append(streamId).
                 append(Long.toHexString(txTime).toUpperCase()).toString();
 
         String txSecret = null;
         try {
             MessageDigest messageDigest = MessageDigest.getInstance("MD5");
             txSecret  = byteArrayToHexString(
                     messageDigest.digest(input.getBytes("UTF-8")));
         } catch (NoSuchAlgorithmException e) {
             e.printStackTrace();
         } catch (UnsupportedEncodingException e) {
             e.printStackTrace();
         }
 
         return txSecret == null ? "" :
             new StringBuilder().
                 append("txSecret=").
                 append(txSecret).
                 append("&").
                 append("txTime=").
                 append(Long.toHexString(txTime).toUpperCase()).
                 toString();
     }
 
     private static String byteArrayToHexString(byte[] data) {
         char[] out = new char[data.length << 1];
 
         for (int i = 0, j = 0; i < data.length; i++) {
             out[j++] = DIGITS_LOWER[(0xF0 & data[i]) >>> 4];
             out[j++] = DIGITS_LOWER[0x0F & data[i]];
         }
         return new String(out);
     }
     
     public static String StringComplemen(int id) {
 		String roomid =  String.valueOf(id);
 		String pad = "000000" ; 
 	    return "r1"+pad.substring(0, pad.length() - roomid.length()) + roomid;
 	}
     
     public static List getDeviceCodeList() {
		List<String> codeList = new ArrayList<String>();
		for (int i=20;i<120;i++) {
       	  String a= "rtmp://17937.livepush.myqcloud.com/live/17937_"+StringComplemen(i)+"?bizid=17937&"+getSafeUrl("wawa", "20180203", 20300101);
          codeList.add(a);
		}
		return codeList;
	}
     
     public static void main(String[] args) {
        // System.out.println(getSafeUrl("wawa", "20180203", 20300101));
    	 //String a = "rtmp://17937.livepush.myqcloud.com/live/17937_0cac31727e?bizid=17937&txSecret=18c6bec8f6513b98ba00c650cf89ac8c&txTime=5A75DC7F";
    	// String b = "rtmp://17937.livepush.myqcloud.com/live/17937_0r0000020?bizid=17937&txSecret=1ca8e85a0e2ace720adb2d998a1d2e8d&txTime=135C145";
    	 //rtmp://17937.livepush.myqcloud.com/live/
         for (int i=20;i<151;i++) {
        	 System.out.println("17937_"+StringComplemen(i)+"?bizid=17937&"+getSafeUrl("wawa", "20180203", 20300101));
         }
     }
     
}
