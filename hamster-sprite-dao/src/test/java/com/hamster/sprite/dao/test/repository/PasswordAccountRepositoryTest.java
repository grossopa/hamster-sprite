/**
 * 
 */
package com.hamster.sprite.dao.test.repository;

import org.hamster.core.test.helper.Asserts;
import org.hamster.sprite.dao.repository.PasswordAccountRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hamster.sprite.dao.test.base.AbstractAppDaoSpringTest;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class PasswordAccountRepositoryTest extends AbstractAppDaoSpringTest {

    @Autowired
    private PasswordAccountRepository accountRepository;

    @Test
    public void testLoad() {
        Assert.assertNotNull(accountRepository);
    }

    @Test
    public void test() {

        Object[] result = accountRepository.countAccountNumberGroupByAccountName(1L);
        for (Object item : result) {
            Object[] arr = (Object[]) item;
            Asserts.assertEquals(2, arr.length);
            System.out.println(arr[0]);
            System.out.println(arr[1]);
        }
    }
}
