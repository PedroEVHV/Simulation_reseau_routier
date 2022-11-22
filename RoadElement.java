package application;

import application.exceptions.JunctionException;
import application.exceptions.RoadNotFoundException;
import application.exceptions.SemaphoreNotFoundException;

import java.util.ArrayList;

public class RoadElement {

    private int id;
    private int size;
    private Junction junctionA;
    private Junction junctionB;
    private int speedLimit;

    private ArrayList<Semaphore> semaphores;

    //Constructors

    public RoadElement() {
        this.id = Application.idCounter++;
        this.size = 1;
        this.junctionA = null;
        this.junctionB = null;
        this.speedLimit = 1;
        this.semaphores = new ArrayList<Semaphore> ();
    }

    public RoadElement(int size, int speedLimit, Junction a, Junction b) {
        this(size, speedLimit, a, b, new ArrayList<>());
    }

    public RoadElement(int size, int speedLimit, Junction a, Junction b, ArrayList<Semaphore> s) {
        this.id = Application.idCounter++;
        try {
            this.setJunctionA(a);
            this.setJunctionB(b);
        }
        catch (JunctionException e) {
            System.err.println("Error while creating the road.");
        }
        this.size = size;
        this.speedLimit = speedLimit;
        this.semaphores = s;
    }

    //Methods

    public void addSemaphore(Semaphore s) {
        this.semaphores.add(s);
    }

    public void removeSemaphore(Semaphore s) throws SemaphoreNotFoundException {
        if(this.semaphores.contains(s)) {
            this.semaphores.remove(s);
        } else {
            throw new SemaphoreNotFoundException("Road not found!");
        }
    }

    //Getters and setters

    public int getId() {
        return id;
    }

    public int getSize() {
        return size;
    }

    public int getSpeedLimit() {
        return speedLimit;
    }

    public Junction getJunctionA() {
        return junctionA;
    }

    public Junction getJunctionB() {
        return junctionB;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setJunctionA(Junction junctionA) throws JunctionException {
        if(this.junctionA!=null) throw new JunctionException("There is already a junctionA for this road.");
        if(!junctionA.getLinkedElems().contains(this)) junctionA.addRoad(this);
        this.junctionA = junctionA;
    }

    public void setJunctionB(Junction junctionB) throws JunctionException {
        if(this.junctionB!=null) throw new JunctionException("There is already a junctionB for this road.");
        if(!junctionB.getLinkedElems().contains(this)) junctionB.addRoad(this);
        this.junctionB = junctionB;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
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
