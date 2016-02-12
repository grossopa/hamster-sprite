/**
 * 
 */
package org.hamster.sprite.dao.repository;

import java.util.List;

import org.hamster.sprite.dao.entity.ApplicationEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
@Repository
public interface ApplicationRepository extends PagingAndSortingRepository<ApplicationEntity, Long> {
    
    List<ApplicationEntity> findByNameAndStatus(String name, String status);
}
