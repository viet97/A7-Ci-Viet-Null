package controller.managers;

import controller.*;
import model.Model;
import utils.Utils;
import view.View;

import java.awt.*;

/**
 * Created by Dell on 16/12/2016.
 */
public class BulletManager extends ControllerManager {
    public void shoot(int x,int y){
        Bulletcontroller bulletcontroller = new Bulletcontroller(
                new Model(x,y,12,30),
                new View(Utils.loadimage("resources/bullet.png"))
        );
        controllers.add(bulletcontroller);
    }
    public void draw(Graphics g){
        for (Controller controller : controllers)
            controller.draw(g);
    }
    public void run(){
        super.run();
        for (Controller controller : controllers)
            controller.run();
    }

}
