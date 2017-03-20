/**
 * 
 */
package org.hamster.sprite.core.test;

import org.hamster.sprite.core.config.AppConfig;
import org.hamster.sprite.core.test.base.AbstractCoreSpringTest;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class AppConfigTest extends AbstractCoreSpringTest {
    
    private AppConfig appConfig = new AppConfig();
    
    @Test
    public void testBase() {
        Assert.assertNotNull(appConfig);
    }
}