package net.therap.service;

import net.therap.dao.JdbcUserDaoImpl;
import net.therap.dao.UserDao;
import net.therap.domain.User;

/**
 *
 * @author: therapJavaFestTeam
 * @since: 10/2/12 4:11 PM
 */
public class UserServiceImpl implements UserService{

    private UserDao userDao;

    public UserServiceImpl(){
        userDao = new JdbcUserDaoImpl();
    }

    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    public User verifyUser(User user) {
        User verifiedUser = userDao.getUserByUserName(user.getUserName());
        if(verifiedUser != null && verifiedUser.getPassword().equals(user.getPassword())) {
            return verifiedUser;
        }
        return null;
    }
}
