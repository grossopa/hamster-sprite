/**
 * 
 */
package org.hamster.sprite.service.password.impl;

import org.hamster.core.api.consts.StatusType;
import org.hamster.core.dao.util.EntityUtils;
import org.hamster.sprite.core.util.UserUtil;
import org.hamster.sprite.dao.entity.PasswordApplicationEntity;
import org.hamster.sprite.dao.repository.PasswordApplicationRepository;
import org.hamster.sprite.service.password.PasswordApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hamster.sprite.api.exception.Exceptions;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
@Service
@Transactional(readOnly = true)
public class PasswordApplicationServiceImpl implements PasswordApplicationService {

    /**
     * applicationRepository
     */
    @Autowired
    private PasswordApplicationRepository applicationRepository;

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.sprite.service.password.ApplicationService#createApplication(java.lang.String, java.lang.String)
     */
    @Override
    public PasswordApplicationEntity createApplication(String name, String url) {
        if (checkNameExists(name)) {
            throw Exceptions.PWDC001.create(null, name);
        }

        PasswordApplicationEntity newEntity = PasswordApplicationEntity.newInstance(name, url);
        EntityUtils.updateModifyInfo(newEntity, UserUtil.ANONYMOUS);
        return applicationRepository.save(newEntity);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.sprite.service.password.ApplicationService#checkNameExists(java.lang.String)
     */
    @Override
    public boolean checkNameExists(String name) {
        return applicationRepository.findByName(name) != null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.sprite.service.password.PasswordApplicationService#findApplication(java.lang.String)
     */
    @Override
    public PasswordApplicationEntity findApplication(String name) {
        PasswordApplicationEntity entity = applicationRepository.findByNameAndStatus(name, StatusType.ACTIVE);
        if (entity == null) {
            throw Exceptions.PWDC003.create(null, entity);
        }
        return entity;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.sprite.service.password.PasswordApplicationService#findAll()
     */
    @Override
    public Iterable<PasswordApplicationEntity> findAll() {
        return applicationRepository.findAll(new Sort(Direction.ASC, "name"));
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.sprite.service.password.PasswordApplicationService#findApplication(java.lang.Long)
     */
    @Override
    public PasswordApplicationEntity findApplication(Long id) {
        PasswordApplicationEntity entity = applicationRepository.findOne(id);
        if (entity == null) {
            throw Exceptions.PWDC005.create(null, id);
        }
        return entity;
    }

}
