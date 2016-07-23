/**
 * 
 */
package org.hamster.sprite.service.user.dto;

import lombok.Getter;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
@Getter
public class GuestDetails {
    
    private GuestDetails() {
        
    }
    private String ipAddress;
    private String userAgent;
    private String requestToken;

    public static GuestDetails newInstance(String ipAddress, String userAgent, String requestToken) {
        GuestDetails result = new GuestDetails();
        result.ipAddress = ipAddress;
        result.userAgent = userAgent;
        result.requestToken = requestToken;
        return result;
    }
}
