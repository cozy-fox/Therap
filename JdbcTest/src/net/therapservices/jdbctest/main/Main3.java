package net.therapservices.jdbctest.main;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: sanjoy.saha
 * Date: 4/30/14
 * Time: 5:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main3 {
    public static void main (String args[]) {
        try {
            Main2 obj = new Main2();
            Method m = obj.getClass().getMethod("runMain2", null);
            m.invoke(obj, null);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
