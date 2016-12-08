package controller;


//import controller.Controller;

import model.Model;
import utils.Utils;
import view.View;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Dell on 05/12/2016.
 */
public class Planecontroller extends Controller{
    private static final int SPEED = 5;

    public KeySetting keySetting;

    public Planecontroller(Model model, View view) {
        super(model, view);
    }


    public void Keypressed(KeyEvent e){
        int keyCode;
        keyCode = e.getKeyCode();
        if(keyCode == keySetting.keyup)
            model.move(0,-SPEED);
        else if(keyCode==keySetting.keydown)
            model.move(0,SPEED);
        else if(keyCode==keySetting.keyleft)
            model.move(-SPEED,0);
        else if(keyCode==keySetting.keyright)
            model.move(SPEED,0);
    }
    public static Planecontroller createPlane(int x,int y){
        Planecontroller planecontroller = new Planecontroller(new Model(x,y,70,50),new View(Utils.loadimage("resources/plane3.png")));
        return planecontroller;
    }
}
