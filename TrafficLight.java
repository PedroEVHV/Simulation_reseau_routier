package application;

public abstract class TrafficLight extends Semaphore {
    private int color;
    private final int nbColors;

    //Constructors

    public TrafficLight() {
        super();
        this.color = 0;
        this.nbColors = 3; //By default, Traffic Lights will be tri-colored
    }

    public TrafficLight(TrafficLight t) {
        super();
        this.color = t.color;
        this.nbColors = t.nbColors;
    }

    public TrafficLight(int color, int nbColors) {
        super();
        this.color = color;
        this.nbColors = nbColors;
    }

    //Getters and Setters

    public int getColor() {
        return color;
    }

    public int getNbColors() {
        return nbColors;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
