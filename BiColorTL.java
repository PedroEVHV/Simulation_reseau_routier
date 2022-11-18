package application;

public class BiColorTL extends TrafficLight{
    //Constructors

    public BiColorTL() {
        super(0, 2); //The Traffic Light is initialized at 0 by default
    }

    public BiColorTL(BiColorTL tl) {
        super(tl.getColor(), tl.getNbColors());
    }

    public BiColorTL(int c) {
        super(c, 2);
    }


    //Display

    @Override
    public String toString() {
        return "Feu bicolore --- id: " + this.getId() + " --- couleur: " + this.getColor();
    }
}
