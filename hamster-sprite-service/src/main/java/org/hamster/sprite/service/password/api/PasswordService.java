/**
 * 
 */
package org.hamster.sprite.service.password.api;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public interface PasswordService {

    /**
     * create a password with accountName under the application
     * 
     * @param applicationName
     * @param accountName
     */
    void createPassword(String applicationName, String accountName, int length, int generationType);
}
