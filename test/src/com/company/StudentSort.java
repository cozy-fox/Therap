package com.company;

import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: rashedul.hasan
 * Date: 5/1/14
 * Time: 2:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class StudentSort implements Comparator <Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getRoll()-o2.getRoll();
        //return o1.getName().compareTo(o2.getName());
    }
}
