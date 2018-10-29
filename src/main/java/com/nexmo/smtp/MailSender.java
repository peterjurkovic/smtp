package com.nexmo.smtp;

import org.springframework.mail.javamail.JavaMailSenderImpl;

public class MailSender extends JavaMailSenderImpl {

    private static final MailSender INSTANCE = new MailSender();

    private MailSender() {
        setHost("localhost");
        setPort(4116);
    }


    public static MailSender getInstance() {
        return INSTANCE;
    }
}
