package com.company;

/**
 * Created with IntelliJ IDEA.
 * User: rashedul.hasan
 * Date: 5/1/14
 * Time: 2:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class Test1 implements Runnable {

    String name;
    Test2 test2;

    public Test1(String s) {
        this.name = s;
    }

    public Test1(Test2 test2,String s) {
        this.test2 = test2;
        this.name=s;
    }

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            test2.add(i,name);
            test2.add1(i,name);
        }
    }

}
