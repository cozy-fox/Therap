package view;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: sanjoy.saha
 * Date: 4/27/14
 * Time: 2:48 PM
 * To change this template use File | Settings | File Templates.
 */
public interface IOInterface {
    public String input(String locator);
    public void output(String destination, ArrayList<ArrayList<String>> o);
}
