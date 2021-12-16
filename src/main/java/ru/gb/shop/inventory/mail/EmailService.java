package ru.gb.shop.inventory.mail;

import ru.gb.shop.inventory.mail.message.AttachmentMailMessage;
import ru.gb.shop.inventory.mail.message.MailMessage;

public interface EmailService {
    void send(MailMessage message);
    void send(AttachmentMailMessage message);
}
