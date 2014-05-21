package net.therap.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: sanjoy.saha
 * Date: 5/21/14
 * Time: 3:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class HelperClass {
    public static long[] convertStringArraytoLong(String[] stringArray) {
        long[] returnLongArray = new long[stringArray.length];

        int i = 0;
        for(String strLong: stringArray) {
            returnLongArray[i++] = Long.parseLong(strLong);
        }
        return returnLongArray;
    }

    public static String getTodaysDateOnly() {
        Date today = new Date();
        String todayString= new SimpleDateFormat("yyyy-MM-dd").format(today);
        return todayString;
    }
}
