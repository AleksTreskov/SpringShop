package ru.gb.shop.inventory.mail.message;

import java.io.InputStream;

public record EmailAttachment(String name, InputStream resource) {
}
