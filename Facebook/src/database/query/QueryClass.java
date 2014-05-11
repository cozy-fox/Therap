package database.query;

import database.connection.ConnectorClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: sanjoy.saha
 * Date: 4/27/14
 * Time: 10:45 AM
 * To change this template use File | Settings | File Templates.
 */
public class QueryClass implements QueryInterface {

    @Override
    public void insertQuery(String tableName, HashMap<String, String> dataMap) {

    }

    @Override
    public void updateQuery(String tableName, HashMap<String, String> dataMap, HashMap<String, String> whereClause, boolean isAnd) {
        ConnectorClass connector = new ConnectorClass();
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = connector.getDBConnection();

            String queryString = "UPDATE " + tableName + " SET";

            /**
             * Augmenting the VALUES to SET
             */

            Iterator mapIterator = dataMap.keySet().iterator();
            while(mapIterator.hasNext()){
                String key = mapIterator.next().toString();
                String val = dataMap.get(key).toString();
                if (!isAnd)
                    queryString = queryString + " "+val+"=? OR ";
                else queryString = queryString + " "+val+"=? AND ";
            }
            if (!isAnd)
                queryString = queryString.substring(0,queryString.length()-3);
            else queryString = queryString.substring(0,queryString.length()-4);

            preparedStatement = connection.prepareStatement(queryString);

            int i=1;
            mapIterator = whereClause.keySet().iterator();
            while(mapIterator.hasNext()){
                String key = mapIterator.next().toString();
                preparedStatement.setString(i++, key);
            }


            /**
             * Augmenting the WHERE clause
             */
            if (whereClause != null) {
                Iterator mapIteratorWhere = whereClause.keySet().iterator();
                queryString += " WHERE";
                while(mapIteratorWhere.hasNext()){
                    String key = mapIteratorWhere.next().toString();
                    String val = whereClause.get(key).toString();
                    if (!isAnd)
                        queryString = queryString + " "+val+"=? OR ";
                    else queryString = queryString + " "+val+"=? AND ";
                }
                if (!isAnd)
                    queryString = queryString.substring(0,queryString.length()-3);
                else queryString = queryString.substring(0,queryString.length()-4);
            }
            preparedStatement = connection.prepareStatement(queryString);

            if (whereClause != null){
                Iterator mapIteratorWhere = whereClause.keySet().iterator();
                while(mapIterator.hasNext()){
                    String key = mapIterator.next().toString();
                    preparedStatement.setString(i++, key);
                }
            }
            System.out.println(queryString.toString());
            //preparedStatement.executeUpdate();

        } catch ( Exception e ){
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public ArrayList<ArrayList<String>> selectQuery(String tableName, ArrayList<String>columnNames, HashMap<String, String> whereClause, boolean isAnd) {

        ConnectorClass connector = new ConnectorClass();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<ArrayList<String>> returnData = new ArrayList<ArrayList<String>>();

        try {
            connection = connector.getDBConnection();

            /**
             * Augmenting the Column Names to SELECT
             */
            String queryString = "SELECT";
            if ( columnNames==null || columnNames.isEmpty() ){
                queryString = queryString + " *";
            } else {
                int numOfColumns = columnNames.size();
                for (int i=0; i < numOfColumns; i++) {
                    queryString = queryString + " " + columnNames.get(i) + ",";
                }
                queryString = queryString.substring(0,queryString.length()-1);
            }

            /**
             * Augmenting the FROM clause
             */
            queryString =  queryString + " FROM "+tableName;


            /**
             * Augmenting the WHERE clause
             */
            if (whereClause != null) {
                Iterator mapIterator = whereClause.keySet().iterator();
                queryString += " WHERE";
                while(mapIterator.hasNext()){
                    String key = mapIterator.next().toString();
                    String val = whereClause.get(key).toString();
                    if (!isAnd)
                        queryString = queryString + " "+val+"=? OR ";
                    else queryString = queryString + " "+val+"=? AND ";
                }
                if (!isAnd)
                    queryString = queryString.substring(0,queryString.length()-3);
                else queryString = queryString.substring(0,queryString.length()-4);
            }
            preparedStatement = connection.prepareStatement(queryString);

            if (whereClause != null){
                int i=1;
                Iterator mapIterator = whereClause.keySet().iterator();
                while(mapIterator.hasNext()){
                    String key = mapIterator.next().toString();
                    preparedStatement.setString(i++, key);
                }
            }
            //System.out.println(queryString.toString());
            resultSet = preparedStatement.executeQuery();

            /**
             * Preparing the RESULT of the Query to RETURN
             */
            int columns = resultSet.getMetaData().getColumnCount();
            while (resultSet.next()){
                ArrayList<String> tmp = new ArrayList<String>();
                for (int i = 1; i <= columns; i++) {
                    tmp.add(resultSet.getString(i));
                }
                returnData.add(tmp);
            }
            //showResults(resultSet);


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                if(resultSet!=null)
                    resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return returnData;
    }

}
