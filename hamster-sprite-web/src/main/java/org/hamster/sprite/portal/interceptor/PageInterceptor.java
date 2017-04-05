/**
 * 
 */
package org.hamster.sprite.portal.interceptor;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hamster.core.web.spring.interceptor.AbstractPageInterceptor;
import org.hamster.sprite.portal.consts.WebConsts;
import org.hamster.sprite.service.user.api.model.AppUser;
import org.hamster.sprite.service.user.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
@Component
public class PageInterceptor extends AbstractPageInterceptor {

    public static final String RESOURCE_JS = "resource_js";
    public static final String RESOURCE_CSS = "resource_css";
    public static final String WEB_API = "web_api";
    public static final String APPLICATION = "application";
    public static final String USER = "user";

    @Autowired
    private UserService userService;

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.core.web.spring.interceptor.AbstractWebInterceptor# getUserName()
     */
    @Override
    protected String getUserName() {
        Optional<AppUser> user = userService.getCurrentUser();
        return user.isPresent() ? user.get().getUsername() : "anonymous";
    }

    /**
     * Build base_uri for jsp usage
     * 
     * @param request
     * @param response
     * @param mav
     */
    protected void buildModelAndView(HttpServletRequest request, HttpServletResponse response, ModelAndView mav) {
        super.buildModelAndView(request, response, mav);

        Optional<AppUser> user = userService.getCurrentUser();
        if (mav != null) {
            mav.addObject(WEB_API, WebConsts.toMap());
            mav.addObject(USER, user.isPresent() ? user.get() : null);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.core.web.spring.interceptor.InterceptorPathPatterns#pathPatterns()
     */
    @Override
    public Optional<String[]> pathPatterns() {
        return Optional.of(new String[] { "/page/**" });
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

}
