package application.roadNetwork;

import application.app.Application;
import application.exceptions.SemaphoreNotFoundException;

import java.util.ArrayList;

public abstract class Sensor {
    private final int id;
    private RoadElement road;
    private int pos;
    private Boolean direction;
    private ArrayList<TrafficLight> trafficLights;

    protected RegulateInterface regulateInterface;


    //Constructors

    public Sensor(RoadElement r) {
        this(r, 0, true, new ArrayList<TrafficLight>());

    }

    public Sensor(RoadElement r, int p, boolean direction) {
        this(r, p, direction, new ArrayList<TrafficLight>());
    }

    public Sensor(RoadElement r, int p, boolean direction, ArrayList<TrafficLight> s) {
        this.id = Application.idCounter++;
        this.road = r;
        this.pos = p;
        this.direction = direction;
        this.trafficLights = s;
    }


    // Methods

    void addSemaphore(TrafficLight s) {
        this.trafficLights.add(s);
    }

    void removeSemaphore(Semaphore s) throws SemaphoreNotFoundException {
        if(this.trafficLights.contains(s)) {
            this.trafficLights.remove(s);
        } else {
            throw new SemaphoreNotFoundException("Semaphore not found !");
        }
    }


    //Getters and Setters

    public int getId() {
        return id;
    }

    public int getPos() {
        return pos;
    }

    void setPos(int pos) {
        this.pos = pos;
    }

    public Boolean getDirection() {
        return this.direction;
    }

    void setDirection(boolean direction) {
        this.direction = direction;
    }

    public RoadElement getRoad() {
        return road;
    }

    public ArrayList<TrafficLight> getTrafficLights() {
        return this.trafficLights;
    }
}
