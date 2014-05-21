package net.therap.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sanjoy.saha
 * Date: 5/19/14
 * Time: 1:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class CoffeeExpert {

    public static List getBrands(String color) {
        List brands = new ArrayList();
        if (color.equals("light")) {
            brands.add("Cappacino");
            brands.add("Latte");
        }
        return brands;
    }
}
