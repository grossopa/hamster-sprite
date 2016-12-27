/**
 * 
 */
package org.hamster.sprite.service.user.api.model;

import java.util.Collection;

import javax.validation.constraints.NotNull;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.google.common.collect.ImmutableList;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class AppUser implements UserDetails {

    private static final long serialVersionUID = 9138744320872931143L;

    private final String username;
    private final String password;
    private final Collection<? extends GrantedAuthority> authorities;

    /**
     * create an immutable AppUserDetails
     * 
     * @param username
     * @param password
     * @param authorities
     */
    public AppUser(@NotNull String username, @NotNull String password, @NotNull Collection<? extends GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.authorities = ImmutableList.copyOf(authorities);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.security.core.userdetails.UserDetails#getAuthorities()
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.security.core.userdetails.UserDetails#getPassword()
     */
    @Override
    public String getPassword() {
        return this.password;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.security.core.userdetails.UserDetails#getUsername()
     */
    @Override
    public String getUsername() {
        return this.username;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonExpired()
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonLocked()
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.security.core.userdetails.UserDetails#isCredentialsNonExpired()
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.security.core.userdetails.UserDetails#isEnabled()
     */
    @Override
    public boolean isEnabled() {
        return true;
    }

}
