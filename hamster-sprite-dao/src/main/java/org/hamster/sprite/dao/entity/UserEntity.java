/**
 * 
 */
package org.hamster.sprite.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hamster.core.dao.entity.base.ManageableEntity;
import org.hamster.sprite.dao.consts.TableConsts;
import org.hibernate.envers.Audited;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
@Audited
@Entity
@Table(name = TableConsts.TABLE_PREFIX + "user")
public class UserEntity extends ManageableEntity {

    @Column(name = "user_id", length = 200, nullable = false)
    private String userId;

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId
     *            the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

}
