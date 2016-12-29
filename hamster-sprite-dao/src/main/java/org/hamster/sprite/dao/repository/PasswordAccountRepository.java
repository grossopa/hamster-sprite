/**
 * 
 */
package org.hamster.sprite.dao.repository;

import org.hamster.sprite.dao.consts.TableConsts;
import org.hamster.sprite.dao.entity.PasswordAccountEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * repository for {@link PasswordAccountEntity}
 * 
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
@Repository
public interface PasswordAccountRepository extends PagingAndSortingRepository<PasswordAccountEntity, Long> {

    /**
     * find one by account and application id
     * 
     * @param applicationId
     * @param name
     * @return
     */
    PasswordAccountEntity findByApplicationIdAndAccountName(Long applicationId, String name);

    @Query(value = "select account_name, count(account_name) "
            + "from " + TableConsts.TABLE_PREFIX + "password_account where user_id = ? group by account_name", nativeQuery = true)
    Object[] countAccountNumberGroupByAccountName(Long userId);

}
