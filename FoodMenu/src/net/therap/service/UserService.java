package net.therap.service;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created with IntelliJ IDEA.
 * User: sanjoy.saha
 * Date: 5/20/14
 * Time: 3:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserService {

    private static Context context = null;
    private static Connection connection = null;
    private static DataSource dataSource = null;
    private static Statement statement = null;
    private static ResultSet resultSet = null;

    static {
        try {
            context = new InitialContext();
            dataSource = (DataSource) context.lookup("java:/comp/env/jdbc/MyLocalDB");
            connection = dataSource.getConnection();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
