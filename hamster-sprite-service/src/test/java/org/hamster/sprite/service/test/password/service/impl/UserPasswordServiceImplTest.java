/**
 * 
 */
package org.hamster.sprite.service.test.password.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.apache.shiro.util.ByteSource;
import org.hamster.sprite.service.user.impl.UserPasswordServiceImpl;
import org.junit.Test;


/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class UserPasswordServiceImplTest {
    
    private UserPasswordServiceImpl service = new UserPasswordServiceImpl();
    
    @Test
    public void testHashPassword() {
        String password1 = service.hashPassword("1234", ByteSource.Util.bytes("AAAAAAAAAAAA"));
        String password2 = service.hashPassword("1234", ByteSource.Util.bytes("AAAAAAAAAAAA"));
        System.out.println(password2);
        assertEquals(password1, password2);
    }
    
    @Test
    public void testHashPasswordNotEquals() {
        String password1 = service.hashPassword("1234", ByteSource.Util.bytes("333333333333"));
        String password2 = service.hashPassword("1234", ByteSource.Util.bytes("333333333334"));
        assertNotEquals(password1, password2);
    }
    
    @Test
    public void testHashPasswordNotEquals2() {
        String password1 = service.hashPassword("5555", ByteSource.Util.bytes("333333333334"));
        String password2 = service.hashPassword("1234", ByteSource.Util.bytes("333333333334"));
        assertNotEquals(password1, password2);
    }
    
}
