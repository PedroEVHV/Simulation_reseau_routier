package application.exceptions;

public class SemaphoreNotFoundException extends Exception{
    public SemaphoreNotFoundException(String message) {
        super(message);
    }
}
