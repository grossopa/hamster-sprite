/**
 * 
 */
package org.hamster.sprite.dao.repository;

import org.hamster.sprite.dao.entity.PasswordApplicationEntity;
import org.hamster.sprite.dao.repository.base.UniqueNameRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for {@link PasswordApplicationEntity}
 * 
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
@Repository
public interface PasswordApplicationRepository extends UniqueNameRepository<PasswordApplicationEntity>, PagingAndSortingRepository<PasswordApplicationEntity, Long> {

}
