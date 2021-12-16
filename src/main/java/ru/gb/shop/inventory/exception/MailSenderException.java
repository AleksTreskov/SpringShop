package ru.gb.shop.inventory.exception;

public class MailSenderException extends RuntimeException{
    public MailSenderException(String message) {
        super(message);
    }

    public MailSenderException(Throwable cause) {
        super(cause);
    }

    public MailSenderException(String s, Throwable cause) {
    }
}
