package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Number> numberList = new ArrayList<Number>();
        List<Integer> integerList = new ArrayList<Integer>();
        List<Double> doubleList = new ArrayList<Double>();

        integerList.add(1);
        integerList.add(2);
        integerList.add(3);

        doubleList.add(1.2);
        doubleList.add(2.3);
        doubleList.add(3.4);

        numberList.addAll(integerList);
        numberList.addAll(doubleList);

        System.out.println(numberList);

    }
}
