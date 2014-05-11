package com.company;

/**
 * Created with IntelliJ IDEA.
 * User: sanjoy.saha
 * Date: 4/15/14
 * Time: 5:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class ThreadMain {
    public static void  main(String args[]){
        ThreadTest t_1 = new ThreadTest();
        ThreadTest t_2 = new ThreadTest();

        t_1.start();
        t_2.start();
    }
}
