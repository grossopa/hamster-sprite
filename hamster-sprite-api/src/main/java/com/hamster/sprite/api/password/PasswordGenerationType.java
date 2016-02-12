/**
 * 
 */
package com.hamster.sprite.api.password;

import java.util.Arrays;

/**
 * the password generation type
 * 
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public final class PasswordGenerationType {
    /**
     * indicate the password contains numbers
     */
    public static int NUMBER = 0x001;

    /**
     * indicate the password contains upper-cases
     */
    public static int UPPERCASE = 0x002;

    /**
     * indicate the password contains lower-cases
     */
    public static int LOWERCASE = 0X004;

    /**
     * indicate the password contains symbols
     */
    public static int SYMBOL = 0x008;
    
    private static int[] VALUES = { NUMBER, UPPERCASE, LOWERCASE, SYMBOL };

    public static int[] values() {
        return Arrays.copyOf(VALUES, VALUES.length);
    }
    
    public static int indexOf(int value) {
        for (int i = 0; i < VALUES.length; i++) {
            if (VALUES[i] == value) {
                return i;
            }
        }
        return -1;
    }

}
