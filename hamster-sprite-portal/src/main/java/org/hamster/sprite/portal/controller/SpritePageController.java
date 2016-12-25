/**
 * 
 */
package org.hamster.sprite.portal.controller;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;

import org.hamster.core.api.environment.Environment;
import org.hamster.core.web.controller.page.AbstractPageController;
import org.hamster.sprite.portal.consts.WebConsts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * 
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public abstract class SpritePageController extends AbstractPageController {

    @Autowired
    private ObjectMapper objectMapper;

    @ModelAttribute("web_api")
    public String getWebApi() throws JsonProcessingException {
        return objectMapper.writeValueAsString(WebConsts.toMap());
    }

    /**
     * Default exception handler to handle all types of exceptions and return a uniformed exception page.
     * 
     * @param request
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ModelAndView pageException(HttpServletRequest request, Exception ex) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("error/general");
        mav.addObject("exceptionDto", super.handleException(ex));

        // only serves non-production environment
        if (!Environment.isProd()) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            ex.printStackTrace(pw);
            mav.addObject("exceptionDetails", sw.toString());
        }
        return mav;
    }
}
