/**
 * 
 */
package org.hamster.sprite.portal.password.controller;

import org.hamster.core.web.controller.page.AbstractPageController;
import org.hamster.sprite.portal.consts.WebConsts;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
@Controller
@RequestMapping(WebConsts.P_PASSWORD)
public class PasswordPageController extends AbstractPageController {
    
    @RequestMapping
    public String home() {
        return "sprite.password.home";
    }
}
