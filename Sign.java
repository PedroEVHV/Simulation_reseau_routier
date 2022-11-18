package application;

public class Sign extends Semaphore{
    private int speed;

    //Constructors

    public Sign() {
        super();
        this.speed = 0;
    }

    public Sign(Sign s) {
        super();
        this.speed = s.speed;
    }

    public Sign(int s) {
        super();
        this.speed = s;
    }

    //Getters and Setters

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }


    //Display

    @Override
    public String toString() {
        return "Panneau --- id: " + this.getId() + " --- limite: " + this.speed;
    }
}
