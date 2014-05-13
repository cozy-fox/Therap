package net.therap.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author: therapJavaFestTeam
 * @since: 10/2/12 4:11 PM
 */
public class DatabaseTemplate {

    private static final Logger log = LoggerFactory.getLogger(DatabaseTemplate.class);

    public static void execute(String query) {
        Connection conToUse = null;
        Statement stmt = null;
        try {

            conToUse = DatabaseConnectionPool.getConnection();
            stmt = conToUse.createStatement();
            stmt.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

            try {
                stmt.close();
            } catch (SQLException e) {
                closeConnection(conToUse);
                throw new RuntimeException(e);
            }


        }
    }

    public static <E> List<E> queryForObject(String query, ObjectRowMapper<E> objectRowMapper) {
        Connection conToUse = null;
        Statement stmt = null;
        ResultSet resultSet = null;
        List<E> listOfE = new ArrayList<E>();
        try {
            conToUse = DatabaseConnectionPool.getConnection();
            stmt = conToUse.createStatement();
            resultSet = stmt.executeQuery(query);
            while (resultSet.next()) {
                listOfE.add(objectRowMapper.mapRowToObject(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

            try {
                resultSet.close();
                stmt.close();
            } catch (SQLException e) {
                closeConnection(conToUse);
                throw new RuntimeException(e);
            }


        }
        return listOfE;
    }

    public static void executeInsertQuery(String query, Object... parameters) {
        Connection conToUse = null;
        PreparedStatement preparedStatement = null;
        try {
            conToUse = DatabaseConnectionPool.getConnection();
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

                preparedStatement.close();
            } catch (SQLException e) {
                closeConnection(conToUse);
                throw new RuntimeException(e);
            }
        }
    }

    private static void closeConnection(Connection conToClose) {
        try {
            conToClose.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
