package application.exceptions;

public class SemaphoreNotFoundException extends Exception{
    public SemaphoreNotFoundException(String message) {
        System.out.println(message);
    }
}
