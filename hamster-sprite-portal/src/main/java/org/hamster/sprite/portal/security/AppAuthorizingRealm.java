/**
 * 
 */
package org.hamster.sprite.portal.security;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.hamster.core.web.shiro.authc.HttpUsernamePasswordToken;
import org.hamster.sprite.service.user.api.UserService;
import org.hamster.sprite.service.user.dto.GuestDetails;
import org.hamster.sprite.service.user.dto.LoginTokenDto;
import org.springframework.beans.factory.annotation.Autowired;

import com.hamster.sprite.api.model.UserFacade;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class AppAuthorizingRealm extends AuthorizingRealm {
    
    @Autowired
    private UserService userService;

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        if (token instanceof HttpUsernamePasswordToken) {
            HttpUsernamePasswordToken htoken = (HttpUsernamePasswordToken) token;
            LoginTokenDto dto = userService.userLogin(htoken.getUsername(), String.valueOf(htoken.getPassword()), 
                    GuestDetails.newInstance(htoken.getHost(), htoken.getHeader("User-Agent"), 
                            htoken.getCookie("RequestToken").getValue()));
            return new SimpleAuthenticationInfo(
                    transferToken(dto),
                    String.valueOf(htoken.getPassword()), ByteSource.Util.bytes(dto.getSalt()), getName()
                    );
        }
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // UserFacade shiroUser = (UserFacade) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // get roles
        info.addRole("user");
        return info;
    }
    
    private UserFacade transferToken(LoginTokenDto tokenDto) {
        UserFacade result = new UserFacade();
        result.setUserId(tokenDto.getUserId());
        return result;
    }

}
