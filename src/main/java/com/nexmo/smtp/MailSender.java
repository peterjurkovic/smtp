package com.nexmo.smtp;

import org.springframework.mail.javamail.JavaMailSenderImpl;

public class MailSender extends JavaMailSenderImpl {

    private static final MailSender INSTANCE = new MailSender();

    private MailSender() {
        setHost(System.getProperty("host", "localhost"));
        setPort(intProp("port", 4115));
    }


    public static MailSender getInstance() {
        return INSTANCE;
    }

    private int intProp(String name, int defaultVal){
        String strPort = System.getProperty(name);

        if (strPort != null && strPort.matches("\\d+")){
            return Integer.valueOf(strPort);
        }
        return defaultVal;
    }
}
