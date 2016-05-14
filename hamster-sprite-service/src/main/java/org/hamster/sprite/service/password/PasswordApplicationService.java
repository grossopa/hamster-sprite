/**
 * 
 */
package org.hamster.sprite.service.password;

import org.hamster.sprite.dao.entity.PasswordApplicationEntity;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public interface PasswordApplicationService {
    
    /**
     * create an application with name
     * 
     * @param name
     * @param url
     */
    PasswordApplicationEntity createApplication(String name, String url);
    
    /**
     * check if name exists
     * 
     * @param name
     * @return true represents for existing
     */
    boolean checkNameExists(String name);
}