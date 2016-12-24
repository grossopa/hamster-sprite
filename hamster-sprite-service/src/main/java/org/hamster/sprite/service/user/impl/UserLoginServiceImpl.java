/**
 * 
 */
package org.hamster.sprite.service.user.impl;

import java.util.Date;

import org.apache.shiro.util.ByteSource;
import org.hamster.core.api.consts.StatusType;
import org.hamster.sprite.core.config.AppConfig;
import org.hamster.sprite.dao.entity.UserEntity;
import org.hamster.sprite.dao.entity.UserLoginEntity;
import org.hamster.sprite.dao.repository.UserRepository;
import org.hamster.sprite.service.user.UserLoginService;
import org.hamster.sprite.service.user.UserPasswordService;
import org.hamster.sprite.service.user.dto.GuestDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hamster.sprite.api.exception.Exceptions;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
@Service
@Transactional(readOnly = true)
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    private AppConfig appConfig;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserPasswordService userPasswordService;

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.sprite.service.user.UserLoginService#findUser(java.lang.String)
     */
    @Override
    public UserEntity findUser(String userId) {
        return userRepository.findByUserId(userId);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.sprite.service.user.UserLoginService#userLogin(java.lang.String, java.lang.String)
     */
    @Override
    public UserLoginEntity userLogin(String userId, String password) {
        UserEntity user = findUser(userId);
        if (user == null) {
            throw Exceptions.USRC001.create(null, userId);
        }
        
        String hashedPassword = userPasswordService.hashPassword(password, ByteSource.Util.bytes(user.findSalt()));

        if (!hashedPassword.equals(user.getPassword())) {
            throw Exceptions.USRC002.create(null);
        }

        UserLoginEntity loginEntity = createUserLoginEntity();
        user.getLogins().add(loginEntity);
        userRepository.save(user);
        return loginEntity;
    }

    private UserLoginEntity createUserLoginEntity() {
        UserLoginEntity entity = new UserLoginEntity();
        entity.setLoginTime(new Date());
        entity.setStatus(StatusType.ACTIVE);
        entity.setLoginToken(userPasswordService.generateToken());
        return entity;
    }

}
