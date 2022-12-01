package application.roadNetwork;

public abstract class TrafficLight extends Semaphore {
    private String color;


    //Constructors

    public TrafficLight(RoadElement r) {
        this(r, "green");
    }

    public TrafficLight(RoadElement r, boolean direction) {
        this(r, direction,  "green");
    }

    public TrafficLight(RoadElement r, String color) {
        super(r);
        this.color = color;
    }

    public TrafficLight(RoadElement r, boolean direction, String color) {
        super(r,direction);
        this.color = color;
    }


    //Methods

    abstract void nextLight();


    //Getters and Setters

    public String getColor() {
        return color;
    }

    void setColor(String color) {
        this.color = color;
    }
}
