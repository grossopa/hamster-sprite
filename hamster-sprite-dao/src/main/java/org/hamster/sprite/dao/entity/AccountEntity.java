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

/**
 * account info
 * 
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
@Entity
@Table(name = TableConsts.TABLE_PREFIX + "account")
public class AccountEntity extends ManageableEntity {

    @Column(name = "account_id", length = 100, nullable = true)
    private String accountId;

    @OneToOne
    @JoinColumn(name = "active_password_id")
    PasswordEntity activePassword;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    List<PasswordEntity> passwords;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "application_id")
    ApplicationEntity application;

    /**
     * @return the accountId
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * @return the activePassword
     */
    public PasswordEntity getActivePassword() {
        return activePassword;
    }

    /**
     * @return the passwords
     */
    public List<PasswordEntity> getPasswords() {
        return passwords;
    }
    
    

    /**
     * @return the application
     */
    public ApplicationEntity getApplication() {
        return application;
    }

    /**
     * @param application the application to set
     */
    public void setApplication(ApplicationEntity application) {
        this.application = application;
    }

    /**
     * @param accountId
     *            the accountId to set
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    /**
     * @param activePassword
     *            the activePassword to set
     */
    public void setActivePassword(PasswordEntity activePassword) {
        this.activePassword = activePassword;
    }

    /**
     * @param passwords
     *            the passwords to set
     */
    public void setPasswords(List<PasswordEntity> passwords) {
        this.passwords = passwords;
    }

}
