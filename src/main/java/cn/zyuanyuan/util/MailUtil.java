package cn.zyuanyuan.util;

import cn.zyuanyuan.beans.Mail;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.SimpleEmail;

@Slf4j
public class MailUtil {

    public static boolean send(Mail mail) {

        // TODO
     /*   String from = "1739349840@qq.com";
        int port = 25;
        String host = "smtp.exmail.qq.com";
        String pass ="nrxq jhps rxhx ejjj";
        String nickname = "ZYY";

        HtmlEmail email = new HtmlEmail();
        try {
            email.setHostName(host);
            email.setCharset("UTF-8");
            for (String str : mail.getReceivers()) {
                System.out.println(str);
                email.addTo(str);
            }
            email.setFrom(from, nickname);
            email.setSmtpPort(port);
            email.setAuthentication(from, pass);
            email.setSubject(mail.getSubject());
            email.setMsg(mail.getMessage());
            email.send();
            log.info("{} 发送邮件到 {}", from, StringUtils.join(mail.getReceivers(), ","));
            return true;
        } catch (EmailException e) {
            log.error(from + "发送邮件到" + StringUtils.join(mail.getReceivers(), ",") + "失败", e);
            return false;
        }*/
        String from = "1739349840@qq.com";
        String host = "smtp.qq.com";
        String pass ="nrxqjhpsrxhxejjj";
        String nickname = "ZYY";
        SimpleEmail email=new SimpleEmail();//创建一个HtmlEmail实例对象
        try {
            //填写邮箱服务器，如是QQ邮箱服务器，直接用：smtp.qq.com
            email.setHostName(host);
            email.setCharset("utf-8");
            //设置收件人
            for (String str : mail.getReceivers()) {
                System.out.println(str);
                email.addTo(str);
            }
            //设置发送人邮箱，和用户名
            email.setFrom(from,nickname);
            //配置邮箱加授权码，相当于等于自己的邮箱
            email.setAuthentication(from,pass);
            //使用安全链接
            email.setSSLOnConnect(true);


            //设置邮件的主题
            email.setSubject(mail.getSubject());
            //设置邮件的内容，自行修改动态验证码
            email.setMsg(mail.getMessage());
            //发送
            email.send();

        }catch (Exception e){
            e.printStackTrace();
            //失败
            log.error(from + "发送邮件到" + StringUtils.join(mail.getReceivers(), ",") + "失败", e);
            return false;
        }
        //发送成功
        log.info("{} 发送邮件到 {}", from, StringUtils.join(mail.getReceivers(), ","));
        return true;
    }


}


