/**
 * 
 */
package org.hamster.sprite.service.user.api.impl;

import org.hamster.sprite.dao.entity.UserEntity;
import org.hamster.sprite.dao.entity.UserLoginEntity;
import org.hamster.sprite.service.user.UserLoginService;
import org.hamster.sprite.service.user.api.UserService;
import org.hamster.sprite.service.user.dto.GuestDetails;
import org.hamster.sprite.service.user.dto.LoginTokenDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hamster.sprite.api.exception.Exceptions;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserLoginService userLoginService;

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.sprite.service.user.api.UserService#userLogin(java.lang.String, java.lang.String)
     */
    @Override
    public LoginTokenDto userLogin(String userId, String password, GuestDetails guestDetails) {
        UserEntity user = userLoginService.findUser(userId);
        if (user == null) {
            throw Exceptions.USRC001.create(null, userId);
        }

        UserLoginEntity userLoginEntity = userLoginService.userLogin(userId, password, guestDetails);
        return LoginTokenDto.newInstance(userLoginEntity.getLoginToken(), userLoginEntity.getLoginTime().getTime(), userLoginEntity.getExpiresInMin());
    }

}
