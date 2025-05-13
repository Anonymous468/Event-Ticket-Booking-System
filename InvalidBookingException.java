package event_booking;

public class InvalidBookingException extends Exception {
    public InvalidBookingException() {
        super("Invalid booking attempt.");
    }

    public InvalidBookingException(String message) {
        super(message);
    }
}
