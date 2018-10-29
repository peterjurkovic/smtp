package com.nexmo.smtp;

import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

import javax.mail.internet.MimeMessage;

public class MM4_forward_RES implements MimeMessagePreparator {


    /**
     *
     * X-Mms-3GPP-Version
     X-Mms-Message-Type
     X-Mms-Transaction-ID
     X-Mms-Message-ID
     X-Mms-Request-Status-Code

     * @param mimeMessage
     * @throws Exception
     */
    @Override
    public void prepare(MimeMessage mimeMessage) throws Exception {
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        helper.setFrom("test@test.tld");
        helper.setTo("test@test.tld");
        helper.setText("");
        mimeMessage.setHeader("X-Mms-Message-ID", "messageId");
        mimeMessage.setHeader("X-Mms-Transaction-ID", "transactionId");
        mimeMessage.setHeader("X-Mms-Message-Type", "MM4_forward.RES");
        mimeMessage.setHeader("X-Mms-Request-Status-Code", "statusCode");
    }

    public static void main(String[] args) {

        MailSender.getInstance().send(new MM4_forward_RES());
        System.out.println("Message  MM4_forward_RES sent");
    }
}