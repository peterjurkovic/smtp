package com.nexmo.smtp;

import org.apache.commons.io.IOUtils;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.subethamail.smtp.MessageContext;
import org.subethamail.smtp.MessageHandler;
import org.subethamail.smtp.MessageHandlerFactory;
import org.subethamail.smtp.RejectException;
import org.subethamail.smtp.TooMuchDataException;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.Enumeration;
import java.util.Properties;

public class MmsMessageHandlerFactory implements MessageHandlerFactory {

    @Override
    public MessageHandler create(MessageContext ctx) {
        return new Handler(ctx);
    }

    static class Handler implements MessageHandler {

        MessageContext ctx;

        public Handler(MessageContext ctx) {
            this.ctx = ctx;
        }

        @Override
        public void from(String from) throws RejectException {
            System.out.println("FROM:" + from);
        }

        @Override
        public void recipient(String recipient) throws RejectException {
            System.out.println("RECIPIENT:" + recipient);
        }

        @Override
        public void data(InputStream data) throws RejectException, TooMuchDataException, IOException {
            Session session = Session.getInstance(new Properties());
            try {
                MimeMessage message = new MimeMessage(session, data);
                Enumeration en = message.getAllHeaderLines();
                while (en.hasMoreElements()){
                    System.out.println(en.nextElement());
                }
                System.out.println("Data content type: "+message.getDataHandler().getContentType());

            } catch (MessagingException e) {
                e.printStackTrace();
            }

//            System.out.println("MAIL DATA");
//            System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");
//            System.out.println(this.convertStreamToString(data));
//            System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");
        }

        @Override
        public void done() {
            System.out.println("Finished");
        }

        public String convertStreamToString(InputStream is) {

            try {
                return IOUtils.toString(is, "UTF-8");
            } catch (IOException e) {
                return "ERROR " + e.getMessage();
            }
        }
    }
}

