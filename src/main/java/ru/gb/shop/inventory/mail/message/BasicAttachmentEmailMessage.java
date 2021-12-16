package ru.gb.shop.inventory.mail.message;

import java.io.InputStream;

public record BasicAttachmentEmailMessage(String from,
                                          String to,
                                          String subject,
                                          String text,
                                          EmailAttachment emailAttachment) implements AttachmentMailMessage {
    @Override
    public EmailAttachment attachment() {
        return null;
    }
}
