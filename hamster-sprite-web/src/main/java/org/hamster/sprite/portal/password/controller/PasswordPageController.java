/**
 * 
 */
package org.hamster.sprite.portal.password.controller;

import org.hamster.sprite.portal.consts.WebConsts;
import org.hamster.sprite.portal.controller.AbstractSpritePageController;
import org.hamster.sprite.service.password.PasswordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
@Controller
@RequestMapping(WebConsts.P_PASSWORD)
public class PasswordPageController extends AbstractSpritePageController {
    
    private static final Logger log = LoggerFactory.getLogger(PasswordPageController.class);
    
    @Autowired
    private PasswordService passwordService;
    
    @GetMapping
    public String home(Model model) {
        model.addAttribute("passwordApplications", passwordService.findAllPasswordApplications());
        return "password/home";
    }
    
    @GetMapping("/error")
    public String errorTest() {
        log.error("exception occurred");
        throw new RuntimeException("NullPointerException dddd cccc dddd");
    }

    @Override
    public String getApplication() {
        return "password";
    }
    
}
