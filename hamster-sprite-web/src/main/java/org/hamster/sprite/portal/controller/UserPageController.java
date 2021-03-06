/**
 * 
 */
package org.hamster.sprite.portal.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hamster.sprite.portal.consts.WebConsts;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
@Controller
@RequestMapping(WebConsts.P_USER)
public class UserPageController extends AbstractSpritePageController {

    @GetMapping(WebConsts.P_USER_LOGIN)
    public String login() {
        return "user/login";
    }

    @GetMapping(WebConsts.P_USER_LOGOUT)
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }
    
    @GetMapping(WebConsts.P_USER_HOME)
    public String home() {
        return "user/home";
    }
    

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.core.web.controller.page.AbstractPageController#getApplication()
     */
    @Override
    public String getApplication() {
        return "user";
    }

}
