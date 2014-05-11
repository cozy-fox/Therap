package com.company;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created with IntelliJ IDEA.
 * User: sanjoy.saha
 * Date: 4/15/14
 * Time: 12:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class TryCatchTest2 {
    public static void main(String args[]){
        RandomAccessFile rf;
        try {
            rf = new RandomAccessFile("in.txt", "r");
        }  catch (IOException e){
            System.out.println("in io exception");
            e.printStackTrace();
        }
        String s = "abcd";
        s.charAt(3);

    }
}
