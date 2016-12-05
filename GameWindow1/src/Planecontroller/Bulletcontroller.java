package Planecontroller;

import Planemodel.Bulletmodel;
import Planeview.Bulletview;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Dell on 05/12/2016.
 */
public class Bulletcontroller {
    public Bulletmodel bulletmodel;
    public Bulletview bulletview;


    public Bulletcontroller(Bulletmodel bulletmodel, Bulletview bulletview) {
        this.bulletmodel = bulletmodel;
        this.bulletview = bulletview;
    }
    public void move(){
        bulletmodel.move(0,-5);
    }
    public void draw(Graphics g){
        bulletview.draw(g,bulletmodel);
    }
}
