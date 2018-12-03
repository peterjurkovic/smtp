package com.nexmo.smtp;

import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

public abstract class AbstractMM4Message implements MimeMessagePreparator, Submitable {

    public abstract MM4Type getType();

    public void prepare(MimeMessage mimeMessage) throws Exception {
        getType().prepare(mimeMessage);
        MimeMessageHelper helper = createHelper(mimeMessage);
        setFromTo(helper);
        helper.setText("");
        printMessage(mimeMessage);
    }

    @Override
    public void submit() {
        MailSender.getInstance().send(this);
        System.out.println("Message " + getType() + " sent");
    }

    void setFromTo(MimeMessageHelper helper) throws MessagingException {
        helper.setFrom(Number.sender(param("from", "19862000842")));
        helper.setTo(Number.recipient(param("to", "12345678")));
    }

    public static String param(String name, String fallback) {
        return System.getProperty(name, fallback);
    }

    protected MimeMessageHelper createHelper(MimeMessage message) throws MessagingException {
        return new MimeMessageHelper(message);
    }

    void printMessage(MimeMessage message) {
        if (System.getProperty("verbose") != null) {
            try {
                MimeMessage copy = new MimeMessage(message);
                copy.writeTo(System.out);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
