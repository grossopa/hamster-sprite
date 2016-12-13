/**
 * 
 */
package org.hamster.sprite.service.user.api;

import org.hamster.sprite.service.user.dto.GuestDetails;
import org.hamster.sprite.service.user.dto.LoginTokenDto;
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
    LoginTokenDto userLogin(String userId, String password);
    
    

}
