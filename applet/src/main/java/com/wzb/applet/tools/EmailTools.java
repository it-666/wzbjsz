package com.wzb.applet.tools;
import java.util.Date;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Component;

/**
 *
 * 邮箱处理类
 * @author 邬志斌 <br>
 * 2018年3月22日 下午2:06:12
 */
@Component
public class EmailTools {
    public static String myEmailAccount = "823120827@qq.com";
    public static String myEmailPassword = "xxxxxxxx";
    public static String myEmailSMTPHost = "smtp.qq.com";

    /**
     *
     * @param receiveMailAccount 对方的邮箱
     * @param recipients  对方的姓名
     * @param emSubject  邮箱主题
     * @param embody   邮箱内容
     * @throws Exception
     */
    public static synchronized void  email(String receiveMailAccount,String recipients,String emSubject,String embody) throws Exception{
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.smtp.host", myEmailSMTPHost);
        props.setProperty("mail.smtp.auth", "true");
        final String smtpPort = "465";
        props.setProperty("mail.smtp.port", smtpPort);
        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.socketFactory.port", smtpPort);
        Session session = Session.getInstance(props);
        session.setDebug(true);
        MimeMessage message = createMimeMessage(session, myEmailAccount, receiveMailAccount, recipients, emSubject, embody);
        Transport transport = session.getTransport();
        transport.connect(myEmailAccount, myEmailPassword);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }

    /**
     *
     *
     * @param session 和服务器交互的会话
     * @param sendMail 发件人邮箱
     * @param receiveMail 收件人邮箱
     * @return
     * @throws Exception
     */
    public static MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail,String recipients,String emSubject,String embody) throws Exception {
        MimeMessage message = new MimeMessage(session);
        //  From: 发件人
        message.setFrom(new InternetAddress(sendMail, "技术栈", "UTF-8"));
        //  To: 收件人
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, recipients, "UTF-8"));
        //  Subject: 邮件主题
        message.setSubject(emSubject, "UTF-8");
        //  Content: 邮件正文（可以使用html标签）
        message.setContent(embody, "text/html;charset=UTF-8");
        //  设置发件时间
        message.setSentDate(new Date());
        message.saveChanges();

        return message;
    }

}
