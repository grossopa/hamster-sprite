/**
 * 
 */
package org.hamster.sprite.dao.repository;

import org.hamster.sprite.dao.entity.PasswordEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
@Repository
public interface PasswordRepository extends PagingAndSortingRepository<PasswordEntity, Long> {

    /**
     * 
     * 
     * @param accountId
     * @param current
     * @return passwordEntity or null
     */
    PasswordEntity findByAccountIdAndCurrent(Long accountId, Boolean current);
}
