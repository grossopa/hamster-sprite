/**
 * 
 */
package org.hamster.sprite.service.password.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Contains plain password
 *
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
@Getter
@Setter
public class PasswordRevealDto {
    private String plainPassword;
    
    /**
     * returns a new {@link PasswordRevealDto}
     * 
     * @param plainPassword
     * @return
     */
    public static final PasswordRevealDto create(String plainPassword) {
        PasswordRevealDto dto = new PasswordRevealDto();
        dto.setPlainPassword(plainPassword);
        return dto;
    }
}
