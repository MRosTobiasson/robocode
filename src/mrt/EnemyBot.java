package mrt;

import robocode.ScannedRobotEvent;

public class EnemyBot {

    private double bearing;
    private double distance;
    private double energy;
    private double heading;
    private String name;
    private double velocity;

    // Public accessor methods
    public double getBearing() {
        return bearing;
    }

    public double getDistance() {
        return distance;
    }

    public double getEnergy() {
        return energy;
    }

    public double getHeading() {
        return heading;
    }

    public String getName() {
        return name;
    }

    public double getVelocity() {
        return velocity;
    }

    public void update(ScannedRobotEvent event) {
        this.bearing = event.getBearing();
        this.distance = event.getDistance();
        this.energy = event.getEnergy();
        this.heading = event.getHeading();
        this.name = event.getName();
        this.velocity = event.getVelocity();
    }

    public void reset() {
        this.name = "";
        this.bearing = 0.0;
        this.distance = 0.0;
        this.energy = 0.0;
        this.heading = 0.0;
        this.velocity = 0.0;
    }

    public boolean none() {
        return name.equals("");
    }

    public EnemyBot() {
        reset();
    }
}
