/**
 * 
 */
package org.hamster.sprite.service.password.impl;

import org.apache.commons.lang3.ArrayUtils;
import org.hamster.sprite.service.password.PasswordCharacterSupplier;
import org.springframework.stereotype.Component;

import com.hamster.sprite.api.password.PasswordGenerationType;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
@Component("DefaultPasswordCharacterSupplier")
public class DefaultPasswordCharacterSupplierImpl implements PasswordCharacterSupplier {

    /**
     * all numbers
     */
    public static final char[] NUMBERS = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

    /**
     * all uppercases
     */
    public static final char[] UPPERCASES = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

    /**
     * all lowercases
     */
    public static final char[] LOWERCASES = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

    /**
     * all symbols
     */
    public static final char[] SYMBOLS = new char[] { '!', '@', '#', '$', '%', '^', '&', '(', ')', '-', '_', '=', '+' };

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.sprite.service.password.PasswordCharacterSupplier#getNumbers()
     */
    @Override
    public char[] getNumbers() {
        return ArrayUtils.clone(NUMBERS);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.sprite.service.password.PasswordCharacterSupplier#getUppercases()
     */
    @Override
    public char[] getUppercases() {
        return ArrayUtils.clone(UPPERCASES);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.sprite.service.password.PasswordCharacterSupplier#getLowercases()
     */
    @Override
    public char[] getLowercases() {
        return ArrayUtils.clone(LOWERCASES);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.sprite.service.password.PasswordCharacterSupplier#getSymbols()
     */
    @Override
    public char[] getSymbols() {
        return ArrayUtils.clone(SYMBOLS);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.sprite.service.password.PasswordCharacterSupplier#get(int)
     */
    @Override
    public char[] get(int type) {
        if (type == PasswordGenerationType.LOWERCASE) {
            return this.getLowercases();
        } else if (type == PasswordGenerationType.NUMBER) {
            return this.getNumbers();
        } else if (type == PasswordGenerationType.SYMBOL) {
            return this.getSymbols();
        } else if (type == PasswordGenerationType.UPPERCASE) {
            return this.getUppercases();
        }
        throw new IllegalArgumentException("Illegal type value : " + type);
    }

}
