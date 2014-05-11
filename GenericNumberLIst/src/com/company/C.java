package com.company;

class c1
{
    public static void main(String a[])
    {
        c1 ob1=new c1();
        Object ob2=ob1;
        System.out.println(ob2 instanceof Object);
        System.out.println(ob2 instanceof c1);

        if("String".trim() == "String")
            System.out.println("Equal");
        else
            System.out.println("Not Equal");
    }
}