package ru.gb.shop.inventory.mail;

import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import ru.gb.shop.inventory.exception.MailSenderException;
import ru.gb.shop.inventory.mail.message.AttachmentMailMessage;
import ru.gb.shop.inventory.mail.message.MailMessage;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
@Slf4j
public class EmailServiceImpl implements EmailService {
    private final JavaMailSender sender;

    public EmailServiceImpl(JavaMailSender sender) {
        this.sender = sender;
    }

    @Override
    public void send(MailMessage message) {
        log.info("Preparing mail message to be sent.");
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(message.from());
        simpleMailMessage.setTo(message.to());
        simpleMailMessage.setSubject(message.subject());
        simpleMailMessage.setText(message.text());
        try {


            sender.send(simpleMailMessage);
        } catch (MailException e) {
            log.debug("While sending the mail the error occurred");
            log.debug("Mail message:{}", simpleMailMessage);
            throw new MailSenderException("Something went wrong while sending the mail", e);
        }
    }

    @Override
    public void send(AttachmentMailMessage message) {
        MimeMessage mimeMessage = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        try {


            helper.setFrom(message.from());
            helper.setTo(message.to());
            helper.setSubject(message.subject());
            helper.setText(message.text());
            helper.addAttachment(message.attachment().name(), () -> message.attachment().resource());
            sender.send(mimeMessage);
        } catch (MessagingException e) {
            log.debug("While sending the mime-mail the error occurred");
            log.debug("Mime-message:{}", mimeMessage);
            throw new MailSenderException("Something went wrong while sending the mime-message", e);
        }catch (MailException e){
            log.debug("While sending the mail with mime-message the error occurred");
            log.debug("Mail message:{}", mimeMessage);
            throw new MailSenderException("Something went wrong while sending the mail", e);
        }
    }
}
