/**
 * 
 */
package org.hamster.sprite.service.user.impl;

import org.hamster.sprite.service.user.UserPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
@Service
public class DefaultUserPasswordEncoder implements UserPasswordEncoder {

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.sprite.service.user.UserPasswordEncoder#encode(java.lang.String)
     */
    @Override
    public String encode(String rawPassword) {
        return passwordEncoder().encode(rawPassword);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.sprite.service.user.UserPasswordEncoder#matches(java.lang.String, java.lang.String)
     */
    @Override
    public boolean matches(String rawPassword, String encodedPassword) {
        return passwordEncoder().matches(rawPassword, encodedPassword);
    }

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
