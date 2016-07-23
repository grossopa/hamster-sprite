/**
 * 
 */
package org.hamster.sprite.service.test.password.service;

import org.hamster.core.test.helper.Asserts;
import org.hamster.sprite.service.password.impl.DefaultPasswordCharacterSupplierImpl;
import org.hamster.sprite.service.password.impl.DefaultPasswordCharacterSupplierImpl.Characters;
import org.junit.Test;

import com.hamster.sprite.api.password.PasswordGenerationType;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class DefaultPasswordCharacterSupplierTest {
    DefaultPasswordCharacterSupplierImpl supplier = new DefaultPasswordCharacterSupplierImpl();
    
    @Test
    public void testGetType() {
        Asserts.assertArrayEquals(Characters.LOWERCASES, supplier.get(PasswordGenerationType.LOWERCASE));
        Asserts.assertArrayEquals(Characters.UPPERCASES, supplier.get(PasswordGenerationType.UPPERCASE));
        Asserts.assertArrayEquals(Characters.NUMBERS, supplier.get(PasswordGenerationType.NUMBER));
        Asserts.assertArrayEquals(Characters.SYMBOLS, supplier.get(PasswordGenerationType.SYMBOL));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testIllegal() {
        supplier.get(-1);
    }
}
