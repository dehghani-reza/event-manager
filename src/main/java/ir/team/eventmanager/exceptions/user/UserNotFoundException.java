package ir.team.eventmanager.exceptions.user;

/**
 * this class throw exception when specific user can't find from data source
 * @Author:dehghani-reza
 */
public class UserNotFoundException extends Exception {

    public UserNotFoundException() {
    }

    public UserNotFoundException(Throwable cause) {
        super(cause);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
