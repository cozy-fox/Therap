package com.company;

import java.util.*;

public class Main {

    static HashMap<String, Integer> mp = new HashMap<String, Integer>();

    public static void main(String[] args) {

        mp.put("1_One", 1);
        mp.put("2_Two", 2);
        mp.put("3_Three", 3);
        mp.put("4_Four", 6);
        mp.put("5_Five", 5);
        mp.put("6_Six", 5);

        System.out.println(mp);

        SortedMap<String, Integer> sortedMap = new TreeMap<String, Integer>(mp);
        System.out.println(sortedMap);

        CustomComparator customComparator = new CustomComparator(mp);
        SortedMap<String, Integer> sortedMapByValue = new TreeMap<String, Integer>(customComparator);
        sortedMapByValue.putAll(mp);
        System.out.println(sortedMapByValue);

        for(String ss: sortedMapByValue.keySet()){
            System.out.print (sortedMap.get(ss)+", ");
        }
    }
}


class CustomComparator implements Comparator<String>{

    Map<String, Integer> localMap;

    public CustomComparator(Map<String, Integer> inMap) {
        this.localMap = inMap;
    }

    @Override
    public int compare(String o1, String o2) {
        int compValue = localMap.get(o1) - localMap.get(o2);
        return compValue == 0 ? o1.compareTo(o2):compValue;
    }
}