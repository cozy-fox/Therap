package net.therap.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sanjoy.saha
 * Date: 5/21/14
 * Time: 10:23 AM
 * To change this template use File | Settings | File Templates.
 */
public class DatabaseTemplate {

    private DatabaseConnection databaseConnection = null;
  //  static Logger log = Logger.getLogger(DatabaseTemplate.class);

    public DatabaseTemplate () {
        databaseConnection = new DatabaseConnection();
    }

    public static void execute(String query) {
        Connection conToUse = null;
        Statement stmt = null;
        try {

            //conToUse = DatabaseConnectionPool.getConnection();
            stmt = conToUse.createStatement();
            stmt.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

            try {
                stmt.close();
            } catch (SQLException e) {
                //closeConnection(conToUse);
                throw new RuntimeException(e);
            }
        }
    }

    public <E> List<E> queryForObject(String query, ObjectRowMapper<E> objectRowMapper) {
     //   log.info(query);

        Connection conToUse = null;
        Statement stmt = null;
        ResultSet resultSet = null;
        List<E> listOfE = new ArrayList<E>();
        try {
            conToUse = databaseConnection.getDatabaseConnection();
            stmt = conToUse.createStatement();
            resultSet = stmt.executeQuery(query);
            while (resultSet.next()) {
                listOfE.add(objectRowMapper.mapRowToObject(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                databaseConnection.closeDatabaseConnection(conToUse);
                if (resultSet!=null)
                    resultSet.close();
                if (stmt!=null)
                    stmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return listOfE;
    }

    public void executeInsertQuery(String query, Object... parameters) {
        //log.info(query);

        Connection conToUse = null;
        PreparedStatement preparedStatement = null;
        try {
            conToUse = databaseConnection.getDatabaseConnection();
            preparedStatement = conToUse.prepareStatement(query);

            int i = 1;
            for (Object parameter : parameters) {
                if (parameter instanceof String) {
                    preparedStatement.setString(i, (String) parameter);
                } else if (parameter instanceof Integer) {
                    preparedStatement.setInt(i, (Integer) parameter);
                } else if (parameter instanceof Long) {
                    preparedStatement.setLong(i, (Long) parameter);
                } else if (parameter instanceof Float) {
                    preparedStatement.setFloat(i, (Float) parameter);
                } else if (parameter instanceof Double) {
                    preparedStatement.setDouble(i, (Double) parameter);
                } else if (parameter instanceof Date) {
                    preparedStatement.setDate(i, (Date) parameter);
                } else if (parameter instanceof Blob) {
                    preparedStatement.setBlob(i, (Blob) parameter);
                }
                i++;
            }

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                databaseConnection.closeDatabaseConnection(conToUse);
                preparedStatement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
