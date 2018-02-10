package com.irandoo.app.interf.util;

import abu.crypto.Base64Util;

import com.irandoo.base.crypto.Randoo3DES;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    Randoo3DES randoo3Des = new Randoo3DES();
        /* 加密 */
        try {
			System.out.println(Base64Util.encode(randoo3Des.encrypt("17761727347".getBytes())));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        /* 解密 */
        String cypher = "B7qU451oSyBnj7Wqhe57P2nEBMy16TG5UUSf5oDWdHcV6R/WYfo+5Q==";
        System.out.println(new String(randoo3Des.decrypt(Base64Util.decode(cypher))));
	}

}
