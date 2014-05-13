package net.therap;


class A {
    int a = 9;

    public void aVoid() {
        System.out.println("IN class a");
    }
}

class B extends A{
    int a=90;

    @Override
    public void aVoid() {
        System.out.println("IN claas B");
    }

    public static void main(String[]args){
        A aa = new B();
        System.out.println(aa.a);
        aa.aVoid();
    }
}



