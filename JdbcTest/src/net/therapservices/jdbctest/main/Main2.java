package net.therapservices.jdbctest.main;

import net.therapservices.jdbctest.util.db.Connector;

import java.sql.*;

/**
 * Created with IntelliJ IDEA.
 * User: sanjoy.saha
 * Date: 4/29/14
 * Time: 2:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main2 {
    /*public static void main(String args[]){

    }*/

    public void runMain2(){
        Connector connector = new Connector();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        StringBuilder resultString = new StringBuilder();
        try {


            /**
             * Testing Batch Insert
             */


            connection = connector.getDBConnection();
            connection.setAutoCommit(false);
            String queryString = "INSERT INTO table1 VALUES (0 , ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(queryString);
            Savepoint savePoint = null;

            for ( int i=0; i < 15; i ++ ) {
                java.util.Date incomingValue = new java.util.Date(System.currentTimeMillis());
                java.sql.Date databaseValue = new java.sql.Date(incomingValue.getTime());

                preparedStatement.setDouble(1, 10.01);
                preparedStatement.setDate(2, databaseValue );
                preparedStatement.setString(3, "Testing Varchar "+(i*3));
                preparedStatement.setString(4, "Testing Text BLOB" + (i * 3));
                int executeUpdateReturn = preparedStatement.executeUpdate();
                System.out.println("Execute Update Returns ["+i+"] : "+executeUpdateReturn);
//                preparedStatement.addBatch();

                if (i==10-1){
                    savePoint = connection.setSavepoint("Successful Insertion.");
                }

                if (i==14-1){
                    connection.rollback(savePoint);
                }

            }
            //int[] executeBatchReturn = preparedStatement.executeBatch();
            connection.commit();

            /*for(int i=0; i<executeBatchReturn.length; i++) {
                System.out.println("Return value of ["+i+"] : "+executeBatchReturn[i] );
            }
            System.out.println("");*/


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null)
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            if (preparedStatement != null)
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            if (connection != null)
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }
}
