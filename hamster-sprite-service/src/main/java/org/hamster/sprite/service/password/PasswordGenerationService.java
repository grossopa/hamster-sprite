/**
 * 
 */
package org.hamster.sprite.service.password;

import com.hamster.sprite.api.password.exception.PasswordException;

/**
 * generate random password
 * 
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public interface PasswordGenerationService {

    /**
     * 
     * 
     * @param length
     * @param passwordGenerationType
     * @return generated password
     */
    String generatePassword(int length, int passwordGenerationType) throws PasswordException;
}
