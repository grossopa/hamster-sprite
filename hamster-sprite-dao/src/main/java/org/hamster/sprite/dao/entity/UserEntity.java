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
import org.hamster.core.dao.util.EntityUtils;
import org.hamster.sprite.dao.consts.TableConsts;
import org.hibernate.envers.Audited;

import com.google.common.collect.Sets;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
@Audited
@Entity
@Getter
@Setter
@Table(name = TableConsts.TABLE_PREFIX + "user")
public class UserEntity extends ManageableEntity {

    @Column(name = "username", length = 100, nullable = false)
    private String username;

    @Column(name = "password", length = 200, nullable = false)
    private String password;

    @OneToMany
    @JoinColumn(name = "user_id")
    private Set<UserLoginEntity> logins = Sets.newHashSet();
    
    /**
     * Create an instance with minimal attributes required
     * 
     * @param username
     * @param password
     * @return
     */
    public static UserEntity newInstance(String username, String password) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(username);
        userEntity.setPassword(password);
        EntityUtils.updateModifyInfo(userEntity, "TEST");
        return userEntity;
    }
}
