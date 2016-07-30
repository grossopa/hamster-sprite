/**
 * 
 */
package com.hamster.sprite.api.exception;

import org.hamster.core.api.exception.ExceptionCode;
import org.hamster.core.api.exception.ServiceException;
import org.hamster.core.api.exception.meta.DefaultExceptionMetadata;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public enum Exceptions {
    //@formatter:off
    
    /**
     * Application {0} already exists
     */
    PWDC001("PWDC001", "Application {0} already exists"),
    
    /**
     * Password length must be greater than {0}.
     */
    PWDC002("PWDC002", "Password length must be greater than {0}."),
    
    /**
     * Could not find application with name {0}.
     */
    PWDC003("PWDC003", "Could not find application with name {0}."),
    
    /**
     * Account {0} of Application {1} already exists.
     */
    PWDC004("PWDC004", "Account {0} of Application {1} already exists."),
    
    /**
     * Could not find application with id {0}.
     */
    PWDC005("PWDC005", "Could not find application with id {0}."),
    
    /**
     * Could not find account with id {0}.
     */
    PWDC006("PWDC006", "Could not find account with id {0}."),
    
    /**
     * Could not find user {0}.
     */
    USRC001("USRC001", "Could not find user {0}."), 
    
    /**
     * Password is not correct, please try again.
     */
    USRC002("USRC002", "Password is not correct, please try again.")
    
    ;
    //@formatter:on

    static {
        registerAll();
    }

    /**
     * Register all enum values into ExceptionCode pool
     */
    private static void registerAll() {
        for (Exceptions ex : Exceptions.values()) {
            ExceptionCode.register(ex.getCode(), new DefaultExceptionMetadata(ex.getMessage()));
        }
    }

    /**
     * Exception code
     */
    private final String code;

    /**
     * Exception message
     */
    private final String message;

    /**
     * Constructor
     * 
     * @param code
     * @param message
     */
    Exceptions(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * Create ServiceException instance
     * 
     * @param cause
     * @param arguments
     * @return
     */
    public ServiceException create(Throwable cause, Object... arguments) {
        return ServiceException.of(getCode(), null, arguments);
    }

    /**
     * Create ServiceException instance with specified message
     * 
     * @param message
     * @param cause
     * @param arguments
     * @return
     */
    public ServiceException create(String message, Throwable cause, Object... arguments) {
        return ServiceException.of(message, getCode(), null, arguments);
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

}
