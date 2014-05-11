package com.company;

class Test1{
    public static void main(String [] args){
        Base b = new Subclass();
        System.out.println(b.x);
        System.out.println(b.method());

        Object o;
        String s = "abcd";
        o = s;
        System.out.println(o);

        int sss=1;
        System.out.println(sss);

        System.out.println(Thread.MIN_PRIORITY);
    }
}
class Base{
    int x = 2;
    int method(){
        return x;
    }
}
class Subclass extends Base{
    int x = 3;
    int method(){
        return x;
    }
}