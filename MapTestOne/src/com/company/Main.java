package com.company;

import java.util.HashMap;
import java.util.Map;

enum Pets{ DOG, CAT, HORSE }

public class Main {

    public static void main(String[] args) {
        Map<Object, Object> m = new HashMap<Object, Object>();

        m.put("bbb1", new Dog("baiko"));
        m.put("bbb2", Pets.DOG );
        m.put(Pets.CAT, "CAT key" );
        Dog d1 = new Dog("clover");
        m.put (d1, "Dog key");
        m.put(new Cat(), "Cat Key");

        System.out.println(m.get("bbb1"));
        String bbb2 = "bbb2";
        System.out.println(m.get(bbb2));
        Pets p = Pets.CAT;
        System.out.println(m.get(p));
        System.out.println(m.get(d1));
        System.out.println(m.get(new Cat()));
        System.out.println(m.size());
    }
}


class Cat {}
