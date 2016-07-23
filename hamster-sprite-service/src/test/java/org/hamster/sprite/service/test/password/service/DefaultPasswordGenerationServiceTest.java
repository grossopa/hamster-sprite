/**
 * 
 */
package org.hamster.sprite.service.test.password.service;

import org.hamcrest.MatcherAssert;
import org.hamster.sprite.service.password.impl.DefaultPasswordGenerationServiceImpl;
import org.hamster.sprite.service.test.base.AbstractServiceSpringTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hamster.sprite.api.password.PasswordGenerationType;
import com.jcabi.matchers.RegexMatchers;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class DefaultPasswordGenerationServiceTest extends AbstractServiceSpringTest {

    @Autowired
    DefaultPasswordGenerationServiceImpl service;

    @Test
    public void testGeneratePassword() {

        String result = service.generatePassword(10, PasswordGenerationType.LOWERCASE | PasswordGenerationType.UPPERCASE);
        String result2 = service.generatePassword(10, PasswordGenerationType.LOWERCASE | PasswordGenerationType.UPPERCASE);

        Assert.assertNotEquals(result, result2);
    }

    @Test
    public void testNumber() {
        String numberResult = service.generatePassword(12, PasswordGenerationType.NUMBER);
        MatcherAssert.assertThat(numberResult, RegexMatchers.matchesPattern("^[0-9]{12}$"));
    }
    
    @Test
    public void testString() {
        String stringResult = service.generatePassword(24, PasswordGenerationType.LOWERCASE | PasswordGenerationType.UPPERCASE);
        MatcherAssert.assertThat(stringResult, RegexMatchers.matchesPattern("^[a-zA-Z]{24}$"));
    }
}
