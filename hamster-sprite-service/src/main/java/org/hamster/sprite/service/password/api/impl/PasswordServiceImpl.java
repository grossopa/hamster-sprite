/**
 * 
 */
package org.hamster.sprite.service.password.api.impl;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections4.ListUtils;
import org.hamster.core.api.consts.StatusType;
import org.hamster.sprite.dao.entity.PasswordAccountEntity;
import org.hamster.sprite.dao.entity.PasswordApplicationEntity;
import org.hamster.sprite.dao.entity.PasswordEntity;
import org.hamster.sprite.dao.repository.PasswordAccountRepository;
import org.hamster.sprite.dao.repository.PasswordApplicationRepository;
import org.hamster.sprite.service.password.PasswordAccountService;
import org.hamster.sprite.service.password.PasswordGenerationService;
import org.hamster.sprite.service.password.api.PasswordService;
import org.hamster.sprite.service.password.dto.PasswordApplicationDto;
import org.hamster.sprite.service.password.dto.mapper.PasswordApplicationDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Collections2;
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
    private PasswordApplicationRepository passwordApplicationRepository;
    
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
        PasswordApplicationEntity application = passwordApplicationRepository.findByNameAndStatus(applicationName, StatusType.ACTIVE);
        if (application == null) {
            throw Exceptions.PWDC003.create(null, applicationName);
        }
        
        PasswordAccountEntity account = passwordAccountService.findAccount(application.getId(), accountName);
        if (account == null) {
            account = passwordAccountService.createAccount(application.getId(), accountName);
        }
        
        String password = passwordGenerationService.generatePassword(length, generationType);
        
        PasswordEntity passwordEntity = new PasswordEntity();
        passwordEntity.setAccount(account);
        passwordEntity.setPassword(password);
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
        Iterable<PasswordApplicationEntity> list = passwordApplicationRepository.findAll();
        List<PasswordApplicationDto> result = new PasswordApplicationDtoMapper().mapList(list);
        // order here
        return result;
    }
    
    

}
