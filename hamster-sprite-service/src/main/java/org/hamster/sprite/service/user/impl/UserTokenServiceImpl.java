/**
 * 
 */
package org.hamster.sprite.service.user.impl;

import java.security.SecureRandom;

import org.hamster.sprite.service.user.UserTokenService;
import org.springframework.stereotype.Service;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
@Service
public class UserTokenServiceImpl implements UserTokenService {

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.sprite.service.user.UserTokenService#generateToken()
     */
    @Override
    public String generateToken() {
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[80];
        random.nextBytes(bytes);
        return bytes.toString();
    }

}
