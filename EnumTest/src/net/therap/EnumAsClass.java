package net.therap;

/**
 * Created with IntelliJ IDEA.
 * User: sanjoy.saha
 * Date: 4/30/14
 * Time: 3:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class EnumAsClass {
    public static final EnumAsClass BIG          = new EnumAsClass("BIG", 0);
    public static final EnumAsClass HUGE         = new EnumAsClass("HUGE", 1);
    public static final EnumAsClass OVERWHELMING = new EnumAsClass("OVERWHELMING", 2);

    public EnumAsClass(String enumName, int index) {

    }

    public static void main(String[] args){
        System.out.println(EnumAsClass.BIG);
    }
}
