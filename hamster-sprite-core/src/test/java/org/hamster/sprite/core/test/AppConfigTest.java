/**
 * 
 */
package org.hamster.sprite.core.test;

import org.hamster.sprite.core.config.AppConfig;
import org.hamster.sprite.core.test.base.AbstractCoreSpringTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class AppConfigTest extends AbstractCoreSpringTest {
    
    @Autowired
    private AppConfig appConfig;
    
    @Test
    public void testBase() {
        Assert.assertNotNull(appConfig);
        Assert.assertNotNull(appConfig.getUserExpiredInMin());
    }
}
