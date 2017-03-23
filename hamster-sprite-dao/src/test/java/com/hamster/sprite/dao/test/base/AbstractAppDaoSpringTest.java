/**
 * 
 */
package com.hamster.sprite.dao.test.base;

import org.hamster.core.test.repository.AbstractDaoSpringTest;
import org.hamster.sprite.dao.SpriteDaoConfiguration;
import org.hamster.sprite.dao.entity.UserEntity;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
@SpringBootTest(classes = SpriteDaoConfiguration.class)
public abstract class AbstractAppDaoSpringTest extends AbstractDaoSpringTest {

    @Override
    protected void initCommonData(TestEntityManager entityManager) {
        // 123456
        entityManager.persistAndFlush(
                UserEntity.newInstance("TEST1", "$2a$10$PX.WvBHYExVN/V9XH48.ruaBcl67zEIEV.F/AIGviee5JyG9khymO"));
    }


}
