package net.therap.service;

import net.therap.domain.User;

/**
 *
 * @author: therapJavaFestTeam
 * @since: 10/2/12 4:11 PM
 */
public interface UserService {

    public void saveUser(User user);

    public User verifyUser(User user);
}
