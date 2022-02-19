import java.util.InputMismatchException;

public class InvalidRatingException extends InputMismatchException {
    /**
     * Default constructor
     * Calls super from class InputMismatchException
     */
    public InvalidRatingException() {
        super("Invalid Rating.");
    }

    /**
     * Constructor with one parameter
     * @param s for the desired message in invalid rating
     */
    public InvalidRatingException(String s) {
        super(s);
    }
}
