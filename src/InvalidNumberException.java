
public class InvalidNumberException extends Exception {
    private final String message;

    public InvalidNumberException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
