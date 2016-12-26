/**
 * 
 */
package org.hamster.sprite.dao.repository;

import org.hamster.sprite.dao.entity.UserLoginEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public interface UserLoginRepository extends PagingAndSortingRepository<UserLoginEntity, Long>  {

}
