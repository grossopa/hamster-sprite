/**
 * 
 */
package org.hamster.sprite.service.user.dto;

import lombok.Getter;

/**
 * Represents user has login
 * 
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
@Getter
public class LoginTokenDto {
    private LoginTokenDto() {

    }

    private String userId;
    private String loginToken;
    private Long loginTime;
    private Long expiresInMin;

    public static LoginTokenDto newInstance(String userId, String loginToken, Long loginTime, Long expiresInMin) {
        LoginTokenDto result = new LoginTokenDto();
        result.userId = userId;
        result.loginToken = loginToken;
        result.loginTime = loginTime;
        result.expiresInMin = expiresInMin;
        return result;
    }
}
