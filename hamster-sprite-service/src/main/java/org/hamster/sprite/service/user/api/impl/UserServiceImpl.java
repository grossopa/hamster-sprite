/**
 * 
 */
package org.hamster.sprite.service.user.api.impl;

import java.util.Collection;

import org.hamster.sprite.dao.entity.UserEntity;
import org.hamster.sprite.service.user.UserLoginService;
import org.hamster.sprite.service.user.api.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
            throw new UsernameNotFoundException(username);
        }
        return new UserDetails() {

            private static final long serialVersionUID = 1191249566326883313L;

            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public String getPassword() {
                return user.getPassword();
            }

            @Override
            public String getUsername() {
                return username;
            }

            @Override
            public boolean isAccountNonExpired() {
                return true;
            }

            @Override
            public boolean isAccountNonLocked() {
                return true;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return true;
            }

            @Override
            public boolean isEnabled() {
                return true;
            }

        };
    }

}
