package com.example.demo_Jenkins.utility;

public class maskEmail {

    public static String mask(String email) {

        if (email == null || email.isBlank() || !email.contains("@")) {
            return email;
        }

        int atIndex = email.indexOf("@");

        String localPart = email.substring(0, atIndex);
        String domainPart = email.substring(atIndex);

        if (localPart.length() <= 2) {
            return localPart.charAt(0) + "****" + domainPart;
        }

        return "***"+localPart.substring(2, 4) + "*****" + domainPart;


    }
}
