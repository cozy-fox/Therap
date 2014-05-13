package net.therap.test;

/**
 * Created with IntelliJ IDEA.
 * User: sanjoy.saha
 * Date: 5/7/14
 * Time: 4:41 PM
 * To change this template use File | Settings | File Templates.
 */
import java.io.FileInputStream;
import java.util.Properties;

public class Test2 {
    public static void main(String[] args)
            throws Exception {

        // set up new properties object
        // from file "myProperties.txt"
        FileInputStream propFile =
                new FileInputStream( "myProperties.txt");
        Properties p =
                new Properties(System.getProperties());
        p.load(propFile);

        // set the system properties
        System.setProperties(p);
        // display new properties
        System.getProperties().list(System.out);
    }
}