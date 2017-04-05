/**
 * 
 */
package org.hamster.sprite.portal.interceptor;

import java.util.Optional;

import org.hamster.core.web.spring.interceptor.AbstractWebInterceptor;
import org.hamster.sprite.service.user.api.model.AppUser;
import org.hamster.sprite.service.user.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 *
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class WSInterceptor extends AbstractWebInterceptor {

    @Autowired
    private UserService userService;

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.core.web.spring.interceptor.InterceptorPathPatterns#pathPatterns()
     */
    @Override
    public Optional<String[]> pathPatterns() {
        return Optional.of(new String[] { "/ws/**" });
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.core.web.spring.interceptor.InterceptorPathPatterns#excludePathPatterns()
     */
    @Override
    public Optional<String[]> excludePathPatterns() {
        return Optional.empty();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.core.web.spring.interceptor.AbstractWebInterceptor#getUserName()
     */
    @Override
    protected String getUserName() {
        Optional<AppUser> user = userService.getCurrentUser();
        return user.isPresent() ? user.get().getUsername() : "anonymous";
    }

}
