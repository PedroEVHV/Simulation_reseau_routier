package application.app;


import application.roadNetwork.*;
import application.exceptions.JunctionException;

import java.util.ArrayList;

public class Application {
    public static int idCounter = 0;
    public static int time = 0;
    public static ArrayList<Vehicle> vehicles;


    public static void main(String[] args) throws JunctionException {

        RoadElement r1 = new RoadElement();
        RoadElement r2 = new RoadElement(r1.getJunctionB(), new Junction());
        RoadElement r3 = new RoadElement(r2.getJunctionB(), new Junction());
        RoadElement r4 = new RoadElement(r2.getJunctionB(), new Junction());
        RoadElement r5 = new RoadElement(r2.getJunctionB(), new Junction());
        RoadElement r6 = new RoadElement(r3.getJunctionB(), new Junction());
        RoadElement r7 = new RoadElement(new Junction(), r6.getJunctionA());

        r2.addSemaphore(new SpeedSign(r2, true, 2));


        vehicles = new ArrayList<>();
        //vehicles.add(new Vehicle(new State(r1, -1, 2) ));
        //vehicles.add(new Vehicle(new State(r7, 1, 2) ));
        vehicles.add(new Vehicle(new State(r1, 0, 6, true) ));

        while (time < 100) {
            for(int i = 0; i < vehicles.size(); i++) {
                vehicles.get(i).checkPos();
                System.out.println(vehicles.get(i).toString());
            }

            time++;
        }




    }
}
