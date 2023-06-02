package exception;

public class ArrayIntegerIsFullException extends RuntimeException{
    public ArrayIntegerIsFullException() {
    }

    public ArrayIntegerIsFullException(String message) {
        super(message);
    }

    public ArrayIntegerIsFullException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArrayIntegerIsFullException(Throwable cause) {
        super(cause);
    }

    public ArrayIntegerIsFullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
