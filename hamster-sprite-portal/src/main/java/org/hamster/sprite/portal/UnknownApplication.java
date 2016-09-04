/**
 * 
 */
package org.hamster.sprite.portal;

import org.hamster.core.api.environment.initializer.UnknownEnvironmentContextInitializer;
import org.springframework.boot.SpringApplication;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class UnknownApplication extends Application {

    /**
     * Application entrance
     * 
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(new Object[] { UnknownApplication.class });
        application.addInitializers(new UnknownEnvironmentContextInitializer());
        application.run(args);
    }

}
