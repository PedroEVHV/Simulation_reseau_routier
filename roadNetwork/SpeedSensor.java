package application.roadNetwork;

import java.util.ArrayList;
import java.util.Objects;


public class SpeedSensor extends Sensor{

    //private int vehicleID;
    private int speed;

    //Constructors

    public SpeedSensor(RoadElement r) {
        super(r);
        this.speed = -1;
        //this.vehicleID = -1;

        regulateInterface = () -> {
            for(Vehicle v: this.getRoad().getVehicles()) {
                if(v.getCurrState().getSpeed() >= this.speed) {
                    for(int i = 0; i < this.getTrafficLights().size(); i++) {
                        if(this.getTrafficLights().get(i).getClass().getTypeName().equals("TriColor") && !Objects.equals(this.getTrafficLights().get(i).getColor(), "orange")) {
                            this.getTrafficLights().get(i).setColor("orange");
                        }
                    }
                }
            }



        };
    }

    public SpeedSensor(RoadElement r, int p, Boolean direction) {
        super(r, p, direction);
        this.speed = -1;
        //this.vehicleID = -1;

        regulateInterface = () -> {
            for(Vehicle v: this.getRoad().getVehicles()) {
                if(v.getCurrState().getSpeed() >= this.speed) {
                    for(int i = 0; i < this.getTrafficLights().size(); i++) {
                        if(this.getTrafficLights().get(i).getClass().getTypeName().equals("TriColor") && !Objects.equals(this.getTrafficLights().get(i).getColor(), "orange")) {
                            this.getTrafficLights().get(i).setColor("orange");
                        }
                    }
                }
            }
        };
    }

    public SpeedSensor(RoadElement r, int p, Boolean direction, ArrayList<TrafficLight> trafficLights) {
        super(r, p, direction, trafficLights);
        this.speed = -1;
        //this.vehicleID = -1;

        regulateInterface = () -> {
            for(Vehicle v: this.getRoad().getVehicles()) {
                if(v.getCurrState().getSpeed() >= this.speed) {
                    for(TrafficLight t: getTrafficLights()) {
                        t.nextLight();
                    }
                }
            }
        };
    }


    //Getters and Setters

    public int getSpeed() {
        return this.speed;
    }

    void setSpeed(int speed) {
        this.speed = speed;
    }

    /*
    public int getVehicleID() {
        return this.vehicleID;
    }

    void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }
*/
    //Display

    @Override
    public String toString() {
        String output = "Capteur Vitesse --- id: " + this.getId() + " --- position: " + this.getPos()
                + "\nroute: "+ this.getRoad().toString()+ "\nsemaphores: \n";
        for (Semaphore e : this.getTrafficLights()) {
            output += e.toString() + "\n --- \n";
        }
        return output;
    }
}
