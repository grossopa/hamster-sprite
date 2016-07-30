/**
 * 
 */
package org.hamster.sprite.service.password;

import org.hamster.sprite.dao.entity.PasswordAccountEntity;

/**
 * Service for password account management
 * 
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public interface PasswordAccountService {
    
    /**
     * find account by applicationId and accountName
     * 
     * @param applicationId
     * @param accountName
     * @return
     */
    PasswordAccountEntity findAccount(Long applicationId, String accountName);
    
    /**
     * Finds account by id
     * 
     * @param accountId
     * @return
     */
    PasswordAccountEntity findAccount(Long accountId);

    /**
     * create an account under existing application
     * 
     * @param applicationId
     * @param accountName
     * @return the created account
     */
    PasswordAccountEntity createAccount(Long applicationId, String accountName);

}
