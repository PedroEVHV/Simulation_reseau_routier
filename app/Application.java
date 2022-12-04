package application.app;


import application.exceptions.VehicleNotFoundException;
import application.roadNetwork.*;
import application.exceptions.JunctionException;

import java.util.ArrayList;

public class Application {

    public static int time = 0;


    public static void main(String[] args) throws JunctionException, VehicleNotFoundException {

        //Création des routes et des jonctions
        RoadElement r0 = new RoadElement();
        RoadElement r1 = new RoadElement(r0.getJunctionB(), new Junction());
        RoadElement r2 = new RoadElement(r1.getJunctionB(), new Junction());
        RoadElement r3 = new RoadElement(r1.getJunctionB(), new Junction());
        RoadElement r4 = new RoadElement(r1.getJunctionB(), new Junction());
        RoadElement r5 = new RoadElement(r2.getJunctionB(), new Junction());
        RoadElement r6 = new RoadElement(new Junction(), r5.getJunctionA());

        //Création et ajout des panneaux
        r1.addSemaphore(new SpeedSign(r1, true, 3));
        r3.addSemaphore(new SpeedSign(r3, false, 10));

        //Création et ajout des feux
        TrafficLight s0 = new TriColorTL(r4, true);
        r4.addSemaphore(s0);

        TrafficLight s1 =new BiColorTL(r2, true);
        TrafficLight s2 =new BiColorTL(r5, false);
        TrafficLight s3 =new BiColorTL(r6, true);
        r2.addSemaphore(s1);
        r5.addSemaphore(s2);
        r6.addSemaphore(s3);

        //Création et ajout des capteurs
        ArrayList<TrafficLight> trafficLights = new ArrayList<TrafficLight>();
        trafficLights.add(s1);
        trafficLights.add(s2);
        trafficLights.add(s3);
        r2.addSensor(new PosSensor(r2, 8, true, trafficLights));
        r5.addSensor(new PosSensor(r5, 8, false, trafficLights));
        r6.addSensor(new PosSensor(r6, 8, true, trafficLights));

        ArrayList<TrafficLight> trafficLightsBis = new ArrayList<TrafficLight>();
        trafficLightsBis.add(s0);
        r4.addSensor(new SpeedSensor(r4, 8, true, trafficLightsBis));

        //Création et ajout des voitures
        Vehicle v0 = new Vehicle(r3, 4, 6, false);
        Vehicle v1 = new Vehicle(r1, 1, 4, true);
        Vehicle v2 = new Vehicle(r6, 0, 4, true);

        r3.addVehicle(v0);
        r1.addVehicle(v1);
        r6.addVehicle(v2);

        //Premier affichage des routes et voitures
        System.out.println(r0);
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
        System.out.println(r4);
        System.out.println(r5);
        System.out.println(r6);

        System.out.println(v0);
        System.out.println(v1);
        System.out.println(v2);

        System.out.println("____________________________________________________________");

        while (time < 100) {
            for(int i = 0; i < RoadElement.getRoadElements().size(); i++) {
                RoadElement.getRoadElements().get(i).moveVehicles();
            }
            time++;
        }




    }
}
