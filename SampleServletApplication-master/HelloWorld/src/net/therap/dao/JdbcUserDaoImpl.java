package net.therap.dao;

import net.therap.domain.User;
import net.therap.util.DatabaseTemplate;
import net.therap.util.ObjectRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author: therapJavaFestTeam
 * @since: 10/2/12 4:11 PM
 */

public class JdbcUserDaoImpl implements UserDao {

    private static final Logger log = LoggerFactory.getLogger(JdbcUserDaoImpl.class);

    public void saveUser(User user) {
        log.debug("About to save user");
        DatabaseTemplate.executeInsertQuery("insert into USER(NAME,PASSWORD) values(?,?)",user.getUserName(),user.getPassword());
    }

    public User getUserByUserName(String userName) {
        List<User> userList = DatabaseTemplate.queryForObject("select * from USER where name = '" + userName + "'", new ObjectRowMapper<User>() {
            public User mapRowToObject(ResultSet resultSet) throws SQLException {
                User user = new User();
                user.setUserId(resultSet.getInt("id"));
                user.setUserName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        });

        if(userList.size() != 0){
            return userList.get(0);
        }
        return null;
    }
}
