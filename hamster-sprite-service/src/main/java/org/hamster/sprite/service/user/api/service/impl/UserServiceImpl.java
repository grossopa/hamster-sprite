/**
 * 
 */
package org.hamster.sprite.service.user.api.service.impl;

import org.hamster.sprite.dao.entity.UserEntity;
import org.hamster.sprite.service.user.UserLoginService;
import org.hamster.sprite.service.user.api.model.AppAuthority;
import org.hamster.sprite.service.user.api.model.AppUser;
import org.hamster.sprite.service.user.api.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;

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
    public void userLogin(String userId, String password) {
        userLoginService.userLogin(userId, password);
    }

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
     */
    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        final UserEntity user = userLoginService.findUser(username);
        if (user == null) {
            log.debug("Cannot find user {}", username);
            throw new UsernameNotFoundException(username);
        }
        return new AppUser(user.getUsername(), user.getPassword(), Lists.newArrayList(AppAuthority.ROLE_USER));
    }

    /**
     * @return Spring Security managed user
     */
    @Override
    public AppUser getCurrentUser() {
        return (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}
