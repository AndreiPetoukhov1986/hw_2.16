package exception;

public class ElementNonFoundException extends RuntimeException {
    public ElementNonFoundException() {
    }

    public ElementNonFoundException(String message) {
        super(message);
    }

    public ElementNonFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ElementNonFoundException(Throwable cause) {
        super(cause);
    }

    public ElementNonFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
