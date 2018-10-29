package com.nexmo.smtp;

import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

import javax.mail.internet.MimeMessage;

public class MM4_forward_REQ implements MimeMessagePreparator {


    @Override
    public void prepare(MimeMessage mimeMessage) throws Exception {
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
        helper.setFrom("test@test.tld");
        helper.setTo("test@test.tld");
        helper.setText("body text");
        helper.addAttachment("company-logo.png", new ClassPathResource("nexmo-logo.png"));
        mimeMessage.setHeader("X-Mms-Message-ID", "messageId");
        mimeMessage.setHeader("X-Mms-Transaction-ID", "transactionId");
        mimeMessage.setHeader("X-Mms-Message-Type", "MM4_forward.REQ");
        mimeMessage.setHeader("X-Mms-Ack-Request", "Yes");
    }

    public static void main(String[] args) {

        MailSender.getInstance().send(new MM4_forward_REQ());
        System.out.println("Message MM4_forward_REQ sent");
    }
}
