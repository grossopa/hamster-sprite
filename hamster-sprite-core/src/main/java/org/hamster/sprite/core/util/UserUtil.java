/**
 * 
 */
package org.hamster.sprite.core.util;

import org.apache.commons.lang3.StringUtils;

/**
 * User utility
 * 
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public final class UserUtil {
    /**
     * ANONYMOUS user
     */
    public static final String ANONYMOUS = "ANONYMOUS";
    
    /**
     * Default user salt length
     */
    public static final int SALT_LENGTH = 20;
    
    /**
     * fetches salt from stored password
     * 
     * @param password
     * @return
     */
    public static final String getSalt(String password) {
        return StringUtils.substring(password, 0, SALT_LENGTH);
    }
    
    public static final String getPassword(String password) {
        return StringUtils.substring(password, SALT_LENGTH);
    }
}
