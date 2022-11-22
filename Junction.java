package application;

import application.exceptions.RoadNotFoundException;

import java.util.ArrayList;

public class Junction {
    private int id;
    private int nbLinks;
    private ArrayList<RoadElement> linkedElems;

    //Constructors

    public Junction() {
        this(new ArrayList<>());
    }

    public Junction(ArrayList<RoadElement> roadElements) {
        this.id = Application.idCounter++;
        this.nbLinks = 0;
        this.linkedElems = roadElements;
    }

    //Methods

    public void addRoad(RoadElement r) {
        this.linkedElems.add(r);
        ++nbLinks;
    }

    public void removeRoad(RoadElement r) throws RoadNotFoundException {
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

    public ArrayList<RoadElement> getLinkedElems() {
        return linkedElems;
    }

    public int getNbLinks() {
        return nbLinks;
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


