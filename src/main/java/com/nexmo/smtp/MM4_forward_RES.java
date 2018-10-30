package com.nexmo.smtp;

public class MM4_forward_RES extends AbstractMM4Message {

    @Override
    public MM4Type getType() {
        return MM4Type.MM4_FORWARD_RES;
    }

    public static void main(String[] args) {
        new MM4_forward_RES().submit();
    }
}