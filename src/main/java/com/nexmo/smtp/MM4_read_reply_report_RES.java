package com.nexmo.smtp;

public class MM4_read_reply_report_RES extends AbstractMM4Message {
    @Override
    public MM4Type getType() {
        return MM4Type.MM4_READ_REPLY_REPORT_RES;
    }

    public static void main(String[] args) {
        new MM4_read_reply_report_RES().submit();
    }
}
