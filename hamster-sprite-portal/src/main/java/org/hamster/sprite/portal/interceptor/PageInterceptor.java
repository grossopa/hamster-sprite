/**
 * 
 */
package org.hamster.sprite.portal.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hamster.core.web.spring.interceptor.AbstractPageInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class PageInterceptor extends AbstractPageInterceptor {

    public static final String RESOURCE_JS = "resource_js";
    public static final String RESOURCE_CSS = "resource_css";

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
        if (mav != null) {
            mav.addObject(RESOURCE_JS, request.getContextPath() + "/resources/js");
            mav.addObject(RESOURCE_CSS, request.getContextPath() + "/resources/css");
        }
    }

}
