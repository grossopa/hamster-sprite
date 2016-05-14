/**
 * 
 */
package org.hamster.sprite.service.password.impl;

import org.hamster.core.dao.util.EntityUtils;
import org.hamster.sprite.core.util.UserUtil;
import org.hamster.sprite.dao.entity.PasswordApplicationEntity;
import org.hamster.sprite.dao.repository.PasswordApplicationRepository;
import org.hamster.sprite.service.password.PasswordApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
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
        
        PasswordApplicationEntity newEntity = new PasswordApplicationEntity();
        newEntity.setName(name);
        newEntity.setUrl(url);
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

}
