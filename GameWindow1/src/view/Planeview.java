package Planeview;

import Planemodel.Planemodel;

import java.awt.*;

/**
 * Created by Dell on 05/12/2016.
 */
public class Planeview {
    Image image;

    public Planeview(Image image) {
        this.image = image;
    }

    public void draw(Graphics backbufferGraphics, Planemodel planemodel){
        backbufferGraphics.drawImage(image,planemodel.getX(),planemodel.getY(),70,50,null);
    }

}
