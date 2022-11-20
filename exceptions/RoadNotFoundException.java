package application.exceptions;

public class RoadNotFoundException extends Exception{
    public RoadNotFoundException(String message) {
        System.out.println(message);
    }
}
