package application;

public abstract class Semaphore {
    private final int id;
    private RoadElement road;
    private boolean direction;

    //Constructors

    public Semaphore() {
        this.id = Application.idCounter;
        Application.idCounter++;

        this.road = null;
        this.direction = true;
    }

    public Semaphore(RoadElement r, boolean d) {
        this.id = Application.idCounter;
        Application.idCounter++;

        this.road = r;
        this.direction = d;
    }

    /*
    POUR MATIU: Ici pas besoin de constructeur par copie, ça ne sert à rien
     */


    //Getters and Setters


    public RoadElement getRoad() {
        return road;
    }

    public int getId() {
        return id;
    }

    public boolean getDir() {
        return this.direction;
    }

    public void setDirection(boolean direction) {
        this.direction = direction;
    }

    public void setRoad(RoadElement road) {
        this.road = road;
    }
}
