package com.irandoo.app.interf.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.irandoo.xhep.base.service.SysConfigService;

/**
 * <p>
 * Title: 摄像头工具类
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company: irandoo
 * </p>
 * 
 * @author ager
 * @date 2018-1-18下午3:59:55
 */
public class LiveUtil {

	public static String bizid = null;
	public static String random = null;
	public static Long expiryTime = null;
	
	public LiveUtil(){
		if(bizid == null){
			WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
			SysConfigService deviceJsonService = (SysConfigService) wac.getBean("sysConfigService");
			bizid = deviceJsonService.getValue("SYSTEM", "LIVE", "BIZID");
			random = deviceJsonService.getValue("SYSTEM", "LIVE", "RANDOM");
			expiryTime = Long.parseLong(deviceJsonService.getValue("SYSTEM", "LIVE", "EXPIRY_TIME"));
		}
	}

	/**
	 * 获取推流地址
	 * @param roomCode  房间号
	 * @param position  位置（00 - 前摄像头；01 - 侧摄像头）
	 * @author ager
	 * @return 推流地址
	 */
	/*public static String getPushUrl(String roomCode, String position) {
		new LiveUtil();
		String url = "rtmp://" 
				+ bizid + ".livepush.myqcloud.com/live/" 
				+ bizid + "_"
				+ roomCode + "_" + position + "?bizid="
				+ bizid + "&" + getSafeUrl(bizid, random, expiryTime);
		return url;
	}*/
	public static String getPushUrl(String roomCode, String position) {
		new LiveUtil();
		String url = "rtmp://" 
				+ bizid + ".livepush.myqcloud.com/live/" 
				+ bizid + "_"
				+ roomCode + "?bizid="
				+ bizid + "&" + getSafeUrl(bizid, random, expiryTime);
		return url;
	}

	/**
	 * 获取播放地址
	 * @param roomCode  房间号
	 * @param position  位置（00 - 前摄像头；01 - 侧摄像头）
	 * @author ager
	 * @return 播放地址
	 */
	/*public static String getLiveUrl(String roomCode, String position) {
		new LiveUtil();
		String url = "rtmp://" 
					+ bizid + ".liveplay.myqcloud.com/live/" 
					+ bizid + "_"
					+ roomCode + "_" + position;
		return url;
	}*/
	public static String getLiveUrl(String roomCode, String position) {
		new LiveUtil();
		String url = "rtmp://" 
					+ bizid + ".liveplay.myqcloud.com/live/" 
					+ bizid + "_"
					+ roomCode;
		return url;
	}

	private static final char[] DIGITS_LOWER = { '0', '1', '2', '3', '4', '5',
			'6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

	/*
	 * KEY+ stream_id + txTime
	 */
	private static String getSafeUrl(String key, String streamId, long txTime) {
		String input = new StringBuilder().append(key).append(streamId)
				.append(Long.toHexString(txTime).toUpperCase()).toString();

		String txSecret = null;
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			txSecret = byteArrayToHexString(messageDigest.digest(input
					.getBytes("UTF-8")));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return txSecret == null ? "" : new StringBuilder().append("txSecret=")
				.append(txSecret).append("&").append("txTime=")
				.append(Long.toHexString(txTime).toUpperCase()).toString();
	}

	private static String byteArrayToHexString(byte[] data) {
		char[] out = new char[data.length << 1];

		for (int i = 0, j = 0; i < data.length; i++) {
			out[j++] = DIGITS_LOWER[(0xF0 & data[i]) >>> 4];
			out[j++] = DIGITS_LOWER[0x0F & data[i]];
		}
		return new String(out);
	}

	public static void main(String[] args) {
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date date = sdf.parse("2020-01-18 11:15:15");
			System.out.println(date.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(getPushUrl("r0000004", "01"));
		System.out.println(getLiveUrl("r0000004", "01"));
	}
}
