import controller.*;
import model.Model;
import utils.Utils;
import view.View;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by Dell on 05/12/2016.
 */
public class GameWindow extends Frame implements Runnable {
    Planecontroller planecontroller;
    BufferedImage backbuffer;
    Image background;
    EnemyPlanecontroller enemyPlanecontroller;
    Vector<Bulletcontroller> bulletcontrollersVector;
    int run;
    int run1;
    Vector<EnemyBulletcontroller> enemyBulletcontrollers;
    public GameWindow() {
        setVisible(true);
        setSize(600, 400);
        bulletcontrollersVector = new Vector<>();
        enemyBulletcontrollers = new Vector<>();
        background = Utils.loadimage("resources/background.png");
        backbuffer = new BufferedImage(600, 400, BufferedImage.TYPE_INT_ARGB);
        KeySetting keySetting = new KeySetting(KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT);
        planecontroller = Planecontroller.createPlane(300, 300);
        planecontroller.keySetting = keySetting;
        enemyPlanecontroller = EnemyPlanecontroller.createEnemyPlane(300, 0);
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
                        Bulletcontroller bulletcontroller =new Bulletcontroller(new Model(bulletx,bullety,12,30),new View(Utils.loadimage("resources/bullet.png")));
                        bulletcontrollersVector.add(bulletcontroller);
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
            planecontroller.draw(backbufferGraphic);
            enemyPlanecontroller.draw(backbufferGraphic);
            for(Bulletcontroller bulletcontroller : bulletcontrollersVector)
                bulletcontroller.draw(backbufferGraphic);
            for(EnemyBulletcontroller enemyBulletcontroller : enemyBulletcontrollers)
                enemyBulletcontroller.draw(backbufferGraphic);

            g.drawImage(backbuffer,0,0,600, 400,null);
        }
        public void run(){
            while (true){
                try {
                    run +=1;
                    run1 +=1;
                    Thread.sleep(17);
                    for(Bulletcontroller bulletcontroller : bulletcontrollersVector)
                        bulletcontroller.move();
                    if(run == 10){
                        enemyPlanecontroller.run();
                        run=0;
                    }
                    if(run1 == 40){
                        int bulletx = enemyPlanecontroller.getModel().getX() +10;
                        int bullety = enemyPlanecontroller.getModel().getY()+ 15 ;
                        EnemyBulletcontroller enemyBulletcontroller = new EnemyBulletcontroller(
                                new Model(bulletx,bullety,50,70),new View(Utils.loadimage("resources/enemy_bullet.png")));
                        enemyBulletcontrollers.add(enemyBulletcontroller);
                        run1 =0;
                    }
                    for(EnemyBulletcontroller enemyBulletcontroller : enemyBulletcontrollers)
                        enemyBulletcontroller.move();
                    this.repaint();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

}

