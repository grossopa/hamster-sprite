/**
 * 
 */
package org.hamster.sprite.service.password;

/**
 * generate random password
 * 
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public interface PasswordGenerationService {

    /**
     * Generates a random password matches the rules
     * 
     * @param length
     * @param passwordGenerationType
     * @return generated password
     */
    String generatePassword(int length, int passwordGenerationType);
}
