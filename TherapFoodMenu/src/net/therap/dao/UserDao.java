package net.therap.dao;

import net.therap.domain.User;
import net.therap.util.DatabaseTemplate;
import net.therap.util.ObjectRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

/**
 * Created with IntelliJ IDEA.
 * User: sanjoy.saha
 * Date: 5/20/14
 * Time: 4:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserDao {
    //private static final Logger log = LoggerFactory.getLogger(UserDao.class);

    public User getUserByUserName(String userName) {
        List<User> userList = new DatabaseTemplate().queryForObject("SELECT * FROM user WHERE uname = '" + userName + "'",
                new ObjectRowMapper<User>() {
                    public User mapRowToObject(ResultSet resultSet) throws SQLException {
                        User user = new User();
                        user.setUserId(resultSet.getInt("id"));
                        user.setUserName(resultSet.getString("uname"));
                        user.setUserPass(resultSet.getString("upass"));
                        user.setUserType(resultSet.getString("utype"));
                        return user;
                    }
                });

        if(userList.size() != 0){
            return userList.get(0);
        }
        return null;
    }
}
