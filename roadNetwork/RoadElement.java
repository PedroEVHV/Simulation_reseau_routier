package application.roadNetwork;

import application.app.Application;
import application.exceptions.*;

import java.util.ArrayList;

public class RoadElement {
    private final int id;
    private int size;
    private Junction junctionA;
    private Junction junctionB;
    private int speedLimit;
    private ArrayList<Semaphore> semaphores;
    private ArrayList<Sensor> sensors;
    private ArrayList<Vehicle> vehicles;

    protected static ArrayList<RoadElement> roadElements = new ArrayList<>();
    private static int idCounter = 0;


    //Constructors

    public RoadElement() {
        this(10, 2, new Junction(), new Junction());
    }

    public RoadElement(Junction a, Junction b) {
        this(10, 2, a, b);
    }

    public RoadElement(int size, int speedLimit) {
        this(size, speedLimit, new Junction(), new Junction());
    }

    public RoadElement(int size, int speedLimit, Junction a, Junction b) {
        this.id = idCounter++;
        this.size = size;
        this.speedLimit = speedLimit;
        this.junctionA = a;
        a.addRoad(this);
        this.junctionB = b;
        b.addRoad(this);
        this.semaphores = new ArrayList<Semaphore>();
        this.sensors = new ArrayList<Sensor>();
        this.vehicles = new ArrayList<>();
        roadElements.add(this);
    }


    //Methods

    public void addSemaphore(Semaphore s) {
        this.semaphores.add(s);
    }

    public void removeSemaphore(Semaphore s) throws SemaphoreNotFoundException {
        if(this.semaphores.contains(s)) {
            this.semaphores.remove(s);
        } else {
            throw new SemaphoreNotFoundException("Semaphore not found !");
        }
    }

    public void addSensor(Sensor s) {
        this.sensors.add(s);
    }

    public void removeSensor(Sensor s) throws SensorNotFoundException {
        if(this.sensors.contains(s)) {
            this.sensors.remove(s);
        } else {
            throw new SensorNotFoundException("Sensor not found !");
        }
    }

    public void addVehicle(Vehicle v) {
        vehicles.add(v);
    }

    public void removeVehicle(Vehicle v) throws VehicleNotFoundException {
        if(this.vehicles.contains(v)) {
            this.vehicles.remove(v);
        } else {
            throw new VehicleNotFoundException("Cannot find the vehicle to remove.");
        }
    }



    public void moveVehicles() throws VehicleNotFoundException {

        for(Sensor s: sensors) {
            s.regulateInterface.regulate();
        }


        ArrayList<Vehicle> toBeRemoved = new ArrayList<>();
        ArrayList<Vehicle> toBeAdded = new ArrayList<>();
        for (Vehicle vehicle : this.vehicles) {
            if(vehicle.checkPos()) {
                toBeAdded.add(vehicle);
                toBeRemoved.add(vehicle);
            }
            //System.out.println(vehicle.toString());
        }
        for(Vehicle v: toBeRemoved) {
            this.removeVehicle(v);
            v.getCurrState().getRoad().addVehicle(v);
        }


        for(Vehicle vehicle : this.vehicles) {
            for(Vehicle v : this.vehicles) {
                if(vehicle.getId()!=v.getId() && vehicle.getCurrState().equals(v.getCurrState())) {
                    System.out.println("COLLISION :");
                    System.out.print("La voiture d'ID " + vehicle.getId() + " sur la route d'ID " + vehicle.getCurrState().getRoad());
                    System.out.print(" est entree en collision avec ");
                    System.out.print(" la voiture d'ID " + v.getId() + " sur la route d'ID " + v.getCurrState().getRoad());

                }
                else System.out.println(vehicle.toString());
            }
        }


    }


    //Getters and setters

    public int getId() {
        return id;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
    }

    public Junction getJunctionA() {
        return junctionA;
    }

    public Junction getJunctionB() {
        return junctionB;
    }

    public ArrayList<Sensor> getSensors() {
        return sensors;
    }

    public static ArrayList<RoadElement> getRoadElements() {
        return roadElements;
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setJunctionA(Junction junctionA) throws JunctionException {
        if(this.junctionA!=null) {
            try {
                junctionA.removeRoad(this);
            }
            catch (RoadNotFoundException e) { // This should never happen.
                throw new JunctionException("The junctionA of this road does not contains this road in its linkedElements\nCritical error.");
            }
        }
        if(!junctionA.getLinkedElems().contains(this)) junctionA.addRoad(this);
        this.junctionA = junctionA;
    }

    public void setJunctionB(Junction junctionB) throws JunctionException {
        if(this.junctionB!=null) {
            try {
                junctionB.removeRoad(this);
            }
            catch (RoadNotFoundException e) { // This should never happen.
                throw new JunctionException("The junctionB of this road does not contains this road in its linkedElements\nCritical error.");
            }
        }
        if(!junctionB.getLinkedElems().contains(this)) junctionB.addRoad(this);
        this.junctionB = junctionB;
    }

    public ArrayList<Semaphore> getSemaphores() {
        return semaphores;
    }


    //Display

    @Override
    public String toString() {
        String output = "Segment --- id: " + this.getId() + " --- taille: " + this.size
                + " --- speedlimit: " + this.speedLimit + "\n jA: " + this.junctionA + " \n jB: " + this.junctionB +"\nSemaphores: \n";
        for (Semaphore e : this.semaphores) {
            output += e.toString() + "\n --- \n";
        }
        return output;
    }
}
