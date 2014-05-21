package net.therap.dao;

import net.therap.domain.User;

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

    public void insertUser(User user) {
        //log.debug("About to save user");
        //DatabaseTemplate.executeInsertQuery("insert into USER(NAME,PASSWORD) values(?,?)", user.getUserName(), user.getUserPass());
    }

    public User getUserByUserName(String userName) {
        /*List<User> userList = DatabaseTemplate.queryForObject("select * from USER where name = '" + userName + "'",
        new ObjectRowMapper<User>() {
            public User mapRowToObject(ResultSet resultSet) throws SQLException {
                User user = new User();
                user.setUserId(resultSet.getInt("id"));
                user.setUserName(resultSet.getString("uname"));
                user.setUserPass(resultSet.getString("upass"));
                return user;
            }
        });

        if(userList.size() != 0){
            return userList.get(0);
        }*/
        return null;

    }
}
