package controller.managers;

import controller.EnemyPlanecontroller;

import java.awt.*;
import java.util.Vector;

/**
 * Created by Dell on 10/12/2016.
 */
public class EnemyControllerManager extends ControllerManager {
    private int timecounter =0 ;

    public void spawn() {
        timecounter++;
        if(timecounter>50) {
            EnemyPlanecontroller enemyPlanecontroller = EnemyPlanecontroller.createEnemyPlane(300, 0);
            controllers.add(enemyPlanecontroller);
            enemyPlanecontroller.setN(1);
            EnemyPlanecontroller enemyPlanecontroller1 = EnemyPlanecontroller.createEnemyPlane(600, 0);
            controllers.add(enemyPlanecontroller1);
            enemyPlanecontroller1.setN(0);
            timecounter =0;
        }
    }


    public void run(){
        super.run();;
        spawn();
    }

}
