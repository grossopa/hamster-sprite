/**
 * 
 */
package org.hamster.sprite.service.user.api.impl;

import java.util.Collection;

import org.hamster.sprite.dao.entity.UserEntity;
import org.hamster.sprite.dao.entity.UserLoginEntity;
import org.hamster.sprite.service.user.UserLoginService;
import org.hamster.sprite.service.user.api.UserService;
import org.hamster.sprite.service.user.dto.LoginTokenDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserLoginService userLoginService;

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.sprite.service.user.api.UserService#userLogin(java.lang.String)
     */
    @Override
    public LoginTokenDto userLogin(String userId, String password) {
        UserEntity user = userLoginService.findUser(userId);
        if (user == null) {
            throw Exceptions.USRC001.create(null, userId);
        }

        UserLoginEntity userLoginEntity = userLoginService.userLogin(userId, password);
        return LoginTokenDto.newInstance(userId, userLoginEntity.getLoginToken(), userLoginEntity.getLoginTime().getTime(),
                userLoginEntity.getExpiresInMin());
    }

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
     */
    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        UserEntity user = userLoginService.findUser(username);
        log.error("234345");
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new UserDetails() {

            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public String getPassword() {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public String getUsername() {
                return username;
            }

            @Override
            public boolean isAccountNonExpired() {
                // TODO Auto-generated method stub
                return false;
            }

            @Override
            public boolean isAccountNonLocked() {
                // TODO Auto-generated method stub
                return false;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                // TODO Auto-generated method stub
                return false;
            }

            @Override
            public boolean isEnabled() {
                // TODO Auto-generated method stub
                return true;
            }

        };
    }

}
