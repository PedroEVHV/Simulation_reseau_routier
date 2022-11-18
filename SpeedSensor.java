package application;

import java.util.ArrayList;

public class SpeedSensor extends Sensor{
    private int speedTrigger;

    //Constructors
    public SpeedSensor() {
        super();
        this.speedTrigger = 0;
    }

    public SpeedSensor(SpeedSensor s) {
        super(s.getRoad(), s.getPos(), s.getSemaphores());
        this.speedTrigger = s.speedTrigger;
    }

    public SpeedSensor(int s, RoadElement r, int p, ArrayList<Semaphore> semaphores) {
        super(r, p, semaphores);
        this.speedTrigger = s;
    }

    //Getters and Setters

    public int getSpeedTrigger() {
        return speedTrigger;
    }

    public void setSpeedTrigger(int speedTrigger) {
        this.speedTrigger = speedTrigger;
    }


    //Display

    @Override
    public String toString() {
        String output = "Capteur Vitesse --- id: " + this.getId() + " --- position: " + this.getPos()
                + "\nroute: "+ this.getRoad().toString()+ "\nsemaphores: \n";
        for (Semaphore e : this.getSemaphores()) {
            output += e.toString() + "\n --- \n";
        }
        return output;
    }
}
