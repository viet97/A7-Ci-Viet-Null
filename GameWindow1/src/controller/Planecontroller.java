package Planecontroller;


import Planemodel.Planemodel;
import Planeview.Planeview;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Dell on 05/12/2016.
 */
public class Planecontroller {
    public Planemodel planemodel;
    public Planeview planeview;
    public KeySetting keySetting;

    public Planecontroller(Planemodel planemodel, Planeview planeview) {
        this.planemodel = planemodel;
        this.planeview = planeview;
    }
    public void Keypressed(KeyEvent e){
        int keyCode;
        keyCode = e.getKeyCode();
        if(keyCode == keySetting.keyup)
            planemodel.move(0,-5);
        else if(keyCode==keySetting.keydown)
            planemodel.move(0,+5);
        else if(keyCode==keySetting.keyleft)
            planemodel.move(-5,0);
        else if(keyCode==keySetting.keyright)
            planemodel.move(+5,0);
    }
    public void draw(Graphics g){
        planeview.draw(g,planemodel);
    }
}
