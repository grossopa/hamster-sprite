/**
 * 
 */
package com.hamster.sprite.api.password.exception;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class PasswordException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = -1110018589318611159L;

    /**
     * 
     */
    public PasswordException() {
        super();
    }

    /**
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public PasswordException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    /**
     * @param message
     * @param cause
     */
    public PasswordException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param message
     */
    public PasswordException(String message) {
        super(message);
    }

    /**
     * @param cause
     */
    public PasswordException(Throwable cause) {
        super(cause);
    }

}
