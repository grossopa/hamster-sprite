/**
 * 
 */
package org.hamster.sprite.service.user;

import org.hamster.sprite.dao.entity.UserEntity;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public interface UserLoginService {

    /**
     * find user by username
     * 
     * @param username
     * @return
     */
    UserEntity findUser(String username);

    /**
     * login a user by using user details
     * 
     * @param userId
     * @param password
     * @return
     */
    void userLogin(String username, String password);
}
