/**
 * 
 */
package org.hamster.sprite.portal.password.controller;

import org.hamster.core.web.controller.dto.ResultDto;
import org.hamster.core.web.controller.page.AbstractWSController;
import org.hamster.sprite.portal.consts.WebConsts;
import org.hamster.sprite.service.password.PasswordApplicationService;
import org.hamster.sprite.service.password.api.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
@Controller
@RequestMapping(WebConsts.W_PASSWORD)
public class PasswordWSController extends AbstractWSController {

    @Autowired
    private PasswordApplicationService passwordApplicationService;

    @Autowired
    private PasswordService passwordService;

    @RequestMapping(value = WebConsts.W_PASSWORD_APP_CREATE, method = { RequestMethod.POST })
    public ResultDto<Void> createApplication(@RequestParam("name") String name, @RequestParam("url") String url) {
        passwordApplicationService.createApplication(name, url);
        return ResultDto.of("");
    }

}
