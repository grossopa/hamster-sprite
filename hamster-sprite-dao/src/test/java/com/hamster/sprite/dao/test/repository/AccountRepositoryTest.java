/**
 * 
 */
package com.hamster.sprite.dao.test.repository;

import org.hamster.sprite.dao.repository.AccountRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hamster.sprite.dao.test.base.AbstractDaoSpringTest;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class AccountRepositoryTest extends AbstractDaoSpringTest {

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void testLoad() {
        Assert.assertNotNull(accountRepository);
    }
}
