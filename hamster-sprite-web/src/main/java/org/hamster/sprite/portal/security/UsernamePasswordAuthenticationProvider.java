/**
 * 
 */
package org.hamster.sprite.portal.security;

import java.util.ArrayList;
import java.util.List;

import org.hamster.sprite.service.user.api.model.AppUser;
import org.hamster.sprite.service.user.api.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

/**
 * Default username Password based authentication provider
 * 
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
@Component("usernamePasswordAuthenticationProvider")
public class UsernamePasswordAuthenticationProvider implements AuthenticationProvider {

    private static final Logger log = LoggerFactory.getLogger(UsernamePasswordAuthenticationProvider.class);

    @Autowired
    private UserService userService;

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.security.authentication.AuthenticationProvider#
     * authenticate(org.springframework.security.core .Authentication)
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userId = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();

        try {
            userService.userLogin(userId, password);
            List<GrantedAuthority> grantedRoles = new ArrayList<>();
            log.info("User {} successfully logged in.", userId);
            return new UsernamePasswordAuthenticationToken(new AppUser(userId, password, grantedRoles), password,
                    grantedRoles);
        } catch (Exception e) {
            log.debug("Login failed", e);
            throw new AuthenticationCredentialsNotFoundException("Username or password was not accepted", e);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.security.authentication.AuthenticationProvider#
     * supports(java.lang.Class)
     */
    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }

}
