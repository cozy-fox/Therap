package net.therap.service;

import net.therap.domain.User;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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


    public void saveUser(User user) {

    }

    public User verifyUser(User user) {
        return null;
    }

    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<User>();
        try {

            context = new InitialContext();
            DataSource ds = (DataSource) context.lookup("java:/comp/env/jdbc/MyLocalDB");
            connection = ds.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT id, uname, utype FROM user ");


            while(resultSet.next())
            {
                User currentUser = new User();

                int userId = resultSet.getInt("id");
                String userName = resultSet.getString("uname");
                String userType = resultSet.getString("utype");

                currentUser.setUserId(userId);
                currentUser.setUserName(userName);
                currentUser.setUserType(userType);

                userList.add(currentUser);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
                context.close();
            } catch (SQLException e) {
                System.out.println("Exception in closing DB resources");
            } catch (NamingException e) {
                System.out.println("Exception in closing Context");
            }
        }
        return userList;
    }

}
