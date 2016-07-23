/**
 * 
 */
package org.hamster.sprite.service.user;

import org.hamster.sprite.dao.entity.UserEntity;
import org.hamster.sprite.dao.entity.UserLoginEntity;
import org.hamster.sprite.service.user.dto.GuestDetails;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public interface UserLoginService {
    
    /**
     * find user by user id
     * 
     * @param userId
     * @return
     */
    UserEntity findUser(String userId);
    
    /**
     * login a user by using user details
     * 
     * @param userId
     * @param password
     * @param details
     * @return
     */
    UserLoginEntity userLogin(String userId, String password, GuestDetails details);
}
