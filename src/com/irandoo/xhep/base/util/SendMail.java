package com.irandoo.xhep.base.util;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
/**
 * 
 * @author ager
 * @version 1.0
 */
@Component
public class SendMail {
    
    public void sendMail4ChagngeMail(String changmail,String vercode) {
        Mail mail = new Mail();
        List<String> mails = Arrays.asList(new String[]{changmail});
        mail.setMailAddress(mails);
        mail.setName("全科社工");
        StringBuilder sb = new StringBuilder();
        sb.append("尊敬的用户您好");
        sb.append("<br>");
        sb.append("您的验证码为："+vercode+",本验证码2分钟内有效");
        sb.append("<br>");
        mail.setContent(sb.toString());
        
        try {
            MailQuene.getInstance().getMailQuene().put(mail);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }

    public void sendMessageMail(String toEmail,String title,String content,String answer){
        Mail mail = new Mail();
        List<String> mails = Arrays.asList(new String[]{toEmail});
        mail.setMailAddress(mails);
        mail.setName(title);
        StringBuilder sb = new StringBuilder();
        sb.append("尊敬的用户您好,您在全科社工提问：");
        sb.append("<br>");
        sb.append("&nbsp;&nbsp;&nbsp;&nbsp;" + content);
        sb.append("<br>");
        sb.append("回复如下：<br>");
        sb.append("&nbsp;&nbsp;&nbsp;&nbsp;" + answer);
        mail.setContent(sb.toString());
        
        try {
            MailQuene.getInstance().getMailQuene().put(mail);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public void sendResumeVerifyMail(String toEmail,String title,String content){
        Mail mail = new Mail();
        List<String> mails = Arrays.asList(new String[]{toEmail});
        mail.setMailAddress(mails);
        mail.setName(title);
        StringBuilder sb = new StringBuilder();
        sb.append("尊敬的用户您好,您在全科社工创建的简历存在如下问题：");
        sb.append("<br>");
        sb.append("&nbsp;&nbsp;&nbsp;&nbsp;" + content);
        mail.setContent(sb.toString());
        
        try {
            MailQuene.getInstance().getMailQuene().put(mail);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
