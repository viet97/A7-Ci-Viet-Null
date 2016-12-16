import controller.*;
import controller.managers.BodyManager;
import controller.managers.BulletManager;
import controller.managers.EnemyControllerManager;
import model.Model;
import utils.Utils;
import view.View;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.util.Vector;

/**
 * Created by Dell on 05/12/2016.
 */
public class GameWindow extends Frame implements Runnable {
    Planecontroller planecontroller;
    BufferedImage backbuffer;
    Image background;
    EnemyControllerManager enemyControllerManager;
    BulletManager bulletManager ;
    int run;
    int run1;
    Vector<EnemyBulletcontroller> enemyBulletcontrollers;
    public GameWindow() {
        enemyControllerManager =new EnemyControllerManager();
        bulletManager = new BulletManager();
        setVisible(true);
        setSize(600, 400);
        enemyBulletcontrollers = new Vector<>();
        background = Utils.loadimage("resources/background.png");
        backbuffer = new BufferedImage(600, 400, BufferedImage.TYPE_INT_ARGB);
        KeySetting keySetting = new KeySetting(KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT);
        planecontroller = Planecontroller.createPlane(300, 300);
        planecontroller.keySetting = keySetting;
            addWindowListener(new WindowListener() {
                @Override
                public void windowOpened(WindowEvent e) {
                    System.out.println("windowOpened");
                }

                @Override
                public void windowClosing(WindowEvent e) {
                    System.out.println("windowClosing");
                    System.exit(0);
                }

                @Override
                public void windowClosed(WindowEvent e) {
                    System.out.println("windowClosed");
                }

                @Override
                public void windowIconified(WindowEvent e) {

                }

                @Override
                public void windowDeiconified(WindowEvent e) {

                }

                @Override
                public void windowActivated(WindowEvent e) {

                }

                @Override
                public void windowDeactivated(WindowEvent e) {

                }
            });
            addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {
                    System.out.println("keyTyped");
                }

                @Override
                public void keyPressed(KeyEvent e) {
                    System.out.println("keyPressed");
                    planecontroller.Keypressed(e);
                    if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                        int bulletx = planecontroller.getModel().getX() + 50 / 2 + 6;
                        int bullety = planecontroller.getModel().getY() - 16;
                        bulletManager.shoot(bulletx,bullety);
                    }

                }

                @Override
                public void keyReleased(KeyEvent e) {
                    System.out.println("keyReleased");
                }
            });
        }


        public void update(Graphics g){
            Graphics backbufferGraphic = backbuffer.getGraphics();
            backbufferGraphic.drawImage(background,0,0,600,400,null);
            if(planecontroller.getModel().isAlive()) planecontroller.draw(backbufferGraphic);
            bulletManager.draw(backbufferGraphic);
            enemyControllerManager.draw(backbufferGraphic);

            g.drawImage(backbuffer,0,0,600, 400,null);
        }
        public void run(){
            while (true){
                try {
                    bulletManager.run();
                    Thread.sleep(17);
                    enemyControllerManager.run();
                    BodyManager.instance.checkContact();
                    this.repaint();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

}

