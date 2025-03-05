package com.testwebsite.utils;

import org.testng.asserts.SoftAssert;

public class CustomSoftAssertions extends SoftAssert {

    public static CustomSoftAssertions softAssertions = new CustomSoftAssertions();

    public static void customAssertAll(){

        try{softAssertions.assertAll();

        }
        catch(Exception e){

            System.out.println("Custom Soft Assertion Failed");

        }



    }


}
