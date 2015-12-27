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

/**
 * stores encrypted Password and Salt
 * 
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */

@Entity
@Table(name = TableConsts.TABLE_PREFIX + "password")
public class PasswordEntity extends ManageableEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id")
    private AccountEntity account;

    @Column(name = "password", length = 2000, nullable = false)
    private String password;

    @Column(name = "encrypted_message", length = 10, nullable = false)
    private String encryptedMesage;

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return the encryptedMesage
     */
    public String getEncryptedMesage() {
        return encryptedMesage;
    }

    /**
     * @return the account
     */
    public AccountEntity getAccount() {
        return account;
    }

    /**
     * @param account
     *            the account to set
     */
    public void setAccount(AccountEntity account) {
        this.account = account;
    }

    /**
     * @param password
     *            the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @param encryptedMesage
     *            the encryptedMesage to set
     */
    public void setEncryptedMesage(String encryptedMesage) {
        this.encryptedMesage = encryptedMesage;
    }

}
