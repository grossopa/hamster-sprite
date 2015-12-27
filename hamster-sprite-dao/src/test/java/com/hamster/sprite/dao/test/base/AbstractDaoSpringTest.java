/**
 * 
 */
package com.hamster.sprite.dao.test.base;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spriteContext-config.xml", "classpath:/spriteContext-dao.xml" })
public abstract class AbstractDaoSpringTest {

}
