package com.automation.tests.day13;

import org.testng.annotations.Test;

public class SystemProperties {

    @Test
    public void test(){
        ///Users/Baktyiar/IdeaProjects/Fall2019Selenium/pom.xml
        //System.getProperty("user.dir") + "/pom.xml"
        System.out.println(System.getProperty("user.dir"));//user directory
        System.out.println(System.getProperty("os.name")); //
        //flexible path to download folder
        //System.getProperty("user.home") + "/Downloads"
        System.out.println(System.getProperty("user.home"));
        //for windows use // instead of /

        String pathToDownloads = System.getProperty("user.home") + "/Downloads";
        System.out.println(pathToDownloads);

        System.out.println(System.getProperty("os.arch"));

        //https://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html




    }
}
