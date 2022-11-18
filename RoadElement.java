package application;

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
        this.id = Application.idCounter;
        Application.idCounter++;

        this.size = 1;
        this.junctionA = null;
        this.junctionB = null;
        this.speedLimit = 1;

        this.semaphores = new ArrayList<Semaphore> ();
    }

    public RoadElement(RoadElement r, Junction a, Junction b, ArrayList<Semaphore> s) {
        this.id = Application.idCounter;
        Application.idCounter++;

        this.size = r.size;
        this.speedLimit = r.speedLimit;
        this.junctionA = a;
        this.junctionB = b;

        this.semaphores = s;
    }

    public RoadElement(int size, int speedLimit, Junction a, Junction b, ArrayList<Semaphore> s) {
        this.id = Application.idCounter;
        Application.idCounter++;

        this.junctionB = b;
        this.junctionA = a;
        this.size = size;
        this.speedLimit = speedLimit;

        this.semaphores = s;
    }

    //Methods


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

    public void setJunctionA(Junction junctionA) {
        this.junctionA = junctionA;
    }

    public void setJunctionB(Junction junctionB) {
        this.junctionB = junctionB;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
    }

    public void setSemaphores(ArrayList<Semaphore> semaphores) {
        this.semaphores = semaphores;
    }

    //Display

    @Override
    public String toString() {
        String output = "Segment --- id: " + this.getId() + " --- taille: " + this.size
                + "speedlimit: " + this.speedLimit + "\n jA: " + this.junctionA.getId() + " --- jB: " + this.junctionB.getId() +"\nsemaphores: \n";
        for (Semaphore e : this.semaphores) {
            output += e.toString() + "\n --- \n";
        }
        return output;
    }
}
