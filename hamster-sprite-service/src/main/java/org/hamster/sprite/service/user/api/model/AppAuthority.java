/**
 * 
 */
package org.hamster.sprite.service.user.api.model;

import org.springframework.security.core.GrantedAuthority;

import com.google.common.base.Function;

/**
 * Application Authority used by Spring Security
 * 
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public enum AppAuthority implements GrantedAuthority {

    ROLE_USER() {

        @Override
        public String getAuthority() {
            return this.toString();
        }

        @Override
        public <T> T apply(Function<AppAuthority, T> function) {
            return function.apply(this);
        }

    }, 
    
    ROLE_ADMIN() {

        @Override
        public String getAuthority() {
            return this.toString();
        }

        @Override
        public <T> T apply(Function<AppAuthority, T> function) {
            return function.apply(this);
        }
        
    };
    
    /**
     * applies an function that use role type as input
     * 
     * @param function
     * @return result T
     */
    abstract public <T> T apply(Function<AppAuthority, T> function);
    

}
