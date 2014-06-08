package net.therap.util;

import net.therap.domain.User;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: sanjoy.saha
 * Date: 5/21/14
 * Time: 3:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class DateHelper{
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

    public static String getDayNameFromDateString(String addedDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("EEE");
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH).parse(addedDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String dayString = formatter.format(date);
        return dayString;
    }

    public static String getDayNameFromDate(Date addedDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("EEE");
        String dayString = formatter.format(addedDate);
        return dayString;
    }

    public static String getAuthenticatedUserName(HttpSession session) {
        User authenticatedUser = (User) session.getAttribute("authenticatedUser");
        return authenticatedUser.getUserName();
    }

    public static String getAuthenticatedUserType(HttpSession session) {
        User authenticatedUser = (User) session.getAttribute("authenticatedUser");
        return authenticatedUser.getUserType();
    }
}
