package controller;

import model.Model;
import utils.Utils;
import view.View;

/**
 * Created by Dell on 08/12/2016.
 */
public class EnemyPlanecontroller extends Controller implements Runnable{

    public EnemyPlanecontroller(Model model, View view) {
        super(model, view);
    }

    public void run(){
                    model.move(0,+5);
   }

    public static EnemyPlanecontroller createEnemyPlane(int x,int y){
        EnemyPlanecontroller enemyPlanecontroller = new EnemyPlanecontroller(
                new Model(x,y,70,50),
                new View(Utils.loadimage("resources/enemy_plane_white_1.png")));
        return enemyPlanecontroller;
    }
}
