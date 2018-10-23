package com.nexmo.smtp;

import org.subethamail.smtp.server.SMTPServer;

public class Server {

    public static void main(String[] args) {
        SMTPServer smtpServer = new SMTPServer(new MmsMessageHandlerFactory());
        smtpServer.setPort(25000);
        smtpServer.start();


    }
}
