package net.therap;

/**
 * Created with IntelliJ IDEA.
 * User: sanjoy.saha
 * Date: 5/13/14
 * Time: 10:26 AM
 * To change this template use File | Settings | File Templates.
 */
public class TestQ1 {
    public static void main(String args[]) {
        String s1 = "abc";
        String s2 = "abc";

        if (s1 == s2)
            System.out.println(1);
        else
            System.out.println(2);
        if (s1.equals(s2))
            System.out.println(3);
        else
            System.out.println(4);
    }
}
