package com.dream.service.exception;

/**
 * Created by Dream on 2018/5/17.
 *
 * @author Dream
 */
public class UserLoginException extends RuntimeException {
    public UserLoginException() {
        super();
    }

    public UserLoginException(String message) {
        super(message);
    }

    public UserLoginException(String message, Throwable cause) {
        super(message, cause);
    }
}
