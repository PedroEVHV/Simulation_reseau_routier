package application.roadNetwork;

import application.app.Application;
import application.exceptions.RoadNotFoundException;

import java.util.ArrayList;

public class Junction {
    private final int id;
    private int nbLinks;
    private ArrayList<RoadElement> linkedElems;
    public static int idCounter = 0;


    //Constructors

    public Junction() {
        this.id = idCounter++;
        this.nbLinks = 0;
        this.linkedElems = new ArrayList<RoadElement>();
    }


    //Methods

    void addRoad(RoadElement r) {
        this.linkedElems.add(r);
        ++nbLinks;
    }

    void removeRoad(RoadElement r) throws RoadNotFoundException {
        if(this.linkedElems.contains(r)) {
            this.linkedElems.remove(r);
            this.nbLinks--;
        } else {
            throw new RoadNotFoundException("Road not found!");
        }
    }


    //Getters and Setters

    public int getId() {
        return id;
    }

    public int getNbLinks() {
        return nbLinks;
    }

    public ArrayList<RoadElement> getLinkedElems() {
        return linkedElems;
    }


    //Display

    @Override
    public String toString() {
        String output = "Jonction --- id: " + this.id + " --- connections: " + this.nbLinks + " --- routes:\t";
        for (RoadElement linkedElem : this.linkedElems) {
            output += linkedElem.getId() + "\t";
        }
        return output;
    }
}


