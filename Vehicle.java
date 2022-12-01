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

    //Methods

    /**
     * Changes position on current road element. Does not change road elements, that is implemented in checkPos().
     */
    public void move() {

    }


    /**
     * Checks if the vehicle position is valid, i.e. if there is no collision, if the position after movement is in the same road element (if not, change road),
     * if the vehicle is allowed to move due to traffic lights, etc...
     * If all criteria are met, it will call the move function.
     */
    public void checkPos() {
        for(int i = 0; i < this.getCurrState().getRoad().getSemaphores().size(); i++) {

            this.getCurrState().getRoad().getSemaphores().get(i).regulElem.regulate(this);
        }
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
