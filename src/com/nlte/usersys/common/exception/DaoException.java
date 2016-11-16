package com.nlte.usersys.common.exception;

/**操作数据库时抛出的异常
 * Created by hp on 2016/11/14.
 */
public class DaoException extends RuntimeException {
    public DaoException() {
    }

    public DaoException(String message) {
        super(message);
    }

    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public DaoException(Throwable cause) {
        super(cause);
    }
}
