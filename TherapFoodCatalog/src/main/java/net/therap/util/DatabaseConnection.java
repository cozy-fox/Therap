package net.therap.util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: sanjoy.saha
 * Date: 5/21/14
 * Time: 10:29 AM
 * To change this template use File | Settings | File Templates.
 */
public class DatabaseConnection {

    private static Context context = null;
    private static DataSource dataSource = null;

    static {
        try {
            context = new InitialContext();
            dataSource = (DataSource) context.lookup("java:/comp/env/jdbc/MyLocalDB");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public Connection getDatabaseConnection () {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            System.out.println("Error Opening Database Connection");
        }
        return connection;
    }

    public void closeDatabaseConnection (Connection connectionToClose) {
        try {
            connectionToClose.close();
        } catch (SQLException e) {
            System.out.println("Error Closing Database Connection");
        }
    }
}
