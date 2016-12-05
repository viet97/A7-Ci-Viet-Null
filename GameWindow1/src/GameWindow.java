import Planecontroller.Planecontroller;
import Planecontroller.Bulletcontroller;
import Planemodel.Planemodel;
import Planemodel.Bulletmodel;
import Planeview.Planeview;
import Planeview.Bulletview;
import Planecontroller.KeySetting;
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
    Vector<Bulletcontroller> bulletcontrollersVector;
        public GameWindow(){
            setVisible(true);
            setSize(600,400);
            bulletcontrollersVector = new Vector<>();
            background=loadimage("resources/background.png");
            backbuffer = new BufferedImage(600,400,BufferedImage.TYPE_INT_ARGB);
            Planemodel planemodel;
            Planeview planeview;
            planemodel = new Planemodel(300,300);
            planeview = new Planeview(loadimage("resources/plane3.png"));
            KeySetting keySetting = new KeySetting(KeyEvent.VK_UP,KeyEvent.VK_DOWN,KeyEvent.VK_LEFT,KeyEvent.VK_RIGHT);
            planecontroller = new Planecontroller(planemodel,planeview);
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
                    if(e.getKeyCode() == KeyEvent.VK_SPACE){
                        int bulletx = planecontroller.planemodel.getX()+50/2-6;
                        int bullety = planecontroller.planemodel.getY()- 16;
                        Bulletmodel bulletmodel = new Bulletmodel(bulletx,bullety);
                        Bulletview bulletview = new Bulletview(loadimage("bullet.png"));
                        Bulletcontroller bulletcontroller = new Bulletcontroller(bulletmodel,bulletview);
                        bulletcontrollersVector.add(bulletcontroller);
                    }

                }

                @Override
                public void keyReleased(KeyEvent e) {
                    System.out.println("keyReleased");
                }
            });
        }
        public Image loadimage(String path) {
            Image image;
            try {
                image = ImageIO.read(new File(path));
                return image;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }

        }
        public void update(Graphics g){
            Graphics backbufferGraphic = backbuffer.getGraphics();
            backbufferGraphic.drawImage(background,0,0,600,400,null);
            planecontroller.draw(backbufferGraphic);
          for(Bulletcontroller bulletcontroller : bulletcontrollersVector)
                bulletcontroller.draw(backbufferGraphic);

            g.drawImage(backbuffer,0,0,600,400,null);
        }
        public void run(){
            while (true){
                this.repaint();
                try {
                    Thread.sleep(17);
                    for(Bulletcontroller bulletcontroller : bulletcontrollersVector)
                        bulletcontroller.move();
                    this.repaint();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

}

