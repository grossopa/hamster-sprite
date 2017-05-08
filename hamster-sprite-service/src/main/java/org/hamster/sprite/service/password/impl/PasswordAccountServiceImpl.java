/**
 * 
 */
package org.hamster.sprite.service.password.impl;

import java.util.Map;

import org.hamster.core.dao.util.EntityUtils;
import org.hamster.sprite.core.util.UserUtil;
import org.hamster.sprite.dao.entity.PasswordAccountEntity;
import org.hamster.sprite.dao.entity.PasswordApplicationEntity;
import org.hamster.sprite.dao.entity.PasswordEntity;
import org.hamster.sprite.dao.repository.PasswordAccountRepository;
import org.hamster.sprite.dao.repository.PasswordApplicationRepository;
import org.hamster.sprite.dao.repository.PasswordRepository;
import org.hamster.sprite.service.password.ifc.PasswordAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hamster.sprite.api.exception.Exceptions;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
@Service
@Transactional(readOnly = true)
public class PasswordAccountServiceImpl implements PasswordAccountService {
    
    @Autowired
    private PasswordRepository passwordRepository;

    @Autowired
    private PasswordAccountRepository passwordAccountRepository;

    @Autowired
    private PasswordApplicationRepository passwordApplicationRepository;

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.sprite.service.password.PasswordAccountService#findAccountByName(java.lang.String, java.lang.Long)
     */
    @Override
    public PasswordAccountEntity findAccount(Long userId, Long applicationId, String accountName) {
        return passwordAccountRepository.findByApplicationIdAndAccountName(applicationId, accountName);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.sprite.service.password.PasswordAccountService#createAccount(java.lang.Long, java.lang.String)
     */
    @Override
    public PasswordAccountEntity createAccount(Long applicationId, String accountName) {
        PasswordApplicationEntity applicationEntity = passwordApplicationRepository.findOne(applicationId);
        if (applicationEntity == null) {
            throw Exceptions.PWDC005.create(null, applicationId);
        }

        for (PasswordAccountEntity account : applicationEntity.getAccounts()) {
            if (accountName.equalsIgnoreCase(account.getAccountName())) {
                throw Exceptions.PWDC004.create(null, accountName, applicationEntity.getName());
            }
        }

        PasswordAccountEntity newAccountEntity = new PasswordAccountEntity();
        newAccountEntity.setAccountName(accountName);
        newAccountEntity.setApplication(applicationEntity);
        EntityUtils.updateModifyInfo(newAccountEntity, UserUtil.ANONYMOUS);
        return passwordAccountRepository.save(newAccountEntity);
    }

    /*
     * (non-Javadoc)
     *
     * @see org.hamster.sprite.service.password.PasswordAccountService#findAccount(java.lang.Long)
     */
    @Override
    public PasswordAccountEntity findAccount(Long accountId) {
        PasswordAccountEntity account = passwordAccountRepository.findOne(accountId);
        if (account == null) {
            throw Exceptions.PWDC006.create(null, accountId);
        }
        return account;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.sprite.service.password.PasswordAccountService#findAccountNumberByApplicationIds(java.lang.Long, java.lang.Iterable)
     */
    @Override
    public Map<Long, Integer> findAccountNumberByApplicationIds(Long userId, Iterable<Long> applicationIds) {
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.sprite.service.password.PasswordAccountService#findCurrentPassword(java.lang.Long)
     */
    @Override
    public PasswordEntity findCurrentPassword(Long accountId) {
        PasswordEntity password = passwordRepository.findByAccountIdAndCurrent(accountId, true);
        if (password == null) {
            throw Exceptions.PWDC007.create(null, accountId);
        }
        return password;
    }

}
