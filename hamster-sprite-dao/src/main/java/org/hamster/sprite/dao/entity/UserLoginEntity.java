/**
 * 
 */
package org.hamster.sprite.dao.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hamster.core.dao.entity.base.StatusEntity;
import org.hamster.sprite.dao.consts.TableConsts;
import org.hibernate.envers.Audited;

import lombok.Getter;
import lombok.Setter;

/**
 * Stores user login token
 * 
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
@Audited
@Getter
@Setter
@Entity
@Table(name = TableConsts.TABLE_PREFIX + "user_login")
public class UserLoginEntity extends StatusEntity {
    
    public static final int TOKEN_LENGTH = 50;
    public static final String STATUS_EXPIRED = "EXPIRED";
    public static final String STATUS_PASSWORD_CHANGED = "PASSWORD_CHANGED";
    
    
    @Column(name = "login_token", length = TOKEN_LENGTH, nullable = false)
    private String loginToken;

    @Column(name = "expires_in_min", nullable = false)
    private Long expiresInMin;
    
    @Column(name = "login_from_ip_address", length = 50, nullable = false)
    private String loginFromIpAddress;
    
    @Column(name = "user_agent", length = 500, nullable = false)
    private String userAgent;
    
    @Column(name = "request_oken", length = TOKEN_LENGTH, nullable = false)
    private String requestToken;
    
    @Column(name = "login_time", nullable = false)
    private Date loginTime;
    
}
