package com.nlte.usersys.common.exception;

/**
 * Created by hp on 2016/11/14.
 */
public class DateException extends RuntimeException {
    public DateException() {
    }

    public DateException(String message) {
        super(message);
    }

    public DateException(String message, Throwable cause) {
        super(message, cause);
    }

    public DateException(Throwable cause) {
        super(cause);
    }
}
