package com.irandoo.xhep.base.util;

import javax.mail.*;
/**
 * 
 * @author ager
 *
 */ 
public class MyAuthenticator extends Authenticator{
	String userName=null;
	String password=null;
	 
	public MyAuthenticator(){
	}
	public MyAuthenticator(String username, String password) { 
		this.userName = username; 
		this.password = password; 
	} 
	protected PasswordAuthentication getPasswordAuthentication(){
		return new PasswordAuthentication(userName, password);
	}
}
 
