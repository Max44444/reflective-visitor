package com.company.visitor.exception;

public class UnsupportedNodeForVisitException extends Exception {

    public UnsupportedNodeForVisitException() {
        super();
    }

    public UnsupportedNodeForVisitException(String message) {
        super(message);
    }

    public UnsupportedNodeForVisitException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedNodeForVisitException(Throwable cause) {
        super(cause);
    }

    protected UnsupportedNodeForVisitException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
