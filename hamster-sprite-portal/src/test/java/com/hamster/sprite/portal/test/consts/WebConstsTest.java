/**
 * 
 */
package com.hamster.sprite.portal.test.consts;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.hamster.sprite.portal.consts.WebConsts;
import org.junit.Test;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class WebConstsTest {

    @Test
    public void testToMap() {
        Map<String, String> result = WebConsts.toMap();
        assertFalse(result.containsKey(WebConsts.P));
        assertFalse(result.containsKey(WebConsts.W));
        assertTrue(result.containsKey("P_PASSWORD"));
        assertTrue(result.containsKey("W_PASSWORD"));
        assertTrue(result.containsKey("W_PASSWORD_ACC_CREATE"));
        
        assertEquals(WebConsts.W_PASSWORD_ACC_CREATE, result.get("W_PASSWORD_ACC_CREATE"));
    }
}
