import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.font.ImageGraphicAttribute;
import java.io.File;
import java.io.IOException;

/**
 * Created by Dell on 30/11/2016.
 */
public class GameWindow extends Frame {
    Image background;
    Image plane3;
    Image plane2;
    Image enemy_plane_yellow_1;
    private int planeX = 300;
    private int planeY = 300;
    private int planeX1 = 100;
    private int planeY1 = 300;
    private int enemyplaneX1 = 300;
    private int enemyplaneY1 = 100;


    public GameWindow(){
        setVisible(true);
        setSize(600, 400);
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
        try {
            background = ImageIO.read(new File("resources/background.png"));
            plane3 = ImageIO.read(new File("resources/plane3.png"));
            plane2 = ImageIO.read(new File("resources/plane2.png"));
            enemy_plane_yellow_1 = ImageIO.read(new File("resources/enemy_plane_yellow_1.png"));
        } catch (IOException e) {
            System.out.println("Load Failed");
            e.printStackTrace();
        }

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println("keyTyped");

            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("keyPressed");
                switch (e.getKeyCode()){

                    case KeyEvent.VK_UP:
                        planeY -= 5;
                        repaint();
                        break;
                    case KeyEvent.VK_DOWN:
                        planeY += 5;
                        repaint();
                        break;
                    case KeyEvent.VK_LEFT:
                        planeX -= 5;
                        repaint();
                        break;
                    case KeyEvent.VK_RIGHT:
                        planeX += 5;
                        repaint();
                        break;
                }
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_A :
                        planeX1 -= 5;
                        repaint();
                        break;
                    case KeyEvent.VK_D :
                        planeX1 += 5;
                        repaint();
                        break;
                    case KeyEvent.VK_W :
                        planeY1 -= 5;
                        repaint();
                        break;
                    case KeyEvent.VK_S :
                        planeY1 += 5;
                        repaint();
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("keyReleased");
            }
        });

        repaint();
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(background, 0, 0, 600, 400,null);

        g.drawImage(plane3, planeX, planeY, 70, 50 ,null );

        g.drawImage(plane2, planeX1, planeY1,70,50,null);

        g.drawImage(enemy_plane_yellow_1,enemyplaneX1,enemyplaneY1,70 , 50, null);
    }
}