/**
 * 
 */
package org.hamster.sprite.service.password.dto;

import java.util.Date;

import org.hamster.core.api.model.base.ManageableIfc;
import org.hamster.core.api.model.base.OrderIfc;

import lombok.Getter;
import lombok.Setter;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
@Getter
@Setter
public class PasswordAccountDto implements ManageableIfc<Long>, OrderIfc<Long> {
    
    private String createdBy;

    private Date createdOn;

    private String updatedBy;

    private Date updatedOn;

    private String status;

    private Long id;

    private Integer order;
    
    private String accountName;
}
