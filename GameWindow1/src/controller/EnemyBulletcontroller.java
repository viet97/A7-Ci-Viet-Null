package controller;

import model.Model;
import view.View;

/**
 * Created by Dell on 08/12/2016.
 */
public class EnemyBulletcontroller extends Controller {

    public EnemyBulletcontroller(Model model, View view) {
        super(model, view);
    }
    public void move(){
        model.move(0,+5);
    }
}
