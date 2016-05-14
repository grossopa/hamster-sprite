/**
 * 
 */
package org.hamster.sprite.service.password.dto.mapper;

import org.hamster.core.api.model.mapper.AbstractDtoMapper;
import org.hamster.core.dao.util.EntityUtils;
import org.hamster.sprite.dao.entity.PasswordApplicationEntity;
import org.hamster.sprite.service.password.dto.PasswordApplicationDto;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class PasswordApplicationDtoMapper extends AbstractDtoMapper<PasswordApplicationEntity, PasswordApplicationDto> {

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.core.api.model.mapper.AbstractDtoMapper#doMap(java.lang.Object)
     */
    @Override
    protected PasswordApplicationDto doMap(PasswordApplicationEntity src) {
        PasswordApplicationDto result = new PasswordApplicationDto();
        result.setName(src.getName());
        result.setUrl(src.getUrl());
        EntityUtils.copyModifyInfo(result, src);
        result.setOrder(src.getOrder());
        return result;
    }

}
