package com.company;

public class StaticTest {
    static {
        System.out.println("Hello");
    }

    public void print() {
        System.out.println("Print");
    }
    public static void main(String args []) {
        StaticTest st1 = new StaticTest();
        st1.print();
        StaticTest st2 = new StaticTest();
        st2.print();
    }
}