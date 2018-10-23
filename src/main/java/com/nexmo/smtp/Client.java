package com.nexmo.smtp;

public class Client {

    public static void main(String[] args) {

        MailSender.getInstance().send(new SimpleTextMail());
        System.out.println("Message sent");
    }
}
