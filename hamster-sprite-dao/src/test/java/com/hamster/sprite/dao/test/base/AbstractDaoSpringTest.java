/**
 * 
 */
package com.hamster.sprite.dao.test.base;

import org.hamster.sprite.dao.SpriteDaoConfiguration;
import org.hamster.sprite.dao.entity.UserEntity;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest(classes = SpriteDaoConfiguration.class)
public abstract class AbstractDaoSpringTest {

    @Autowired
    protected TestEntityManager entityManager;

    private boolean initialized;

    @Before
    public void before() {
        if (!initialized) {
            initCommonData();
            initialized = true;
        }
    }

    protected void initCommonData() {
        // 123456
        entityManager.persistAndFlush(
                UserEntity.newInstance("TEST1", "$2a$10$PX.WvBHYExVN/V9XH48.ruaBcl67zEIEV.F/AIGviee5JyG9khymO"));
    }


}
