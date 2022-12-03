package application.roadNetwork;

public class State {
    private RoadElement road;
    private int pos;
    private int speed;
    private boolean dir;

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
        this.dir = s.dir;
    }

    public State(RoadElement r, int p, int s, boolean d) {
        this.road = r;
        this.pos = p;
        this.speed = s;
        this.dir = d;
    }

    //Methods

    @Override
    public boolean equals(Object o) {
        if(o.getClass().getTypeName().equals("State")) {
            State aux = (State) o;
            return aux.dir == this.dir && aux.road == this.road && aux.pos == this.pos;
        } else {
            //TODO ajouter exception
        }
        return false;
    }


    //Getters and Setters

    public int getPos() {
        return pos;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean getDir() {return dir;};

    public void setDir(boolean dir) {
        this.dir = dir;
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
        String output = "Etat --- vitesse: " + this.speed + " --- position: " + this.pos + " --- route: " + this.getRoad().getId();
        return output;
    }
}
