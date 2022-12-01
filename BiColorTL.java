package application;

public class BiColorTL extends TrafficLight {

    //Constructors

    public BiColorTL(RoadElement r) {
        super(r, "orange", true); //The Traffic Light is initialized at 0 by default
    }

    public BiColorTL(RoadElement r, boolean direction) {
        super(r, direction, "orange", true); //The Traffic Light is initialized at 0 by default
    }

    public BiColorTL(RoadElement r, String color) {
        super(r, color);
    }

    public BiColorTL(RoadElement r, boolean direction, String color) {
        super(r, direction, color);
    }

    public BiColorTL(RoadElement r, String color, boolean blinking) {
        super(r, color, blinking);
    }

    public BiColorTL(RoadElement r, boolean direction, String color, boolean blinking) {
        super(r, direction, color, blinking);
    }


    //Methods

    public void nextLight() {
        if(this.getColor().equals("orange")) {
            this.setColor("red");
            this.setBlinking(false);
        }
        else {
            this.setColor("orange");
            this.setBlinking(true);
        }
    }


    //Display

    @Override
    public String toString() {
        return "Feu bicolore --- id: " + this.getId() + " --- couleur: " + this.getColor();
    }
}
