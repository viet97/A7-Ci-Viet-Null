package controllers.scenes;

import utils.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Dell on 30/12/2016.
 */
public class OverGameScene extends GameScene {
    @Override
    public void update(Graphics g) {
        g.drawImage(Utils.loadImage("resources/1945-logo.png"),0,0,600,400,null);
    }

    @Override
    public void run() {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        this.sceneListener.back();

    }
}
