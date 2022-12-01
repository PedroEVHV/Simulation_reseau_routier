package application.roadNetwork;

public class BiColorTL extends TrafficLight {

    //Constructors

    public BiColorTL(RoadElement r) {
        super(r, "green"); //The Traffic Light is initialized as green by default
    }

    public BiColorTL(RoadElement r, boolean direction) {
        super(r, direction, "green"); //The Traffic Light is initialized as green by default
    }

    public BiColorTL(RoadElement r, String color) {
        super(r, color);
    }

    public BiColorTL(RoadElement r, boolean direction, String color) {
        super(r, direction, color);
    }


    //Methods

    public void nextLight() {
        if(this.getColor().equals("green")) this.setColor("red");
        else this.setColor("green");

    }


    //Display

    @Override
    public String toString() {
        return "Feu bicolore --- id: " + this.getId() + " --- couleur: " + this.getColor();
    }
}
