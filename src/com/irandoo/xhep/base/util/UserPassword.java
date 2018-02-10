package com.irandoo.xhep.base.util;


/**
 * 
 * @author ager
 * @version 1.0
 */
public class UserPassword {
    
    private final static String PASS_KEY ="whrspass";
    
    public static String MD5Encode(String origin){
        String res = MD5.MD5Encode(MD5.MD5Encode(origin+PASS_KEY)+PASS_KEY);
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(UserPassword.MD5Encode("111111"));
    }

}
