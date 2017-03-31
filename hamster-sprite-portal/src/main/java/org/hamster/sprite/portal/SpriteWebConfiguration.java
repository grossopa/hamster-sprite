/**
 * 
 */
package org.hamster.sprite.portal;

import java.util.List;

import org.hamster.core.web.spring.interceptor.AbstractPageInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 *
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class SpriteWebConfiguration extends WebMvcConfigurerAdapter {

    @Autowired
    private List<AbstractPageInterceptor> pageInteceptors;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        for (AbstractPageInterceptor inte : pageInteceptors) {
            registry.addInterceptor(inte);
        }

    }
}
