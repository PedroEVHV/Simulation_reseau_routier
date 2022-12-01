package application;

import application.exceptions.JunctionException;
import application.exceptions.RoadNotFoundException;
import application.exceptions.SemaphoreNotFoundException;
import application.exceptions.SensorNotFoundException;

import java.util.ArrayList;

public class RoadElement {
    private final int id;
    private int size;
    private Junction junctionA;
    private Junction junctionB;
    private int speedLimit;
    private ArrayList<Semaphore> semaphores;
    private ArrayList<Sensor> sensors;


    //Constructors

    public RoadElement() {
        this(10, 50, new Junction(), new Junction());
    }

    public RoadElement(int size, int speedLimit) {
        this(size, speedLimit, new Junction(), new Junction());
    }

    public RoadElement(int size, int speedLimit, Junction a, Junction b) {
        this.id = Application.idCounter++;
        this.size = size;
        this.speedLimit = speedLimit;
        this.junctionA = a;
        a.addRoad(this);
        this.junctionB = b;
        b.addRoad(this);
        this.semaphores = new ArrayList<Semaphore>();
        this.sensors = new ArrayList<Sensor>();
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

    public void setJunctionA(Junction junctionA) throws JunctionException {
        if(this.junctionA!=null) try {
            junctionA.removeRoad(this);
        }
        catch (RoadNotFoundException e) { // This should never happen.
            throw new JunctionException("The junctionA of this road does not contains this road in its linkedElements\nCritical error.");
        }
        if(!junctionA.getLinkedElems().contains(this)) junctionA.addRoad(this);
        this.junctionA = junctionA;
    }

    public void setJunctionB(Junction junctionB) throws JunctionException {
        if(this.junctionB!=null) try {
            junctionB.removeRoad(this);
        }
        catch (RoadNotFoundException e) { // This should never happen.
            throw new JunctionException("The junctionB of this road does not contains this road in its linkedElements\nCritical error.");
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
