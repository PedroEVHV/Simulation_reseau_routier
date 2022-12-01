package application;

public class TriColorTL extends TrafficLight{

    //Constructors

    public TriColorTL(RoadElement r) {
        super(r, "orange", true); //The Traffic Light is initialized at 0 by default
    }

    public TriColorTL(RoadElement r, boolean direction) {
        super(r, direction, "orange", true); //The Traffic Light is initialized at 0 by default
    }

    public TriColorTL(RoadElement r, String color) {
        super(r, color);
    }

    public TriColorTL(RoadElement r, boolean direction, String color) {
        super(r, direction, color);
    }

    public TriColorTL(RoadElement r, String color, boolean blinking) {
        super(r, color, blinking);
    }

    public TriColorTL(RoadElement r, boolean direction, String color, boolean blinking) {
        super(r, direction, color, blinking);
    }


    //Methods

    public void nextLight() {
        if(this.getColor().equals("orange") && this.isBlinking()) {}
        else if(isBlinking()) setBlinking(false);
        else if(this.getColor().equals("orange")) this.setColor("red");
        else if(this.getColor().equals("red")) this.setColor("green");
        else setColor("orange");
    }


    //Display

    @Override
    public String toString() {
        return "Feu tricolore --- id: " + this.getId() + " --- etat: " + this.getColor();
    }
}
