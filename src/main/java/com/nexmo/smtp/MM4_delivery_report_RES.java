package com.nexmo.smtp;

public class MM4_delivery_report_RES extends AbstractMM4Message {

    @Override
    public MM4Type getType() {
        return MM4Type.MM4_DELIVERY_REPORT_RES;
    }

    public static void main(String[] args) {
        new MM4_delivery_report_RES().submit();
    }
}
