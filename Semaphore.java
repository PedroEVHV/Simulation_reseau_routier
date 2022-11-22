package application;

import application.exceptions.SemaphoreNotFoundException;

public abstract class Semaphore {
    private final int id;
    private RoadElement road;
    private boolean direction;

    //Constructors

    public Semaphore() {
        this.id = Application.idCounter++;
        this.road = null;
        this.direction = true;
    }

    public Semaphore(RoadElement r, boolean d) {
        this.id = Application.idCounter++;
        this.road = r;
        this.direction = d;
    }

    //Getters and Setters


    public RoadElement getRoad() {
        return road;
    }

    public int getId() {
        return id;
    }

    public boolean getDir() {
        return this.direction;
    }

    void setRoad(RoadElement r) {
        if(this.road != null) {
            try {
                this.road.removeSemaphore(this);
            }
            catch (SemaphoreNotFoundException e) {
                System.err.println("This should never happen.");
            }
        }
        r.addSemaphore(this);
        this.road = r;
    }
}
