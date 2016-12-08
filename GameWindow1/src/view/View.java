package view;

import model.Model;

import java.awt.*;

/**
 * Created by Dell on 07/12/2016.
 */
public class View {
    Image image;

    public View(Image image) {
        this.image = image;
    }

    public void draw(Graphics backbufferGraphics, Model model){
        backbufferGraphics.drawImage(image,model.getX(),model.getY(), model.getWidth(),model.getHeight(),null);
    }
}

