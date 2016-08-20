/**
 * 
 */
package org.hamster.sprite.core.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
@Component
@Configuration
@EnableConfigurationProperties(AppConfig.class)
public class AppConfigHolder {

}
