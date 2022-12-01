package application.roadNetwork;

import java.util.ArrayList;

public class PosSensor extends Sensor{

    //Constructors
    public PosSensor() {
        super();
    }

    public PosSensor(PosSensor p) {
        super(p.getRoad(), p.getPos(), p.getDirection(), p.getSemaphores());
    }

    public PosSensor(RoadElement r, int p, Boolean direction, ArrayList<Semaphore> semaphores) {
        super(r, p, direction, semaphores);
    }

    //Display

    @Override
    public String toString() {
        String output = "Capteur Position --- id: " + this.getId() + " --- position: " + this.getPos() + "\nsemaphores: \n";
        for (Semaphore e : this.getSemaphores()) {
            output += e.toString() + "\n --- \n";
        }
        return output;
    }
}
