/**
 * 
 */
package org.hamster.sprite.service.user.api.service;

import java.util.Optional;

import org.hamster.sprite.service.user.api.model.AppUser;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public interface UserService extends UserDetailsService {

    /**
     * Login by userId and password
     * 
     * @param userId
     * @param password
     * @param guestDetails
     * @return
     */
    void userLogin(String userId, String password);
    
    /**
     * 
     * @return current logged in user
     */
    Optional<AppUser> getCurrentUser();

}
