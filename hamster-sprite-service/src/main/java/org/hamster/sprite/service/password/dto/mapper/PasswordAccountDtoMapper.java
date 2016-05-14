/**
 * 
 */
package org.hamster.sprite.service.password.dto.mapper;

import org.hamster.core.api.model.mapper.AbstractDtoMapper;
import org.hamster.core.dao.util.EntityUtils;
import org.hamster.sprite.dao.entity.PasswordAccountEntity;
import org.hamster.sprite.service.password.dto.PasswordAccountDto;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class PasswordAccountDtoMapper extends AbstractDtoMapper<PasswordAccountEntity, PasswordAccountDto> {

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.core.api.model.mapper.AbstractDtoMapper#doMap(java.lang.Object)
     */
    @Override
    protected PasswordAccountDto doMap(PasswordAccountEntity src) {
        PasswordAccountDto dto = new PasswordAccountDto();
        dto.setAccountName(src.getAccountName());
        EntityUtils.copyModifyInfo(dto, src);
        return dto;
    }

}
