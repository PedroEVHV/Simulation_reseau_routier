package application.roadNetwork;

import java.util.Objects;

public class TriColorTL extends TrafficLight{


    //Constructors


    public TriColorTL(RoadElement r) {
        super(r, "green"); //The Traffic Light is initialized at green by default

        regulElem = (v) -> {
            if(this.getDir() == v.getCurrState().getDir() && v.getCurrState().getPos() > 1 && Objects.equals(this.getColor(), "orange")) {
                v.getCurrState().setSpeed(v.getCurrState().getSpeed()/2);
            } else if (this.getDir() == v.getCurrState().getDir() && v.getCurrState().getPos() > 1 && Objects.equals(this.getColor(), "red")) {
                v.getCurrState().setSpeed(0);
            }
        };
    }

    public TriColorTL(RoadElement r, boolean direction) {
        super(r, direction, "green"); //The Traffic Light is initialized as green by default
        regulElem = (v) -> {
            if(this.getDir() == v.getCurrState().getDir() && v.getCurrState().getPos() > 1 && Objects.equals(this.getColor(), "orange")) {
                v.getCurrState().setSpeed(v.getCurrState().getSpeed()/2);
            } else if (this.getDir() == v.getCurrState().getDir() && v.getCurrState().getPos() > 1 && Objects.equals(this.getColor(), "red")) {
                v.getCurrState().setSpeed(0);
            }
        };
    }

    public TriColorTL(RoadElement r, String color) {
        super(r, color);
        regulElem = (v) -> {
            if(this.getDir() == v.getCurrState().getDir() && v.getCurrState().getPos() > 1 && Objects.equals(this.getColor(), "orange")) {
                v.getCurrState().setSpeed(v.getCurrState().getSpeed()/2);
            } else if (this.getDir() == v.getCurrState().getDir() && v.getCurrState().getPos() > 1 && Objects.equals(this.getColor(), "red")) {
                v.getCurrState().setSpeed(0);
            }
        };
    }

    public TriColorTL(RoadElement r, boolean direction, String color) {
        super(r, direction, color);
        regulElem = (v) -> {
            if(this.getDir() == v.getCurrState().getDir() && v.getCurrState().getPos() > 1 && Objects.equals(this.getColor(), "orange")) {
                v.getCurrState().setSpeed(v.getCurrState().getSpeed()/2);
            } else if (this.getDir() == v.getCurrState().getDir() && v.getCurrState().getPos() > 1 && Objects.equals(this.getColor(), "red")) {
                v.getCurrState().setSpeed(0);
            }
        };
    }


    //Methods

    public void nextLight() {
        if(this.getColor().equals("orange")) this.setColor("red");
        else if(this.getColor().equals("red")) this.setColor("green");
        else setColor("orange");
    }


    //Display

    @Override
    public String toString() {
        return "Feu tricolore --- id: " + this.getId() + " --- etat: " + this.getColor();
    }
}
