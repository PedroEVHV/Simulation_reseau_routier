package application;

public abstract class TrafficLight extends Semaphore {
    private String color;
    private boolean blinking;


    //Constructors

    public TrafficLight(RoadElement r) {
        this(r, "green", true);
    }

    public TrafficLight(RoadElement r, boolean direction) {
        this(r, direction,  "green", true);
    }

    public TrafficLight(RoadElement r, String color) {
        this(r, color, false);
    }

    public TrafficLight(RoadElement r, boolean direction, String color) {
        this(r, direction, color, false);
    }

    public TrafficLight(RoadElement r, String color, boolean blinking) {
        super(r);
        this.color = color;
        this.blinking = blinking;
    }

    public TrafficLight(RoadElement r, boolean direction, String color, boolean blinking) {
        super(r,direction);
        this.color = color;
        this.blinking = blinking;
    }


    //Methods

    public abstract void nextLight();


    //Getters and Setters

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isBlinking() {
        return blinking;
    }

    public void setBlinking(boolean blinking) {
        this.blinking = blinking;
    }
}
