package com.irandoo.xhep.base.util;

import java.util.List;

/**
 * 
 * @author ager
 *
 */
public class MailSend {

	private static MailSend mailSend = new MailSend();

	private MailSenderInfo mailInfo;

	private MailSend() {
		mailInfo = new MailSenderInfo();
		mailInfo.setMailServerHost("smtp.ym.163.com");
		mailInfo.setMailServerPort("25");
		mailInfo.setValidate(true);
		mailInfo.setUserName("dingyi.tang@can2do.com");
		mailInfo.setPassword("123456123");//
		mailInfo.setFromAddress("dingyi.tang@can2do.com");
	}

	public static MailSend getInstance() {
		return mailSend;
	}

	public void sendMail(List<String> address, String subject, String content,
			String[] attFilePath) {
		mailInfo.setToAddress(address);
		mailInfo.setSubject(subject);
		mailInfo.setContent(content);
		mailInfo.setAttachFileNames(attFilePath);
		SimpleMailSender.sendHtmlMail(mailInfo);//
	}

}
