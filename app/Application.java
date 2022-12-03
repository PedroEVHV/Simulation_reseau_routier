package application.app;


import application.roadNetwork.*;
import application.exceptions.JunctionException;

import java.util.ArrayList;

public class Application {
    public static int idCounter = 0;
    public static int time = 0;


    public static void main(String[] args) throws JunctionException {

        RoadElement r1 = new RoadElement();
        RoadElement r2 = new RoadElement(r1.getJunctionB(), new Junction());
        RoadElement r3 = new RoadElement(r2.getJunctionB(), new Junction());
        RoadElement r4 = new RoadElement(r2.getJunctionB(), new Junction());
        RoadElement r5 = new RoadElement(r2.getJunctionB(), new Junction());
        RoadElement r6 = new RoadElement(r3.getJunctionB(), new Junction());
        RoadElement r7 = new RoadElement(new Junction(), r6.getJunctionA());

        r2.addSemaphore(new SpeedSign(r2, true, 2));

        r2.addVehicle(new Vehicle(r2, 0, 2, true));


        while (time < 100) {
            for(int i = 0; i < RoadElement.getRoadElements().size(); i++) {
                RoadElement.getRoadElements().get(i).moveVehicles();
            }

            time++;
        }




    }
}
