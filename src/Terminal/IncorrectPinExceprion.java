package Terminal;

/**
 * Exception throws when pin is not valid. To avoid this exception enter the correct pin.
 */
public class IncorrectPinExceprion extends Exception {
    public IncorrectPinExceprion ( String message ) {
        super(message);
    }
}
