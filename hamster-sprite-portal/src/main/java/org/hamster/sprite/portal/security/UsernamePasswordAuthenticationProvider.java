/**
 * 
 */
package org.hamster.sprite.portal.security;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.session.InvalidSessionException;
import org.hamster.sprite.service.user.api.UserService;
import org.hamster.sprite.service.user.dto.GuestDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class UsernamePasswordAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserService userService;

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.security.authentication.AuthenticationProvider#authenticate(org.springframework.security.core
     * .Authentication)
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userId = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();

        try {
            userService.userLogin(userId, password);

            List<GrantedAuthority> grantedRoles = new ArrayList<>();

            return new UsernamePasswordAuthenticationToken(userId, password, grantedRoles);
        } catch (InvalidSessionException e) {
            throw new AuthenticationCredentialsNotFoundException("Username or password was not accepted", e);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.security.authentication.AuthenticationProvider#supports(java.lang.Class)
     */
    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }

}