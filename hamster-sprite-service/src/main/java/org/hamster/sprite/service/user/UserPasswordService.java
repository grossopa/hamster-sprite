/**
 * 
 */
package org.hamster.sprite.service.user;

import org.apache.shiro.util.ByteSource;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public interface UserPasswordService {

    /**
     * encrypt a password with salt
     * 
     * @param password
     * @param salt
     * @return
     */
    public String hashPassword(String password, ByteSource salt);

    /**
     * generate random salt
     * 
     * @return
     */
    public ByteSource generateSalt();

    /**
     * Generate login or request token
     * 
     * @return
     */
    public String generateToken();
}
