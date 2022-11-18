package application;

import application.Application;
import application.RoadElement;
import application.State;

public class Vehicle {
    private final int id;
    private State currState;

    //Constructors

    public Vehicle() {
        this.id = Application.idCounter;
        Application.idCounter++;

        this.currState = new State();
    }

    public Vehicle(State s) {
        this.id = Application.idCounter;
        Application.idCounter++;

        this.currState = new State(s.getRoad(), s.getPos(), s.getSpeed());
    }

    public Vehicle(RoadElement r, int pos, int speed) {
        this.id = Application.idCounter;
        Application.idCounter++;

        this.currState = new State(r, pos, speed);
    }

    //Getters and setters

    public int getId() {
        return id;
    }

    public State getCurrState() {
        return currState;
    }

    public void setCurrState(State currState) {
        this.currState = currState;
    }

    //Display

    @Override
    public String toString() {
        String output = "Vehicule --- id: " + this.id + " --- Etat: \n" + this.currState;
        return output;
    }
}
