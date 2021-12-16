package ru.gb.shop.inventory.mail.message;

import java.io.InputStream;

public interface AttachmentMailMessage extends MailMessage{
    EmailAttachment attachment();
}
