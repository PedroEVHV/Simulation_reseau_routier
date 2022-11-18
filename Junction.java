package application;

import java.util.ArrayList;

public class Junction {
    private int id;
    private int nbLinks;
    private ArrayList<RoadElement> linkedElems;

    //Constructors

    public Junction() {
        this.id = Application.idCounter;
        Application.idCounter++;

        this.nbLinks = 0;
        this.linkedElems = new ArrayList<>();
    }

    public Junction(Junction junction) {
        this.id = Application.idCounter;
        Application.idCounter++;

        this.nbLinks = junction.nbLinks;
        this.linkedElems = new ArrayList<>();
    }

    public Junction(int nbLinks, ArrayList<RoadElement> roadElements) {
        this.id = Application.idCounter;
        Application.idCounter++;

        this.nbLinks = nbLinks;
        this.linkedElems =roadElements;
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

    public void setLinkedElems(ArrayList<RoadElement> linkedElems) {
        this.linkedElems = linkedElems;
    }

    public void setNbLinks(int nbLinks) {
        this.nbLinks = nbLinks;
    }

    //Display

    @Override
    public String toString() {
        String output = "Jonction --- id: " + this.id + " --- connections: " + this.nbLinks + "\nroutes: \n";
        for (RoadElement linkedElem : this.linkedElems) {
            output += linkedElem.toString() + "\n --- \n";
        }
        return output;
    }
}


