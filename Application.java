package application;


import java.util.ArrayList;

public class Application {
    public static int idCounter = 0;


    public static void main(String[] args) {

        RoadElement r1 = new RoadElement(10, 50);

        Junction newJunction = new Junction();

        RoadElement r2 = new RoadElement(10, 30, r1.getJunctionB(), newJunction);

        Vehicle vehicleTest = new Vehicle(new State(r1, 0, 1));

        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r2.getJunctionA());
    }
}
