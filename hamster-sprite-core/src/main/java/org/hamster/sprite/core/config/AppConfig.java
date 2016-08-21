/**
 * 
 */
package org.hamster.sprite.core.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Getter;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
@Component
@Getter
@ConfigurationProperties(prefix="sprite")
@PropertySource({ 
    "classpath:/config/application-sprite-portal.properties",
    "classpath:/config/${hm.environment}/application.${hm.environment}.properties"})
public class AppConfig {
    
    private Long userExpiredInMin;
}
