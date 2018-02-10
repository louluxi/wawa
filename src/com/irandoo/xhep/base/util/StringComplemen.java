package com.irandoo.xhep.base.util;

import java.io.Serializable;

public class StringComplemen implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7301138419523124154L;
	
	public static String StringComplemen(Long id) {
		String roomid =  String.valueOf(id);
		String pad = "0000000" ; 
	    return "r"+pad.substring(0, pad.length() - roomid.length()) + roomid;
	}
}
