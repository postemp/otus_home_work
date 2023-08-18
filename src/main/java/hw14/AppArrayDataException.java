package hw14;

public class AppArrayDataException extends RuntimeException {
    private final String details;

    public String getDetails(){
        return this.details;
    }

    public AppArrayDataException(String message, String details) {
        super(message);
        this.details = details;
    }
}
