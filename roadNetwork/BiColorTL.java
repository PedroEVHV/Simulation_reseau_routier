package application.roadNetwork;

import java.util.Objects;

public class BiColorTL extends TrafficLight {

    //Constructors

    public BiColorTL(RoadElement r) {
        super(r, "green"); //The Traffic Light is initialized as green by default

        interactInterface = (v) -> {

        };
    }

    public BiColorTL(RoadElement r, boolean direction) {
        super(r, direction, "green"); //The Traffic Light is initialized as green by default
        interactInterface = (v) -> {
            if(this.getDir() == v.getCurrState().getDir() && v.getCurrState().getPos() > 1 && Objects.equals(this.getColor(), "red")) {
                v.getCurrState().setSpeed(0);
            }
        };
    }

    public BiColorTL(RoadElement r, String color) {
        super(r, color);
        interactInterface = (v) -> {
            if(this.getDir() == v.getCurrState().getDir() && v.getCurrState().getPos() > 1 && Objects.equals(this.getColor(), "red")) {
                v.getCurrState().setSpeed(0);
            }
        };
    }

    public BiColorTL(RoadElement r, boolean direction, String color) {
        super(r, direction, color);
        interactInterface = (v) -> {
            if(this.getDir() == v.getCurrState().getDir() && v.getCurrState().getPos() > 1 && Objects.equals(this.getColor(), "red")) {
                v.getCurrState().setSpeed(0);
            }
        };
    }


    //Methods

    void nextLight() {
        if(this.getColor().equals("green")) this.setColor("red");
        else this.setColor("green");

    }


    //Display

    @Override
    public String toString() {
        return "Feu bicolore --- id: " + this.getId() + " --- couleur: " + this.getColor();
    }
}
