package com.company;

/**
 * Created with IntelliJ IDEA.
 * User: rashedul.hasan
 * Date: 5/1/14
 * Time: 1:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class Student implements Comparable<Student>{

    private String name;
    private int roll;

    private Student(String name, int roll) {
        this.name = name;
        this.roll = roll;
    }

    @Override
    public int compareTo(Student o) {
        return (this.roll-o.roll);
    }

    public String getName(){
        return name;
    }
    public int getRoll(){
        return roll;
    }

}
