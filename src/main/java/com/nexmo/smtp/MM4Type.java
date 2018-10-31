package com.nexmo.smtp;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public enum MM4Type {

    MM4_FORWARD_REQ("MM4_forward.REQ", MM4_forward_REQ::new) {
        @Override
        public void prepare(MimeMessage message) throws MessagingException {
            setCommonHeaders(message);
            message.setHeader("X-Mms-Ack-Request", System.getProperty("ac", "Yes"));
        }
    },

    MM4_FORWARD_RES("MM4_forward.RES", MM4_forward_RES::new) {
        @Override
        public void prepare(MimeMessage message) throws MessagingException {
            setResponseCommonHeaders(message);
        }
    },

    MM4_DELIVERY_REPORT_REQ("MM4_delivery_report.REQ", MM4_delivery_report_REQ::new) {
        @Override
        public void prepare(MimeMessage message) throws MessagingException {
            setCommonHeaders(message);
            message.setHeader("X-Mms-MM-Status-Code", System.getProperty("messageStatus", "Forwarded"));
        }
    },

    MM4_DELIVERY_REPORT_RES("MM4_delivery_report.RES", MM4_delivery_report_RES::new) {
        @Override
        public void prepare(MimeMessage message) throws MessagingException {
            setResponseCommonHeaders(message);
        }
    },

    MM4_READ_REPLY_REPORT_REQ("MM4_read_reply_report.REQ", MM4_read_reply_report_REQ::new) {
        @Override
        public void prepare(MimeMessage message) throws MessagingException {
            setCommonHeaders(message);
            message.setHeader("X-Mms-Read-Status", "Read");
        }
    },

    MM4_READ_REPLY_REPORT_RES("MM4_read_reply_report.RES", MM4_read_reply_report_RES::new) {
        @Override
        public void prepare(MimeMessage message) throws MessagingException {
            setResponseCommonHeaders(message);
        }
    };

    private final String value;
    private final Supplier<Submitable> message;

    MM4Type(String id, Supplier<Submitable> message) {
        this.value = id;
        this.message = message;
    }

    public String getValue() {
        return value;
    }

    public void submit(){
        message.get().submit();
    }

    public abstract void prepare(MimeMessage message) throws Exception;


    void setCommonHeaders(MimeMessage message) throws MessagingException {
        message.setHeader("X-Mms-3GPP-Version", System.getProperty("version","1.0"));
        message.setHeader("X-Mms-Message-ID", System.getProperty("messageId","messageId"));
        message.setHeader("X-Mms-Transaction-ID", System.getProperty("transactionId", "transactionId"));
        message.setHeader("X-Mms-Message-Type", this.value);
    }

    void setResponseCommonHeaders(MimeMessage message) throws MessagingException {
        setCommonHeaders(message);
        message.setHeader("X-Mms-Request-Status-Code", System.getProperty("requestStatus","0"));
    }

    public static String printTypes() {
        return Arrays.stream(values())
                    .map(MM4Type::name)
                    .collect(Collectors.joining(","));
    }
}