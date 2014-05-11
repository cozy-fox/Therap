package com.main;

import database.dao.AccountDAO;
import database.query.QueryClass;
import view.InputOutput;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: sanjoy.saha
 * Date: 4/27/14
 * Time: 10:51 AM
 * To change this template use File | Settings | File Templates.
 */
public class Controller implements ControllerInterface{
    public final String CONSOLE = "console";
    @Override
    public void runAll(){
        String inputValue = "";

        while ( !(inputValue = new InputOutput().input(CONSOLE)).equals("exit") ){

            if ( inputValue.equals("1") ){
                ArrayList<ArrayList<String>> returnData = new AccountDAO().getAccount(null);
                new InputOutput().output(CONSOLE, returnData);

            } else if ( inputValue.equals("2") ){
                String line = new InputOutput().input("view_profile.txt");
                String parts[] = line.split(";");
                for(String uname : parts){
                    ArrayList<ArrayList<String>> returnData = new AccountDAO().getAccount(uname);
                    new InputOutput().output(CONSOLE, returnData);
                }
            } else if ( inputValue.equals("3") ) {
                HashMap<String, String> dataMap = new HashMap<String, String>();
                dataMap.put("123","a");
                dataMap.put("567","b");

                HashMap<String, String> whereClause = new HashMap<String, String>();
                whereClause.put("11","c");

                new QueryClass().updateQuery("test", dataMap, whereClause, true);
            }

        }
        System.out.println("");
        System.out.println(".:: Exiting ... \n==================");
    }

    @Override
    public void parseInput(String line) {

    }

    @Override
    public void databaseAction() {

    }

}
