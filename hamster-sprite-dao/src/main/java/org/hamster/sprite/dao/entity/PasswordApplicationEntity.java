/**
 * 
 */
package org.hamster.sprite.dao.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hamster.core.api.model.base.OrderIfc;
import org.hamster.core.dao.entity.base.ManageableEntity;
import org.hamster.sprite.dao.consts.TableConsts;
import org.hibernate.envers.Audited;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * The application provider holds the credentials
 * 
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Audited
@Entity
@Table(name = TableConsts.TABLE_PREFIX + "password_application")
public class PasswordApplicationEntity extends ManageableEntity implements OrderIfc<Long> {

    @Column(name = "name", length = 50, nullable = false, unique = true)
    private String name;

    @Column(name = "url", length = TableConsts.URL_LENGTH, nullable = true)
    private String url;

    @Column(name = OrderIfc.COL_NAME)
    private Integer Order;
    
    @OneToMany(mappedBy = "application", fetch = FetchType.LAZY)
    List<PasswordAccountEntity> accounts;
    
    public static PasswordApplicationEntity newInstance(String name, String url) {
        PasswordApplicationEntity entity = new PasswordApplicationEntity();
        entity.setName(name);
        entity.setUrl(url);
        return entity;
    }

}
