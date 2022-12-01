package application.roadNetwork;

import application.app.Application;
import application.exceptions.SemaphoreNotFoundException;
import application.exceptions.SensorNotFoundException;

import java.util.ArrayList;

public abstract class Sensor {
    private final int id;
    private RoadElement road;
    private int pos;
    protected RegulateInterface regulateInterface;
    private Boolean direction;
    private ArrayList<Semaphore> semaphores;

    //Constructors

    public Sensor () {
        this.id = Application.idCounter++;
        this.road = null;
        this.pos = 0;
        this.semaphores = new ArrayList<Semaphore>();
        this.direction = true;
    }

    public Sensor (RoadElement r, int p, Boolean direction, ArrayList<Semaphore> s) {
        this.id = Application.idCounter++;
        this.road = r;
        this.pos = p;
        this.semaphores = s;
        this.direction = direction;
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

    public Boolean getDirection() {
        return this.direction;
    }

    public ArrayList<Semaphore> getSemaphores() {
        return this.semaphores;
    }

    public void setRoad(RoadElement road) {
        if(this.road != null) {
            try {
                this.road.removeSensor(this);
            }
            catch (SensorNotFoundException e) {
                System.err.println("This should never happen.");
            }
        }
        road.addSensor(this);
        this.road = road;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public void setSemaphores(ArrayList<Semaphore> semaphores) {
        this.semaphores = semaphores;
    }

    // Methods

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

}
