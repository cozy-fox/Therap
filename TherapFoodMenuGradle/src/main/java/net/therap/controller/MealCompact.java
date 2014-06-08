package net.therap.controller;

/**
 * Created with IntelliJ IDEA.
 * User: sanjoy.saha
 * Date: 5/22/14
 * Time: 9:30 AM
 * To change this template use File | Settings | File Templates.
 */
public class MealCompact {
    private String date;
    private String day;
    private String breakfastString;
    private String lunchString;

    public MealCompact() {
        breakfastString = "";
        lunchString = "";
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getBreakfastString() {
        return breakfastString;
    }

    public void setBreakfastString(String breakfastString) {
        this.breakfastString = breakfastString;
    }

    public String getLunchString() {
        return lunchString;
    }

    public void setLunchString(String lunchString) {
        this.lunchString = lunchString;
    }
}
