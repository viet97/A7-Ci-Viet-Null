package controller;

import controller.Controller;
import controller.managers.BodyManager;
import model.Model;
import view.View;

import java.awt.*;
import java.util.Iterator;

/**
 * Created by Dell on 05/12/2016.
 */
public class Bulletcontroller extends Controller implements Body {

    public Bulletcontroller(Model model, View view) {
        super(model, view);
        BodyManager.instance.register(this);
    }

    public void run(){
        model.move(0,-5);
    }

    @Override
    public void onContact(Body other) {
        if(other instanceof EnemyPlanecontroller) {
            System.out.println("Oh yeah");
            this.model.setAlive(false);
            BodyManager.instance.remove(this);
        }
    }

}
