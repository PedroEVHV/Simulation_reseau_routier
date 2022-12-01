package application.roadNetwork;

public class State {
    private RoadElement road;
    private int pos;
    private int speed;

    //Constructors

    public State() {
        this.road = null;
        this.pos = 0;
        this.speed = 0;
    }

    public State(State s) {
        this.road = s.road;
        this.pos = s.pos;
        this.speed = s.speed;
    }

    public State(RoadElement r, int p, int s) {
        this.road = r;
        this.pos = p;
        this.speed = s;
    }


    //Getters and Setters

    public int getPos() {
        return pos;
    }

    public int getSpeed() {
        return speed;
    }

    public RoadElement getRoad() {
        return road;
    }

    void setPos(int pos) {
        this.pos = pos;
    }

    void setRoad(RoadElement road) {
        this.road = road;
    }

    void setSpeed(int speed) {
        this.speed = speed;
    }


    //Display

    @Override
    public String toString() {
        String output = "Etat --- vitesse: " + this.speed + " --- position: " + this.pos;
        return output;
    }
}
