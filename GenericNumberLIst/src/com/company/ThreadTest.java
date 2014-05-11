package com.company;

/**
 * Created with IntelliJ IDEA.
 * User: sanjoy.saha
 * Date: 4/15/14
 * Time: 5:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class ThreadTest extends Thread implements Runnable{
    public void run(){
        System.out.println("in thread");
    }
}
