package com.kharazin.fef.movenko.quest.exception;

/**
 * Created by Serega on 21.09.2017.
 */
public class OperationDaoException extends RuntimeException {

    public OperationDaoException() {
        super();
    }

    public OperationDaoException(String message) {
        super(message);
    }

    public OperationDaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public OperationDaoException(Throwable cause) {
        super(cause);
    }

    protected OperationDaoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}