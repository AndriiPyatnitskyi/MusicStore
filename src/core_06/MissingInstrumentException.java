package core_06;

public class MissingInstrumentException extends Exception {

    public MissingInstrumentException() {
    }

    public MissingInstrumentException(String message) {
        super(message);
    }

    public MissingInstrumentException(String message, Throwable cause) {
        super(message, cause);
    }

    public MissingInstrumentException(Throwable cause) {
        super(cause);
    }

    public MissingInstrumentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
