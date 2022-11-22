package application;


import java.util.ArrayList;

public class Application {
    public static int idCounter = 0;


    public static void main(String[] args) {
        Junction j1 = new Junction();
        Junction j2 = new Junction();
        Junction j3 = new Junction();

        RoadElement r1 = new RoadElement(10, 20, j2, j1);
        RoadElement r2 = new RoadElement(10, 20, j1, j3);

        Vehicle vehicleTest = new Vehicle(new State(r1, 0, 1));

        System.out.println(r1);
        System.out.println(j1);
    }
}
