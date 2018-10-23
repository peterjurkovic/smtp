package com.nexmo.smtp;

import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

import javax.mail.internet.MimeMessage;

public class SimpleTextMail implements MimeMessagePreparator {


    @Override
    public void prepare(MimeMessage mimeMessage) throws Exception {
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
        helper.setFrom("test@test.tld");
        helper.setTo("test@test.tld");
        helper.setText("body text");
        helper.addInline("company-logo", new ClassPathResource("nexmo-logo.png"));
    }
}
