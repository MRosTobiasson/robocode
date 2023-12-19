package mrt;

import robocode.AdvancedRobot;
import robocode.RobotDeathEvent;
import robocode.ScannedRobotEvent;

public class FirstRobot extends AdvancedRobot {
    private byte scanDirection = 1;
    private EnemyBot enemy = new EnemyBot();

    public void run() {
        setAdjustRadarForRobotTurn(true);
        enemy.reset();
        while (true) {
            setTurnRadarRight(360);
            execute();
        }
    }

    public void onScannedRobot(ScannedRobotEvent e) {
        setTurnRadarRight(getHeading() - getRadarHeading() + e.getBearing());
        if (enemy.none() || e.getName().equals(enemy.getName())) {
            enemy.update(e);
        }
        scanDirection *= -1;
        setTurnRadarRight(360 * scanDirection);

        if (enemy.none() ||
                e.getDistance() < enemy.getDistance() || e.getName().equals(enemy.getName())) {
            enemy.update(e);
        }
        fire(1);
    }

    public void onRobotDeath(RobotDeathEvent e) {
        if (e.getName().equals(enemy.getName())) {
            enemy.reset();
        }
    }
}
