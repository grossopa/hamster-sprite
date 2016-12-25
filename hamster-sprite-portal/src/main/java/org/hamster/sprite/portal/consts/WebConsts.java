//@formatter:off
package org.hamster.sprite.portal.consts;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Map;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public final class WebConsts {
    private static final Logger log = LoggerFactory.getLogger(WebConsts.class);
    
    private WebConsts() {
    }

    public static final String PATTERN_MODULE = "^[W|P]_[A-Z]+";
    public static final String PATTERN_URL = "^[W|P]_[A_Z]+_[A-Z_]+";

    public static final String P = "/page";
    public static final String W = "/ws";
    
    public static final String P_PUBLIC = P + "/public";
    public static final String W_PUBLIC = W + "/public";

    public static final String P_PASSWORD = P + "/password";
    
    public static final String P_PUBLIC_LOGIN = P_PUBLIC + "/login";

    public static final String W_PASSWORD = W + "/password";
    public static final String W_PASSWORD_APP_CREATE = "/application/create";
    public static final String W_PASSWORD_APP_LIST = "/application/list";
    public static final String W_PASSWORD_ACC_CREATE = "/account/create";
    public static final String W_PASSWORD_ACC_LIST = "/account/list";
    public static final String W_PASSWORD_PASSWORD_CREATE = "/password/create";

    private static Map<String, String> URLS;

    public static Map<String, String> toMap() {
        if (URLS == null) {
            try {
                URLS = ImmutableMap.copyOf(buildMap());
            } catch (IllegalArgumentException | IllegalAccessException e) {
                log.error("Failed to initialize urls.", e);
            }
        }

        return URLS;
    }

    private static Map<String, String> buildMap() throws IllegalArgumentException, IllegalAccessException {
        Map<String, String> result = Maps.newHashMap();
        Field[] fields = WebConsts.class.getDeclaredFields();

        Map<String, String> modules = Maps.newHashMap();
        for (Field field : fields) {
            String name = field.getName();
            if (Pattern.matches(PATTERN_MODULE, name) && Modifier.isStatic(field.getModifiers())) {
                modules.put(name, (String) field.get(null));
            }
        }

        for (Field field : fields) {
            String name = field.getName();
            for (Map.Entry<String, String> moduleEntry : modules.entrySet()) {
                String moduleName = moduleEntry.getKey();
                if (name.startsWith(moduleName) && !name.equals(moduleName)) {
                    result.put(name, moduleEntry.getValue() + (String) field.get(null));
                }
            }
        }

        result.putAll(modules);
        return result;
    }

}
// @formatter:on