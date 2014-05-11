package com.company;

/**
 * Created with IntelliJ IDEA.
 * User: rashedul.hasan
 * Date: 5/1/14
 * Time: 4:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class Test2 {

    int val, val1;

    public void add(int val,String name) {
        this.val += val;
        System.out.println(name + " add value is " + this.val + " "  + val);
    }

    public void add1(int val,String name) {
        this.val1 += val;
        System.out.println(name + " add1 value is " + this.val1 + " "  + val);
    }
}
