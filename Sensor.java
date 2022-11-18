package application;

import java.util.ArrayList;

public abstract class Sensor {
    private final int id;
    private RoadElement road;
    private int pos;
    private ArrayList<Semaphore> semaphores;

    //Constructors

    public Sensor () {
        this.id = Application.idCounter;
        Application.idCounter++;

        this.road = null;
        this.pos = 0;
        this.semaphores = new ArrayList<>();
    }

    public Sensor (RoadElement r, int p, ArrayList<Semaphore> s) {
        this.id = Application.idCounter;
        Application.idCounter++;

        this.road = r;
        this.pos = p;
        this.semaphores = s;
    }

    //Getters and Setters

    public RoadElement getRoad() {
        return road;
    }

    public int getId() {
        return id;
    }

    public int getPos() {
        return pos;
    }

    public ArrayList<Semaphore> getSemaphores() {
        return semaphores;
    }

    public void setRoad(RoadElement road) {
        this.road = road;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public void setSemaphores(ArrayList<Semaphore> semaphores) {
        this.semaphores = semaphores;
    }



}
