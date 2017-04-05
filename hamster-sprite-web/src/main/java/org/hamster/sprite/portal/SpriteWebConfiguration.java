/**
 * 
 */
package org.hamster.sprite.portal;

import java.util.List;
import java.util.Optional;

import org.hamster.core.api.environment.Environment;
import org.hamster.core.web.spring.interceptor.AbstractWebInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 *
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class SpriteWebConfiguration extends WebMvcConfigurerAdapter {

    private static final Logger log = LoggerFactory.getLogger(SpriteWebConfiguration.class);

    @Autowired
    private List<AbstractWebInterceptor> interceptors;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        for (AbstractWebInterceptor inte : interceptors) {
            InterceptorRegistration registration = registry.addInterceptor(inte);

            Optional<String[]> pathPatterns = inte.pathPatterns();
            if (pathPatterns.isPresent()) {
                registration.addPathPatterns(pathPatterns.get());
            }
            Optional<String[]> excludePathPatterns = inte.excludePathPatterns();
            if (excludePathPatterns.isPresent()) {
                registration.excludePathPatterns(excludePathPatterns.get());
            }
        }
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        if (Environment.isOneOf(Environment.UNKNOWN, Environment.LOCAL)) {
            log.info("Enabling cross domain access for {} environment for testing propose.", Environment.current());
            registry.addMapping("/**").allowedOrigins("*");
        }
    }

}
