/**
 * 
 */
package org.hamster.sprite.service.user;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public interface UserPasswordEncoder {
    /**
     * encode a password
     * 
     * @param rawPassword
     * @return encodedPassword
     */
    String encode(String rawPassword);
    
    /**
     * compare a rawPassword against the encodedPassword
     * 
     * @param rawPassword
     * @param encodedPassword
     * @return
     */
    boolean matches(String rawPassword, String encodedPassword);
}
