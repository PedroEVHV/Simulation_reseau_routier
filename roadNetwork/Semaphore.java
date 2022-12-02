package application.roadNetwork;

import application.app.Application;

public abstract class Semaphore {
    private final int id;
    private RoadElement road;
    private boolean direction; // True when it is seen by cars going towards JunctionA, and vice-versa.
    protected InteractInterface interactInterface;


    //Constructors

    public Semaphore(RoadElement road) {
        this(road,true);
    }

    public Semaphore(RoadElement road, boolean direction) {
        this.id = Application.idCounter++;
        this.road = road;
        this.direction = direction;
        road.addSemaphore(this);
    }


    //Getters and Setters

    public int getId() {
        return id;
    }

    public RoadElement getRoad() {
        return road;
    }

    public boolean getDir() {
        return this.direction;
    }

    void setDirection(boolean direction) {
        this.direction = direction;
    }
}
