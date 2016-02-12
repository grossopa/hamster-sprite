/**
 * 
 */
package org.hamster.sprite.service.password;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public interface ApplicationService {
    
    /**
     * create an application with name
     * 
     * @param name
     * @param url
     */
    void createApplication(String name, String url);
    
    /**
     * check if name exists
     * 
     * @param name
     * @return true represents for existing
     */
    boolean checkNameExists(String name);
}
