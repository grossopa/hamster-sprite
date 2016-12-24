/**
 * 
 */
package org.hamster.sprite.service.user;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public interface UserTokenService {
    /**
     * generate a random login token for user
     * @return
     */
    String generateToken();
}
