/**
 * 
 */
package org.hamster.sprite.service.password.dto.mapper;

import org.hamster.core.api.model.mapper.AbstractDtoMapper;
import org.hamster.sprite.dao.entity.PasswordEntity;
import org.hamster.sprite.service.password.dto.PasswordDto;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class PasswordDtoMapper extends AbstractDtoMapper<PasswordEntity, PasswordDto> {

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.core.api.model.mapper.AbstractDtoMapper#doMap(java.lang.Object)
     */
    @Override
    protected PasswordDto doMap(PasswordEntity src) {
        PasswordDto dto = new PasswordDto();
        dto.setPassword(src.getPassword());
        return dto;
    }

}
