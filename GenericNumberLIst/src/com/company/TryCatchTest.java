package com.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * User: sanjoy.saha
 * Date: 4/15/14
 * Time: 11:31 AM
 * To change this template use File | Settings | File Templates.
 */
public class TryCatchTest {
    public static void main(String args[]){
        System.out.println("in main ... ");

        InputStream is = null;
        try{
            is = new FileInputStream("in.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
