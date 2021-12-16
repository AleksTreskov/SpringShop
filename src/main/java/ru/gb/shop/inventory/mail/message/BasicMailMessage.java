package ru.gb.shop.inventory.mail.message;

public record BasicMailMessage(String from, String to, String subject, String text) implements MailMessage {
}
