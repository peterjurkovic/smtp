package com.nexmo.smtp;

public class Client {

    public static void main(String[] args) {

        MailSender.getInstance().send(new ImageMail());
        System.out.println("Message sent");
    }
}
