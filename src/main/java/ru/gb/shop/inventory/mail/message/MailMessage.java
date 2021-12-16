package ru.gb.shop.inventory.mail.message;

public interface MailMessage {
    String from();
    String to();
    String subject();
    String text();
}
