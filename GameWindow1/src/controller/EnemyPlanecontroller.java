package controller;

import controller.managers.BodyManager;
import model.Model;
import utils.Utils;
import view.View;

import java.awt.*;
import java.util.Vector;

/**
 * Created by Dell on 08/12/2016.
 */
public class EnemyPlanecontroller extends Controller implements Body  {
    private int HP = 2;
    private int timecounter=0;
    private int n;

    public void setN(int n) {
        this.n = n;
    }

    Vector<EnemyBulletcontroller> enemyBulletcontrollers;
    public EnemyPlanecontroller(Model model, View view) {
        super(model, view);
        enemyBulletcontrollers = new Vector<>();
        BodyManager.instance.register(this);
    }

    public void run() {
      if (this.n ==1) model.move(0, +1);
      else model.move(-1,1);
        if(timecounter>30){
            Shoot();
            timecounter =0;
        }

        timecounter++;
        for(EnemyBulletcontroller enemyBulletcontroller: enemyBulletcontrollers)
            enemyBulletcontroller.run();
    }


    private void Shoot() {
        EnemyBulletcontroller enemyBulletcontroller = EnemyBulletcontroller.creat(
                this.model.getMidx() - EnemyBulletcontroller.WITDH/2,
                this.model.getMidy()
        );

        this.enemyBulletcontrollers.add(enemyBulletcontroller);
    }
    public void draw(Graphics g){
        super.draw(g);

        for(EnemyBulletcontroller enemyBulletcontroller : this.enemyBulletcontrollers){
            if (enemyBulletcontroller.getModel().isAlive())enemyBulletcontroller.draw(g);
        }
    }

    public static EnemyPlanecontroller createEnemyPlane(int x,int y){
        EnemyPlanecontroller enemyPlanecontroller = new EnemyPlanecontroller(
                new Model(x,y,32,32),
                new View(Utils.loadimage("resources/enemy_plane_white_1.png")));
        return enemyPlanecontroller;
    }

    @Override
    public void onContact(Body other) {

        if (other instanceof Bulletcontroller) {
            System.out.println("huhu");
            HP = HP - 1;
            if(HP == 0) {
                this.model.setAlive(false);
                BodyManager.instance.remove(this);
            }
        }
    }
}
