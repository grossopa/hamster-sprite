/**
 * 
 */
package org.hamster.sprite.dao.repository;

import org.hamster.sprite.dao.entity.AccountEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
@Repository
public interface AccountRepository extends PagingAndSortingRepository<AccountEntity, Long> {

}
