package database.dao;

import database.query.QueryClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: sanjoy.saha
 * Date: 4/27/14
 * Time: 10:46 AM
 * To change this template use File | Settings | File Templates.
 */
public class AccountDAO extends QueryClass {

    private static String accountTable    = "";
    private static String friendlistTable = "";
    private static String commentlikeTable   = "";
    private static String personalTable   = "";
    private static String postTable       = "";


    public AccountDAO(){
        Properties prop = new Properties();
        InputStream in  = null;

        try {
            in = new FileInputStream("tables.properties");
            prop.load(in);

            this.accountTable     = prop.getProperty("accountTable");
            this.friendlistTable  = prop.getProperty("friendlistTable");
            this.commentlikeTable = prop.getProperty("commlikeTable");
            this.personalTable    = prop.getProperty("personalTable");
            this.postTable        = prop.getProperty("postTable");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public ArrayList<ArrayList<String>> getAccount(String uname){

        if ( uname==null || uname.length()==0){
            boolean isAnd = false;
            ArrayList<ArrayList<String>> returnData = selectQuery(this.accountTable, null, null, isAnd);
            return returnData;

        } else {
            HashMap<String,String> whereClauseData = new HashMap<String, String>();
            whereClauseData.put(uname, "account_uname");

            boolean isAnd = false;
            ArrayList<ArrayList<String>> returnData = selectQuery(this.accountTable, null, whereClauseData, isAnd);

            return returnData;
        }
    }
}
