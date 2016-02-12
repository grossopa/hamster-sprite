/**
 * 
 */
package org.hamster.sprite.service.password;

/**
 * provides all available characters
 * 
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public interface PasswordCharacterSupplier {
    
    /**
     * 
     * @return all available numbers
     */
    char[] getNumbers();
    
    /**
     * 
     * @return all available uppercases
     */
    char[] getUppercases();
    
    /**
     * 
     * @return all available lowercases
     */
    char[] getLowercases();
    
    /**
     * 
     * @return all available symbols
     */
    char[] getSymbols();
    
    /**
     * get by single type
     * 
     * @param type
     * @return
     */
    char[] get(int type);
}
