/**
 * 
 */
package org.hamster.sprite.service.password;

import java.util.Map;

import org.hamster.sprite.dao.entity.PasswordAccountEntity;
import org.hamster.sprite.dao.entity.PasswordEntity;

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
     * @param userId
     * @param applicationId
     * @param accountName
     * @return
     */
    PasswordAccountEntity findAccount(Long userId, Long applicationId, String accountName);
    
    /**
     * Finds account number by application ids
     * 
     * @param userId
     * @param applicationIds
     * @return
     */
    Map<Long, Integer> findAccountNumberByApplicationIds(Long userId, Iterable<Long> applicationIds);

    /**
     * Finds account by id
     * 
     * @param accountId
     * @return
     */
    PasswordAccountEntity findAccount(Long accountId);

    /**
     * Creates an account under existing application
     * 
     * @param applicationId
     * @param accountName
     * @return the created account
     */
    PasswordAccountEntity createAccount(Long applicationId, String accountName);
    
    /**
     * Finds current password for account
     * 
     * @param accountId
     * @return
     */
    PasswordEntity findCurrentPassword(Long accountId);

}
