/**
 * 
 */
package org.hamster.sprite.dao.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hamster.core.dao.entity.base.ManageableEntity;
import org.hamster.sprite.dao.consts.TableConsts;
import org.hibernate.envers.Audited;

import com.google.common.collect.Sets;

import lombok.Getter;
import lombok.Setter;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
@Audited
@Entity
@Getter
@Setter
@Table(name = TableConsts.TABLE_PREFIX + "user")
public class UserEntity extends ManageableEntity {

    @Column(name = "user_id", length = 200, nullable = false)
    private String userId;

    @Column(name = "password", length = 2000, nullable = false)
    private String password;

    @Column(name = "salt", length = 10, nullable = false)
    private String salt;
    
    @OneToMany
    @JoinColumn(name = "user_id")
    private Set<UserLoginEntity> logins = Sets.newHashSet();
}
