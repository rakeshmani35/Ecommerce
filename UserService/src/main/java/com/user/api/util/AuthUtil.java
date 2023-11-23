package com.user.api.util;

import java.util.Random;

public class AuthUtil {

    int lengthOfString = 0;

    public AuthUtil(int lengthOfString){
        this.lengthOfString = lengthOfString;
    }

    public String generateRandomAlphabeticString(){
        int leftLimit = 97; // char 'a'
        int rightLimit = 122; // char 'Z'
        int size = 20;

        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit)
                                        .limit(size)
                                        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                                        .toString();
        System.out.println(generatedString);

        return generatedString;
    }

    public String generateRandomAlphaNumericString(){
        int leftLimit = 48; // char '0'
        int rightLimit = 122; // char 'Z'
        int size = 20;

        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit)
                                        .filter(i -> (i <=57 || i >=65) && (i <= 90 || i >= 97))
                                        .limit(size)
                                        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                                        .toString();
        System.out.println(generatedString);

        return generatedString;
    }

}
