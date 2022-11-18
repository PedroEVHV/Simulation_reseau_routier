package application;

public class TriColorTL extends TrafficLight{

    //Constructors

    public TriColorTL() {
        super(); //The Traffic Light is initialized at 0 by default
    }

    public TriColorTL(TriColorTL tl) {
        super(tl.getColor(), tl.getNbColors());
    }

    public TriColorTL(int c) {
        super(c, 3);
    }

    //Display

    @Override
    public String toString() {
        return "Feu tricolore --- id: " + this.getId() + " --- etat: " + this.getColor();
    }
}
