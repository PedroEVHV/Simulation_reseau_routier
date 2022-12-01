package application.roadNetwork;

public class SpeedSign extends Semaphore{
    private int speed;


    //Constructors

    public SpeedSign(RoadElement r) {
        super(r);
        this.speed = 50;
    }

    public SpeedSign(RoadElement r, boolean direction) {
        super(r, direction);
        this.speed = 50;
    }

    public SpeedSign(RoadElement r, int speed) {
        super(r);
        this.speed = speed;
    }

    public SpeedSign(RoadElement r, boolean direction, int speed) {
        super(r, direction);
        this.speed = speed;
    }

    //Getters and Setters

    public int getSpeed() {
        return speed;
    }

    void setSpeed(int speed) {
        this.speed = speed;
    }


    //Display

    @Override
    public String toString() {
        return "Panneau --- id: " + this.getId() + " --- limite: " + this.speed;
    }
}
