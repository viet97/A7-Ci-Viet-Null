package Planeview;

import Planemodel.Bulletmodel;

import java.awt.*;

/**
 * Created by Dell on 05/12/2016.
 */
public class Bulletview {
    public Image image;

    public Bulletview(Image image) {
        this.image = image;
    }
    public void draw(Graphics g,Bulletmodel bullermodel){
        g.drawImage(image,bullermodel.getX(),bullermodel.getY(),13,33,null);
    }
}
