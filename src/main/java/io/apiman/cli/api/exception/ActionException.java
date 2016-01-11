package io.apiman.cli.api.exception;

/**
 * @author Pete
 */
public class ActionException extends RuntimeException {
    public ActionException(Throwable cause) {
        super(cause);
    }

    public ActionException(String message) {
        super(message);
    }

    public ActionException(String message, Throwable cause) {
        super(message, cause);
    }
}
