package com.irandoo.xhep.base.util;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 * 
 * @author ager
 *
 */
public class SimpleMailSender {
    
    private static Log logger = LogFactory.getLog(SimpleMailSender.class);
    /**
     * 以文本格式发送邮件
     * 
     * @param mailInfo
     *            待发送的邮件的信息
     */
    public boolean sendTextMail(MailSenderInfo mailInfo) {
        // 判断是否需要身份认证
        MyAuthenticator authenticator = null;
        Properties pro = mailInfo.getProperties();
        if (mailInfo.isValidate()) {
            // 如果需要身份认证，则创建一个密码验证器
            authenticator = new MyAuthenticator(mailInfo.getUserName(),
                    mailInfo.getPassword());
        }
        // 根据邮件会话属性和密码验证器构造一个发送邮件的session
        Session sendMailSession = Session
                .getDefaultInstance(pro, authenticator);
        try {
            // 根据session创建一个邮件消息
            Message mailMessage = new MimeMessage(sendMailSession);
            // 创建邮件发送者地址
            Address from = new InternetAddress(mailInfo.getFromAddress());
            // 设置邮件消息的发送者
            mailMessage.setFrom(from);
            // 创建邮件的接收者地址，并设置到邮件消息中
            int num = mailInfo.getToAddress().size();
            InternetAddress[] tos = new InternetAddress[num];
            for(int i=0;i<num;i++){
                tos[i] = new InternetAddress(mailInfo.getToAddress().get(i));
            }
            //Address to = new InternetAddress(mailInfo.getToAddress());
            // Message.RecipientType.TO属性表示接收者的类型为TO
            mailMessage.setRecipients(Message.RecipientType.TO, tos);
            // 设置邮件消息的主题
            mailMessage.setSubject(mailInfo.getSubject());
            // 设置邮件消息发送的时间
            mailMessage.setSentDate(new Date());
            // 设置邮件消息的主要内容
            String mailContent = mailInfo.getContent();
            mailMessage.setText(mailContent);
            // 发送邮件
            Transport.send(mailMessage);
            return true;
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    /**
     * 以HTML格式发送邮件
     * 
     * @param mailInfo
     *            待发送的邮件信息
     */
    public static boolean sendHtmlMail(MailSenderInfo mailInfo) {
        
        logger.info("----send mail to "+mailInfo.getToAddress()+" begin----");
        // 判断是否需要身份认证
        MyAuthenticator authenticator = null;
        Properties pro = mailInfo.getProperties();
        //pro.put("mail.smtp.auth", "true");
        // 如果需要身份认证，则创建一个密码验证器
        if (mailInfo.isValidate()) {
            authenticator = new MyAuthenticator(mailInfo.getUserName(),
                    mailInfo.getPassword());
        }
        // 根据邮件会话属性和密码验证器构造一个发送邮件的session
        Session sendMailSession = Session
                .getDefaultInstance(pro, authenticator);
        try {
            // 根据session创建一个邮件消息
            Message mailMessage = new MimeMessage(sendMailSession);
            
            String nick = "";
            try {
                nick=MimeUtility.encodeText("芜湖人才网");
            }
            catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            // 创建邮件发送者地址
            Address from = new InternetAddress(nick+"<"+mailInfo.getFromAddress()+">");
            // 设置邮件消息的发送者
            mailMessage.setFrom(from);
            // 创建邮件的接收者地址，并设置到邮件消息中
            int num = mailInfo.getToAddress().size();
            InternetAddress[] tos = new InternetAddress[num];
            for(int i=0;i<num;i++){
                tos[i] = new InternetAddress(mailInfo.getToAddress().get(i));
            }
            //Address to = new InternetAddress(mailInfo.getToAddress());
            // Message.RecipientType.TO属性表示接收者的类型为TO
            mailMessage.setRecipients(Message.RecipientType.TO, tos);
            // 设置邮件消息的主题
            mailMessage.setSubject(mailInfo.getSubject());
            // 设置邮件消息发送的时间
            mailMessage.setSentDate(new Date());
            // MiniMultipart类是一个容器类，包含MimeBodyPart类型的对象
            Multipart mp = new MimeMultipart();
            MimeBodyPart mbp = new MimeBodyPart();
            String content = mailInfo.getContent();
            
            String[] attafileNames = mailInfo.getAttachFileNames();
            boolean flag = true;
            if (null != attafileNames && 0 != attafileNames.length) {// 有附件
                long filesize = 0;
                File f = null;
                for (String fileName : attafileNames) {
                    f = new File(fileName);
                    filesize += f.length();
                    // 如果附件大小大于等于系统设置
                    if (filesize >= mailInfo.getAttachFileSize()) {
                        flag = false;
                        break;
                    }
                }
            }
            if(!flag)
            {
                content +="<br>附件太大，请登录系统查收";
            }
            
            mbp.setContent(content, "text/html;charset=UTF-8");
            mp.addBodyPart(mbp);
            

            if (flag && null != attafileNames) {// 有附件
                FileDataSource fds = null;
                for (String fileName : attafileNames) {
                    mbp = new MimeBodyPart();
                    fds = new FileDataSource(fileName); // 得到数据源
                    mbp.setDataHandler(new DataHandler(fds)); // 得到附件本身并至入BodyPart
                    mbp.setFileName(fds.getName()); // 得到文件名同样至入BodyPart
                    mp.addBodyPart(mbp);
                }
            } 
            mailMessage.setContent(mp); // Multipart加入到信件
            // 发送邮件
            Transport.send(mailMessage);
            logger.info("----send mail to "+mailInfo.getToAddress()+" success----");
            return true;
        } catch (MessagingException ex) {
            //ex.printStackTrace();
            logger.info("----send mail to "+mailInfo.getToAddress()+" error----",ex);
        }
        
        return false;
    }
}
