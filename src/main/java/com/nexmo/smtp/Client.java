package com.nexmo.smtp;

public class Client {

    public static void main(String[] args) {
        String type;

        if (args.length == 1){
            type = args[0].toUpperCase();
        }else {
            type = System.getProperty("type", MM4Type.MM4_FORWARD_REQ.name());
        }

        try {
            System.out.println("Sending " + type);
            MM4Type.valueOf(type).submit();
        } catch (IllegalArgumentException e){
            System.out.println("Invalid type: " + type +
                               " Use -Dtype param and one of [" + MM4Type.printTypes() + "]");
        } catch (Exception e){
            System.out.println("Failed to send " + type);
        }
    }
}
