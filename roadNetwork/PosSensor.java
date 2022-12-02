package application.roadNetwork;

import java.util.ArrayList;

public class PosSensor extends Sensor {

    private int vehicleID;
    private int pos;

    //Constructors

    public PosSensor(RoadElement r) {
        super(r);
        this.pos = -1;
        this.vehicleID = -1;
    }

    public PosSensor(RoadElement r, int p, Boolean direction) {
        super(r, p, direction);
        this.pos = -1;
        this.vehicleID = -1;
    }

    public PosSensor(RoadElement r, int p, Boolean direction, ArrayList<TrafficLight> trafficLights) {
        super(r, p, direction, trafficLights);
        this.pos = -1;
        this.vehicleID = -1;
    }


    //Getters and Setters

    public int getPos() {
        return this.pos;
    }

    void setPos(int speed) {
        this.pos = speed;
    }

    public int getVehicleID() {
        return this.vehicleID;
    }

    void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }


    //Display

    @Override
    public String toString() {
        String output = "Capteur Position --- id: " + this.getId() + " --- position: " + this.getPos() + "\nsemaphores: \n";
        for (Semaphore e : this.getTrafficLights()) {
            output += e.toString() + "\n --- \n";
        }
        return output;
    }
}
