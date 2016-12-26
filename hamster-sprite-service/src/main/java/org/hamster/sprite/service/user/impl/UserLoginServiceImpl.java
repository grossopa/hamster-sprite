/**
 * 
 */
package org.hamster.sprite.service.user.impl;

import java.util.Date;

import org.hamster.core.api.consts.StatusType;
import org.hamster.sprite.dao.entity.UserEntity;
import org.hamster.sprite.dao.entity.UserLoginEntity;
import org.hamster.sprite.dao.repository.UserRepository;
import org.hamster.sprite.service.user.UserLoginService;
import org.hamster.sprite.service.user.UserPasswordEncoder;
import org.hamster.sprite.service.user.UserTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hamster.sprite.api.exception.Exceptions;

import lombok.Setter;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
@Service
@Transactional(readOnly = true)
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    @Setter
    private UserRepository userRepository;

    @Autowired
    @Setter
    private UserTokenService userTokenService;

    @Autowired
    @Setter
    private UserPasswordEncoder userPasswordEncoder;

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.sprite.service.user.UserLoginService#findUser(java.lang.String)
     */
    @Override
    public UserEntity findUser(String username) {
        return userRepository.findByUsername(username);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.sprite.service.user.UserLoginService#userLogin(java.lang.String, java.lang.String)
     */
    @Override
    @Transactional(readOnly = false)
    public void userLogin(String userId, String password) {
        UserEntity user = findUser(userId);
        if (user == null) {
            throw Exceptions.USRC001.create(null, userId);
        }

        if (!userPasswordEncoder.matches(password, user.getPassword())) {
            throw Exceptions.USRC002.create(null);
        }
    }

    /**
     * 
     * @return
     */
    private UserLoginEntity createUserLoginEntity() {
        UserLoginEntity entity = new UserLoginEntity();
        entity.setLoginTime(new Date());
        entity.setStatus(StatusType.ACTIVE);
        entity.setLoginToken(userTokenService.generateToken());
        return entity;
    }

}
