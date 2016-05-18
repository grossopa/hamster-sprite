/**
 * 
 */
package org.hamster.sprite.dao.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hamster.core.dao.entity.base.ManageableEntity;
import org.hamster.sprite.dao.consts.TableConsts;
import org.hibernate.envers.Audited;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * account info
 * 
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
@Getter
@Setter
@Audited
@Entity
@Table(name = TableConsts.TABLE_PREFIX + "password_account")
public class PasswordAccountEntity extends ManageableEntity {

    @Column(name = "account_name", length = 100, nullable = true)
    private String accountName;

    @OneToOne
    @JoinColumn(name = "active_password_id")
    private PasswordEntity activePassword;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    private List<PasswordEntity> passwords;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "application_id")
    private PasswordApplicationEntity application;

    @Column(name = "application_id", insertable = false, updatable = false)
    private Long applicationId;

}
