package application;


import java.util.ArrayList;

public class Application {
    public static int idCounter = 0;

    Junction j1 = new Junction(2, new ArrayList<RoadElement>());
    Junction j2 = new Junction(1, new ArrayList<RoadElement>());
    Junction j3 = new Junction(1, new ArrayList<RoadElement>());

    RoadElement r1 = new RoadElement(10, 20, j2, j1, new ArrayList<Semaphore>());
    RoadElement r2 = new RoadElement(10, 20, j1, j3, new ArrayList<Semaphore>());

    Vehicle vehicleTest = new Vehicle(new State(r1, 0, 1));



    public static void main(String[] args) {

    }
}
