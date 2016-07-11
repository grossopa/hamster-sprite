/**
 * 
 */
package org.hamster.sprite.service.password.api;

import java.util.List;

import org.hamster.sprite.service.password.dto.PasswordApplicationDto;

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
    
    /**
     * find out all password applications ordered by name
     * 
     * @return
     */
    List<PasswordApplicationDto> findAllPasswordApplications();
    
    /**
     * create application 
     * 
     * @param applicationName
     * @param url
     * @return
     */
    Long createApplication(String applicationName, String url);
}
