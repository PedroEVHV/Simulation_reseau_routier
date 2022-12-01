package application.app;


import application.roadNetwork.Junction;
import application.roadNetwork.RoadElement;
import application.roadNetwork.State;
import application.roadNetwork.Vehicle;
import application.exceptions.JunctionException;

import java.util.ArrayList;

public class Application {
    public static int idCounter = 0;
    public static int time = 0;
    public static ArrayList<Vehicle> vehicles;


    public static void main(String[] args) throws JunctionException {



        Junction j1 = new Junction();
        Junction j2 = new Junction();
        Junction j3 = new Junction();
        Junction j4 = new Junction();
        Junction j5 = new Junction();
        Junction j6 = new Junction();
        Junction j7 = new Junction();
        Junction j8 = new Junction();


        RoadElement r1 = new RoadElement(j1,j4);
        RoadElement r2 = new RoadElement(j1,j2);
        RoadElement r3 = new RoadElement(j2,j3);
        RoadElement r4 = new RoadElement(j2,j5);
        RoadElement r5 = new RoadElement(j2,j6);
        RoadElement r6 = new RoadElement(j3,j7);
        RoadElement r7 = new RoadElement(j3,j8);

        vehicles = new ArrayList<>();
        vehicles.add(new Vehicle(new State(r1, -1, 2) ));
        vehicles.add(new Vehicle(new State(r7, 1, 2) ));
        vehicles.add(new Vehicle(new State(r5, -10, 2) ));

        while (time < 500) {
            for(int i = 0; i < vehicles.size(); i++) {
                vehicles.get(i).checkPos();
            }

            time++;
        }




    }
}
