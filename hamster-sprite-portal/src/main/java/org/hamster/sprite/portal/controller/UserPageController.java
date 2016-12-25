/**
 * 
 */
package org.hamster.sprite.portal.controller;

import org.hamster.sprite.portal.consts.WebConsts;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
@Controller
@RequestMapping(WebConsts.P_PUBLIC_LOGIN)
public class UserPageController extends SpritePageController {

    
    @GetMapping
    public String login() {
        return "user/login";
    }

    /* (non-Javadoc)
     * @see org.hamster.core.web.controller.page.AbstractPageController#getApplication()
     */
    @Override
    public String getApplication() {
        return "user";
    }

}
