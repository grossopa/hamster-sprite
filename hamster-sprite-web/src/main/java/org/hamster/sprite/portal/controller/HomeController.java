/**
 * 
 */
package org.hamster.sprite.portal.controller;

import org.hamster.sprite.portal.consts.WebConsts;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 *
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
@Controller
@RequestMapping
public class HomeController {
    
    @GetMapping
    public String home() {
        return "forward:" + WebConsts.getUrl("P_USER_HOME");
    }
}
