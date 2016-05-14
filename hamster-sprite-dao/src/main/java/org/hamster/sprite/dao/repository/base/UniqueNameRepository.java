/**
 * 
 */
package org.hamster.sprite.dao.repository.base;

/**
 * Other repositories can extend this class if name is unique of the entity with status enabled
 * 
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public interface UniqueNameRepository<T> {

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
