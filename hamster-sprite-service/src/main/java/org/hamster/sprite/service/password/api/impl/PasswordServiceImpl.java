/**
 * 
 */
package org.hamster.sprite.service.password.api.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hamster.sprite.dao.entity.PasswordAccountEntity;
import org.hamster.sprite.dao.entity.PasswordApplicationEntity;
import org.hamster.sprite.dao.entity.PasswordEntity;
import org.hamster.sprite.dao.repository.PasswordAccountRepository;
import org.hamster.sprite.service.password.PasswordAccountService;
import org.hamster.sprite.service.password.PasswordApplicationService;
import org.hamster.sprite.service.password.PasswordGenerationService;
import org.hamster.sprite.service.password.api.PasswordService;
import org.hamster.sprite.service.password.dto.PasswordAccountDto;
import org.hamster.sprite.service.password.dto.PasswordApplicationDto;
import org.hamster.sprite.service.password.dto.mapper.PasswordAccountDtoMapper;
import org.hamster.sprite.service.password.dto.mapper.PasswordApplicationDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Default Implementation of {@link PasswordService}
 * 
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
@Service
@Transactional(readOnly = true)
public class PasswordServiceImpl implements PasswordService {

    @Autowired
    private PasswordAccountRepository passwordAccountRepository;

    @Autowired
    private PasswordApplicationService passwordApplicationService;

    @Autowired
    private PasswordAccountService passwordAccountService;

    @Resource(name = "DefaultPasswordGenerationService")
    private PasswordGenerationService passwordGenerationService;

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.sprite.service.password.api.PasswordService#findAllPasswordApplications()
     */
    @Override
    public List<PasswordApplicationDto> findAllPasswordApplications() {
        Iterable<PasswordApplicationEntity> list = passwordApplicationService.findAll();
        List<PasswordApplicationDto> result = new PasswordApplicationDtoMapper().mapList(list);
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.sprite.service.password.api.PasswordService#createApplication(java.lang.String, java.lang.String)
     */
    @Override
    public Long createApplication(String name, String url) {
        PasswordApplicationEntity entity = passwordApplicationService.createApplication(name, url);
        return entity.getId();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.sprite.service.password.api.PasswordService#createAccount(java.lang.Long, java.lang.String)
     */
    @Override
    public void createAccount(Long applicationId, String accountName) {
        PasswordApplicationEntity application = passwordApplicationService.findApplication(applicationId);
        PasswordAccountEntity account = PasswordAccountEntity.newInstance(accountName, application);
        passwordAccountRepository.save(account);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.sprite.service.password.api.PasswordService#findAccountsByApplicationId(java.lang.Long)
     */
    @Override
    public List<PasswordAccountDto> findAccountsByApplicationId(Long applicationId) {
        PasswordApplicationEntity application = passwordApplicationService.findApplication(applicationId);
        return new PasswordAccountDtoMapper().mapList(application.getAccounts());
    }

    /* 
     * (non-Javadoc)
     *
     * @see org.hamster.sprite.service.password.api.PasswordService#createPassword(java.lang.Long, int)
     */
    @Override
    public void createPassword(Long accountId, int generationType, int length) {
        PasswordAccountEntity account = passwordAccountService.findAccount(accountId);
        String password = passwordGenerationService.generatePassword(length, generationType);
        PasswordEntity passwordEntity = PasswordEntity.newInstance(account, password);
        account.getPasswords().add(passwordEntity);
        passwordAccountRepository.save(account);
    }

}
