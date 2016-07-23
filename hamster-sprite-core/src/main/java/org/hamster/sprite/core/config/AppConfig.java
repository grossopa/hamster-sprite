/**
 * 
 */
package org.hamster.sprite.core.config;

import org.hamster.core.api.config.AbstractAppConfig;
import org.springframework.beans.factory.annotation.Value;

import lombok.Getter;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
@Getter
public class AppConfig extends AbstractAppConfig {
    
    private @Value("${user.expire_in_min}") Long userExpiredInMin;
}
