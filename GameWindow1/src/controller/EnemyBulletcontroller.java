package controller;

import controller.managers.BodyManager;
import model.Model;
import utils.Utils;
import view.View;

/**
 * Created by Dell on 08/12/2016.
 */
public class EnemyBulletcontroller extends Controller implements Body{
    public static final int WITDH = 32;
    public static final int HEIGHT = 32;
    public static final int SPEED = 7;


    public EnemyBulletcontroller(Model model, View view) {
        super(model, view);
    }
    public void run(){
        model.move(0,SPEED);
        BodyManager.instance.register(this);
    }

    public static EnemyBulletcontroller creat(int x, int y){
        EnemyBulletcontroller enemyBulletcontroller= new EnemyBulletcontroller(new Model(x,y,WITDH,HEIGHT),new View(Utils.loadimage("resources/enemy_bullet.png")));
        return enemyBulletcontroller;

    }

    @Override
    public void onContact(Body other) {
        if (other instanceof Planecontroller) {
            System.out.println("111");
            this.model.setAlive(false);
            BodyManager.instance.remove(this);
        }
    }
}
