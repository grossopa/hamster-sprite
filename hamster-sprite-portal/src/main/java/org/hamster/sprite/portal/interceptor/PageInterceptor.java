/**
 * 
 */
package org.hamster.sprite.portal.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hamster.core.web.spring.interceptor.AbstractPageInterceptor;
import org.hamster.sprite.portal.consts.WebConsts;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class PageInterceptor extends AbstractPageInterceptor {

    public static final String RESOURCE_JS = "resource_js";
    public static final String RESOURCE_CSS = "resource_css";
    public static final String WEB_API = "web_api";
    public static final String APPLICATION = "application";
    
    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.core.web.spring.interceptor.AbstractWebInterceptor#getUserName()
     */
    @Override
    protected String getUserName() {
        return "";
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
        mav.addObject(WEB_API, WebConsts.toMap());
    }

}
