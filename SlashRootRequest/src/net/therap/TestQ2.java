package net.therap;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created with IntelliJ IDEA.
 * User: sanjoy.saha
 * Date: 5/13/14
 * Time: 10:28 AM
 * To change this template use File | Settings | File Templates.
 */
public class TestQ2 {
    public static void main(String args[]) {
        cat(new File("abc.txt"));
    }
    public static void cat(File file) {
        RandomAccessFile input = null;
        String line = null;
        try {
            input = new RandomAccessFile(file, "r");
            while ((line = input.readLine()) != null ) {
                System.out.println(line);
            } return;
        } catch ( FileNotFoundException e ) {
            e.printStackTrace();
        } catch ( IOException e ) {
            e.printStackTrace();
        } finally {
            if (input != null ) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
