/**
 * 
 */
package org.hamster.sprite.dao.repository.base;

import org.hamster.core.api.model.base.StatusIfc;

/**
 * Other repositories can extend this class if name is unique and has status field
 * 
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public interface UniqueNameRepository<T extends StatusIfc<?>> {

    /**
     * 
     * @param name
     * @return
     */
    T findByName(String name);
    
    /**
     * 
     * 
     * @param name
     * @param status
     * @return
     */
    T findByNameAndStatus(String name, String status);
}
