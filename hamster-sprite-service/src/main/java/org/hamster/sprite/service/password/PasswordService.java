/**
 * 
 */
package org.hamster.sprite.service.password;

import java.util.List;

import org.hamster.sprite.service.password.dto.PasswordAccountDto;
import org.hamster.sprite.service.password.dto.PasswordApplicationDto;
import org.hamster.sprite.service.password.dto.PasswordRevealDto;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public interface PasswordService {
    
    /**
     * Finds out all password applications ordered by name
     * 
     * @return
     */
    List<PasswordApplicationDto> findAllPasswordApplications();
    
    /**
     * Creates application 
     * 
     * @param applicationName
     * @param url
     * @return
     */
    Long createApplication(String applicationName, String url);
    
    /**
     * Creates account under an application
     * 
     * @param applicationId
     * @param account
     */
    void createAccount(Long applicationId, String account);
    
    /**
     * Finds accounts under applications
     * 
     * @param applicationId
     * @return
     */
    List<PasswordAccountDto> findAccountsByApplicationId(Long applicationId);
    
    /**
     * Creates a password and marks it as active under account
     * 
     * @param accountId
     * @param generationType
     * @param length
     */
    void createPassword(Long accountId, int generationType, int length);
    
    /**
     * Reveals the latest password of an account with audit tracked
     * 
     * @param accountId
     * @return the plain password
     */
    PasswordRevealDto revealPassword(Long accountId);
}
