package application.roadNetwork;

import application.app.Application;

import java.util.Random;

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

        this.currState = new State(s.getRoad(), s.getPos(), s.getSpeed(), s.getDir());
    }

    public Vehicle(RoadElement r, int pos, int speed, boolean dir) {
        this.id = Application.idCounter;
        Application.idCounter++;

        this.currState = new State(r, pos, speed, dir);
    }

    //Methods

    /**
     * Changes position on current road element. Does not change road elements, that is implemented in checkPos().
     */
    public void move() {
        this.getCurrState().setPos(this.getCurrState().getSpeed() + this.getCurrState().getPos());
    }


    /**
     * Checks if the vehicle position is valid, i.e. if there is no collision, if the position after movement is in the same road element (if not, change road),
     * if the vehicle is allowed to move due to traffic lights, etc...
     * If all criteria are met, it will call the move function.
     */
    public void checkPos() {

        Random rs = new Random();

        for (int i = 0; i < this.getCurrState().getRoad().getSensors().size(); i++) {
            this.getCurrState().getRoad().getSensors().get(i).regulateInterface.regulate();
        }

        for(int i = 0; i < this.getCurrState().getRoad().getSemaphores().size(); i++) {

            this.getCurrState().getRoad().getSemaphores().get(i).interactInterface.interact(this);
        }

        if(this.getCurrState().getDir() && this.getCurrState().getPos() + this.getCurrState().getSpeed() > this.getCurrState().getRoad().getSize()) {
            int max = this.getCurrState().getRoad().getJunctionB().getLinkedElems().size();
            int select = rs.ints(1, 0, max).findFirst().getAsInt();

            if(this.getCurrState().getRoad().getJunctionB().getLinkedElems().size() == 1) {
                this.getCurrState().setPos(0);
                this.getCurrState().setDir(!this.getCurrState().getDir());

            } else {
                while(this.getCurrState().getRoad().getJunctionB().getLinkedElems().get(select) == this.getCurrState().getRoad()) {
                    select = rs.ints(1, 0, max).findFirst().getAsInt();
                }
                this.getCurrState().setRoad(this.getCurrState().getRoad().getJunctionB().getLinkedElems().get(select));
                this.getCurrState().setPos(0);
            }


        } else if(!this.getCurrState().getDir() && this.getCurrState().getPos() + this.getCurrState().getSpeed() > this.getCurrState().getRoad().getSize()) {

            int max = this.getCurrState().getRoad().getJunctionA().getLinkedElems().size();
            int select = rs.ints(1, 0, max).findFirst().getAsInt();

            if(this.getCurrState().getRoad().getJunctionA().getLinkedElems().size() == 1) {
                this.getCurrState().setPos(0);
                this.getCurrState().setDir(!this.getCurrState().getDir());

            } else {
                while(this.getCurrState().getRoad().getJunctionA().getLinkedElems().get(select) == this.getCurrState().getRoad()) {
                    select = rs.ints(1, 0, max).findFirst().getAsInt();
                }
                this.getCurrState().setRoad(this.getCurrState().getRoad().getJunctionA().getLinkedElems().get(select));
                this.getCurrState().setPos(0);
            }

        } else {
            this.move();
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
