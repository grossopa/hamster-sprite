/**
 * 
 */
package org.hamster.sprite.service.user.api;

import org.hamster.sprite.service.user.dto.GuestDetails;
import org.hamster.sprite.service.user.dto.LoginTokenDto;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public interface UserService {

    /**
     * Login by userId and password
     * 
     * @param userId
     * @param password
     * @param guestDetails
     * @return
     */
    LoginTokenDto userLogin(String userId, String password, GuestDetails guestDetails);
    
    

}
