package com.nexmo.smtp;

import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

public class MM4_forward_REQ extends AbstractMM4Message {


    @Override
    public MM4Type getType() {
        return MM4Type.MM4_FORWARD_REQ;
    }

    @Override
    public void prepare(MimeMessage mimeMessage) throws Exception {
        getType().prepare(mimeMessage);
        MimeMessageHelper helper = createHelper(mimeMessage);
        setFromTo(helper);
        helper.setText("body text");
        helper.addAttachment("company-logo.png", new ClassPathResource("nexmo-logo.png"));
    }

    @Override
    protected MimeMessageHelper createHelper(MimeMessage message) throws MessagingException {
        return new MimeMessageHelper(message, true, "UTF-8");
    }

    public static void main(String[] args) {
        new MM4_forward_REQ().submit();
    }
}
