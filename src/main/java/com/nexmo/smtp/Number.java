package com.nexmo.smtp;

public class Number {

    private static final String PLUS = "+";
    private static final String SUFFIX = "/TYPE=PLMN";

    private Number() {
    }

    public static String sender(String number) {
        return toEmail(number, "recipient.com");
    }

    public static String recipient(String number) {
        return toEmail(number, "reciever.com");
    }

    private static String toEmail(String number, String domain) {

        if (number.contains("@")) {
            return number;
        }

        if (!number.trim().startsWith("+"))
            number = PLUS + number;

        return String.format("%s%s@%s", number, SUFFIX, domain);
    }

}
