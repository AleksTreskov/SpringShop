package ru.gb.shop.inventory.mail;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

//@Configuration
public class MailConfig {
 //   @Bean
    public JavaMailSenderImpl javaMailSender() {
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setHost("smtp.google.com");
        sender.setPort(587);
        sender.setUsername("<changeit>");
        sender.setPassword("<changeit>");
        Properties props = sender.getJavaMailProperties();
        props.put("mail.transport.protocol","smtp");
        props.put("mail.smtp.auth","true");
        props.put("mail.smpt.starttls.enable","true");
        props.put("mail.debug","true");
        return sender;
    }
}
