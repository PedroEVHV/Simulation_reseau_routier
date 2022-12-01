package application;


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


        RoadElement r1 = new RoadElement();
        RoadElement r2 = new RoadElement();
        RoadElement r3 = new RoadElement();
        RoadElement r4 = new RoadElement();
        RoadElement r5 = new RoadElement();
        RoadElement r6 = new RoadElement();
        RoadElement r7 = new RoadElement();


        {
            j1.addRoad(r1);
            j1.addRoad(r2);

            j2.addRoad(r2);
            j2.addRoad(r3);
            j2.addRoad(r4);
            j2.addRoad(r5);

            j3.addRoad(r3);
            j3.addRoad(r6);
            j3.addRoad(r7);

            j4.addRoad(r1);

            j5.addRoad(r4);

            j6.addRoad(r5);

            j7.addRoad(r6);

            j8.addRoad(r7);
        }

        {
            r1.setJunctionA(j4);
            r1.setJunctionB(j1);

            r2.setJunctionA(j1);
            r2.setJunctionB(j2);

            r3.setJunctionA(j2);
            r3.setJunctionB(j3);

            r4.setJunctionA(j5);
            r4.setJunctionB(j2);

            r5.setJunctionA(j2);
            r5.setJunctionB(j6);

            r6.setJunctionA(j3);
            r6.setJunctionB(j7);

            r7.setJunctionA(j8);
            r7.setJunctionB(j3);
        }
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
