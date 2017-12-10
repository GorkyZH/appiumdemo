package com.gorky.appiumdemo;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        AppiumTest appiumtest = new AppiumTest();
        appiumtest.login();
        appiumtest.todayCalling();
    }
}
