package net.therap.dao;

import net.therap.domain.User;

/**
 *
 * @author: therapJavaFestTeam
 * @since: 10/2/12 4:11 PM
 */
public interface UserDao {

    public void saveUser(User user);

    public User getUserByUserName(String userName);
}
