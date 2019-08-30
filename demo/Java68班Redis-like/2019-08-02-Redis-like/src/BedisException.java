public class BedisException extends Exception {
    public BedisException() {
    }

    public BedisException(String message) {
        super(message);
    }

    public BedisException(String message, Throwable cause) {
        super(message, cause);
    }

    public BedisException(Throwable cause) {
        super(cause);
    }

    public BedisException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
