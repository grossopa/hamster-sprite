/**
 * 
 */
package org.hamster.sprite.portal.password.controller;

import org.hamster.sprite.portal.consts.WebConsts;
import org.hamster.sprite.portal.controller.SpritePageController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
@Controller
@RequestMapping(WebConsts.P_PASSWORD)
public class PasswordPageController extends SpritePageController {
    
    private static final Logger log = LoggerFactory.getLogger(PasswordPageController.class);
    
    @GetMapping
    public String home() {
        log.info("Invoked");
        return "password/home";
    }
    
    @GetMapping("/error")
    public String errorTest() {
        throw new RuntimeException("NullPointerException dddd cccc dddd");
    }

    @Override
    public String getApplication() {
        return "password";
    }
    
}
