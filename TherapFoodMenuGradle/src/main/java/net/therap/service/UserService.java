package net.therap.service;

import net.therap.dao.UserDao;
import net.therap.domain.User;

/**
 * Created with IntelliJ IDEA.
 * User: sanjoy.saha
 * Date: 5/20/14
 * Time: 3:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserService {

    private UserDao userDao;

    public UserService() {
        userDao = new UserDao();
    }

    public User verifyUser(User user) {
        User verifiedUser = userDao.getUserByUserName(user.getUserName());
        if (verifiedUser != null && verifiedUser.getUserPass().equals(user.getUserPass())) {
            return verifiedUser;
        }
        return null;
    }

//    public List<User> getAllUsers() {
//        List<User> userList = new ArrayList<User>();
//        try {
//
//            context = new InitialContext();
//            DataSource ds = (DataSource) context.lookup("java:/comp/env/jdbc/MyLocalDB");
//            connection = ds.getConnection();
//            statement = connection.createStatement();
//            resultSet = statement.executeQuery("SELECT id, uname, utype FROM user ");
//
//
//            while(resultSet.next())
//            {
//                User currentUser = new User();
//
//                int userId = resultSet.getInt("id");
//                String userName = resultSet.getString("uname");
//                String userType = resultSet.getString("utype");
//
//                currentUser.setUserId(userId);
//                currentUser.setUserName(userName);
//                currentUser.setUserType(userType);
//
//                userList.add(currentUser);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (NamingException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                resultSet.close();
//                statement.close();
//                connection.close();
//                context.close();
//            } catch (SQLException e) {
//                System.out.println("Exception in closing DB resources");
//            } catch (NamingException e) {
//                System.out.println("Exception in closing Context");
//            }
//        }
//        return userList;
//    }

}
