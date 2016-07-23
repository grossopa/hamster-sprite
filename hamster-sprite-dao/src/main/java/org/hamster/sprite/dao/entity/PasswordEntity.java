/**
 * 
 */
package org.hamster.sprite.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hamster.core.dao.entity.base.ManageableEntity;
import org.hamster.sprite.dao.consts.TableConsts;
import org.hibernate.envers.Audited;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * stores encrypted Password and Salt
 * 
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Audited
@Entity
@Table(name = TableConsts.TABLE_PREFIX + "password")
public class PasswordEntity extends ManageableEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id")
    private PasswordAccountEntity account;

    @Column(name = "password", length = 2000, nullable = false)
    private String password;

    @Column(name = "salt", length = 10, nullable = false)
    private String salt;

    public static PasswordEntity newInstance(PasswordAccountEntity account, String password) {
        PasswordEntity entity = new PasswordEntity();
        entity.setAccount(account);
        entity.setPassword(password);
        return entity;
    }
}
