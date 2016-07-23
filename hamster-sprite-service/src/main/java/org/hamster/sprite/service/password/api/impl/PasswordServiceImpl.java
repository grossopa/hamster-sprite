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
import org.hamster.sprite.service.password.dto.PasswordApplicationDto;
import org.hamster.sprite.service.password.dto.mapper.PasswordApplicationDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.hamster.sprite.api.exception.Exceptions;

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
     * @see org.hamster.sprite.service.password.PasswordService#createPassword(java.lang.String, java.lang.String)
     */
    @Override
    @Transactional
    public void createPassword(String applicationName, String accountName, int length, int generationType) {
        PasswordApplicationEntity application = passwordApplicationService.findApplication(applicationName);
        if (application == null) {
            throw Exceptions.PWDC003.create(null, applicationName);
        }
        
        PasswordAccountEntity account = passwordAccountService.findAccount(application.getId(), accountName);
        if (account == null) {
            account = passwordAccountService.createAccount(application.getId(), accountName);
        }
        
        String password = passwordGenerationService.generatePassword(length, generationType);
        
        PasswordEntity passwordEntity = PasswordEntity.newInstance(account, password);
        account.setActivePassword(passwordEntity);
        
        if (account.getPasswords() == null) {
            account.setPasswords(Lists.<PasswordEntity>newArrayList());
        }
        account.getPasswords().add(passwordEntity);
        passwordAccountRepository.save(account);
    }

    /* (non-Javadoc)
     * @see org.hamster.sprite.service.password.api.PasswordService#findAllPasswordApplications()
     */
    @Override
    public List<PasswordApplicationDto> findAllPasswordApplications() {
        Iterable<PasswordApplicationEntity> list = passwordApplicationService.findAll();
        List<PasswordApplicationDto> result = new PasswordApplicationDtoMapper().mapList(list);
        return result;
    }

    /* (non-Javadoc)
     * @see org.hamster.sprite.service.password.api.PasswordService#createApplication(java.lang.String, java.lang.String)
     */
    @Override
    public Long createApplication(String name, String url) {
        PasswordApplicationEntity entity = passwordApplicationService.createApplication(name, url);
        return entity.getId();
    }
    
    

}
