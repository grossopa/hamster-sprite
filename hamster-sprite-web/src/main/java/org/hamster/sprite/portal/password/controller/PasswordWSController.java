/**
 * 
 */
package org.hamster.sprite.portal.password.controller;

import java.util.List;

import org.hamster.core.web.controller.dto.ResultDto;
import org.hamster.core.web.controller.page.AbstractWSController;
import org.hamster.sprite.portal.consts.WebConsts;
import org.hamster.sprite.service.password.PasswordService;
import org.hamster.sprite.service.password.dto.PasswordAccountDto;
import org.hamster.sprite.service.password.dto.PasswordApplicationDto;
import org.hamster.sprite.service.password.dto.PasswordRevealDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
@RestController
@RequestMapping(WebConsts.W_PASSWORD)
public class PasswordWSController extends AbstractWSController {

    @Autowired
    private PasswordService passwordService;

    @RequestMapping(value = WebConsts.W_PASSWORD_APP_CREATE, method = { RequestMethod.POST })
    public ResultDto<Void> createApplication(@RequestParam("name") String name, @RequestParam("url") String url) {
        passwordService.createApplication(name, url);
        return ResultDto.of();
    }

    @RequestMapping(value = WebConsts.W_PASSWORD_APP_LIST, method = { RequestMethod.GET })
    public ResultDto<List<PasswordApplicationDto>> listApplications() {
        return ResultDto.of(passwordService.findAllPasswordApplications());
    }

    @RequestMapping(value = WebConsts.W_PASSWORD_ACC_CREATE, method = { RequestMethod.POST })
    public ResultDto<Void> createAccount(@RequestParam("applicationId") Long applicationId,
            @RequestParam("accountName") String accountName) {
        passwordService.createAccount(applicationId, accountName);
        return ResultDto.of();
    }

    @RequestMapping(value = WebConsts.W_PASSWORD_ACC_LIST, method = { RequestMethod.GET })
    public ResultDto<List<PasswordAccountDto>> listAccounts(@RequestParam("applicationId") Long applicationId) {
        return ResultDto.of(passwordService.findAccountsByApplicationId(applicationId));
    }

    @RequestMapping(value = WebConsts.W_PASSWORD_PASSWORD_CREATE, method = { RequestMethod.POST })
    public ResultDto<Void> createPassword(@RequestParam("accountId") Long accountId,
            @RequestParam("password") int generationType, @RequestParam("password") int length) {
        passwordService.createPassword(accountId, generationType, length);
        return ResultDto.of();
    }

    @RequestMapping(value = WebConsts.W_PASSWORD_PASSWORD_REVEAL, method = { RequestMethod.POST, RequestMethod.GET })
    public ResultDto<PasswordRevealDto> revealPassword(@RequestParam("accountId") Long accountId) {
        return ResultDto.of(passwordService.revealPassword(accountId));
    }

}
