package cn.yoursky.jpademo.entity.mail;

import cn.yoursky.jpademo.configuration.PropertiesUtil;
import lombok.Data;

import java.util.List;
import java.util.Properties;

@Data
public class MailSender {
    //邮件实体
    private static MailEntity mailEntity = new MailEntity();
    /**
     * 设置邮件标题
     */
    public MailSender title (String title) {
        mailEntity.setTitle(title);
        return this;
    }
    /**
     * 设置邮件内容
     */
    public MailSender content (String content) {
        mailEntity.setContent(content);
        return this;
    }
    /**
     * 设置邮件格式
     */
    public MailSender contentType (String contentType) {
        mailEntity.setContentType(contentType);
        return this;
    }
    /**
     * 设置目标邮件地址
     */
    public MailSender targets (List<String> list) {
        mailEntity.setList(list);
        return this;
    }
    /**
     * 发送邮件
     */
    public void send () {
        mailEntity.setContentType("/text/html;charset=UTF-8");
        PropertiesUtil propertiesUtil = new PropertiesUtil("mail");
        Properties properties = new Properties();
        properties.put("mail.smtp.auth","true");
    }
}
