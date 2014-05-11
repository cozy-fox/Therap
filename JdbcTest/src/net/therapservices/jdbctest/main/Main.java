package net.therapservices.jdbctest.main;

import net.therapservices.jdbctest.util.db.Connector;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        Connector connector = new Connector();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        StringBuilder resultString = new StringBuilder();
        try {
            connection = connector.getDBConnection();

            String queryString = "SELECT `id`, `col1`, `col2`, `col3`, `col4` FROM table1 WHERE id=?";
            preparedStatement = connection.prepareStatement(queryString,
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

//            for (int i=1; i<=3; i++){
                preparedStatement.setInt(1,1);
                resultSet = preparedStatement.executeQuery();

                resultSet.beforeFirst();
                while(resultSet.next())
                {
                    System.out.println("in loop!");
                    resultSet.updateString("col3","New String (Varchar)");
                    resultSet.updateRow();
                }


//                StringBuilder resultString = new StringBuilder();
                resultString.append(printResultSet(resultSet));
//            }
            System.out.println(resultString);

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

    private static StringBuilder printResultSet(ResultSet resultSet) {
        StringBuilder resultString = new StringBuilder();
        try {
            resultSet.beforeFirst();
            while( resultSet.next() ){
                int id      = resultSet.getInt("id");
                double col1 = resultSet.getDouble("col1");
                Date col2   = resultSet.getDate("col2");
                String col3 = resultSet.getString("col3");
                Blob col4   = resultSet.getBlob("col4");

                resultString.append("\t"+id+"\t"+col1+"\t"+col2+"\t"+col3+"\t"+col4+"\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return resultString;
    }
}
