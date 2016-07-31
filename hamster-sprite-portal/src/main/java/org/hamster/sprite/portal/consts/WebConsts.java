//@formatter:off
package org.hamster.sprite.portal.consts;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public final class WebConsts {
    private WebConsts() {}
    
    public static final String P            = "/page";
    public static final String W            = "/ws";
    
    public static final String P_PASSWORD               = P + "/password";
    
    public static final String W_PASSWORD                   = W + "/password";
    public static final String W_PASSWORD_APP_CREATE        = "/application/create";
    public static final String W_PASSWORD_APP_LIST          = "/application/list";
    public static final String W_PASSWORD_ACC_CREATE        = "/account/create";
    public static final String W_PASSWORD_ACC_LIST          = "/account/list";
    public static final String W_PASSWORD_PASSWORD_CREATE   = "/password/create";
    
    public static Map<String, String> toMap() throws IllegalArgumentException, IllegalAccessException {
        Map<String, String> result = Maps.newHashMap();
        return ImmutableMap.copyOf(result);
    }
    
}
//@formatter:on