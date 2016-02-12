/**
 * 
 */
package org.hamster.sprite.service.password.impl;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.hamster.core.api.consts.StatusType;
import org.hamster.sprite.dao.entity.ApplicationEntity;
import org.hamster.sprite.dao.repository.ApplicationRepository;
import org.hamster.sprite.service.password.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
@Service
@Transactional(readOnly = true)
public class ApplicationServiceImpl implements ApplicationService {

    /**
     * applicationRepository
     */
    @Autowired
    private ApplicationRepository applicationRepository;

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.sprite.service.password.ApplicationService#createApplication(java.lang.String, java.lang.String)
     */
    @Override
    public void createApplication(String name, String url) {
        List<ApplicationEntity> entities = applicationRepository.findByNameAndStatus(name, StatusType.ACTIVE);
        if (CollectionUtils.isNotEmpty(entities)) {
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.sprite.service.password.ApplicationService#checkNameExists(java.lang.String)
     */
    @Override
    public boolean checkNameExists(String name) {
        return false;
    }

}
