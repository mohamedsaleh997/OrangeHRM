package com.testwebsite.utils;

import com.github.javafaker.Faker;

public class FakerUtil {

    private static final Faker faker = new Faker();

    private static String userName = generateUserName() ;


    public static String generateUserName () {
        return faker.name().username() + faker.number().digits(3);
    }

    public static String getUserName(){
        return userName;
    }
}
