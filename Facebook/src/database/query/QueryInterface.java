package database.query;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: sanjoy.saha
 * Date: 4/27/14
 * Time: 10:41 AM
 * To change this template use File | Settings | File Templates.
 */
public interface QueryInterface {
    public void insertQuery(String tableName, HashMap<String,String> dataMap);
    public void updateQuery(String tableName, HashMap<String,String> dataMap, HashMap<String,String> whereClause, boolean isAnd);
    public ArrayList<ArrayList<String>> selectQuery(String tableName,  ArrayList<String>columnNames, HashMap<String, String> whereClause, boolean isAnd);

}
