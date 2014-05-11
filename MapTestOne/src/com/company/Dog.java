package com.company;

/**
 * Created with IntelliJ IDEA.
 * User: sanjoy.saha
 * Date: 4/8/14
 * Time: 3:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class Dog {
    String name="";
    public Dog(String s){ this.name = s; }
    public boolean equals(Object o){
        if ( (o instanceof Dog) &&
                (((Dog)o).name==this.name) ){
            return true;
        } else{
            return false;
        }
    }
public int hashCode(){ return name.length()+9; }
}
