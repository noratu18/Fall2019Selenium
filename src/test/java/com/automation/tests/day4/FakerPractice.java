package com.automation.tests.day4;

import com.github.javafaker.Faker;


public class FakerPractice {
    public static void main(String[] args) {

        // create Faker object

        Faker fakeData = new Faker();

        // I need first Name

        String name = fakeData.name().firstName();
        System.out.println(name);




    }
}
