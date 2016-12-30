import com.sun.org.apache.xpath.internal.functions.FuncFalse;
import controllers.*;
import controllers.manangers.BodyManager;
import controllers.manangers.ControllerManager;
import controllers.manangers.EnemyControllerManager;
import controllers.scenes.GameScene;
import controllers.scenes.MenuScene;
import controllers.scenes.PlayGameScene;
import controllers.scenes.SceneListener;

import java.awt.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.util.Stack;
import java.util.Vector;

import static utils.Utils.loadImage;

// Data abstraction

/**
 * Created by apple on 11/30/16.
 */
public class GameWindow extends Frame implements Runnable, SceneListener {

    BufferedImage backBuffer;

    GameSetting gameSetting;

    GameScene currentScene;

    Stack<GameScene> gameSceneStack;
    public GameWindow() {
        gameSceneStack = new Stack<>();
       replaceScene(new MenuScene(), false);

        configSettings();

        setVisible(true);
        setSize(gameSetting.getWidth(), gameSetting.getHeight());

        backBuffer = new BufferedImage(gameSetting.getWidth(), gameSetting.getHeight(), BufferedImage.TYPE_INT_ARGB);

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
                System.out.println( " keyTyped");
            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("keyPressed");
                currentScene.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("keyReleased");
            }
        });
    }

    private void configSettings() {
        PlaneController.instance.keySetting = new KeySetting(
                KeyEvent.VK_UP,
                KeyEvent.VK_DOWN,
                KeyEvent.VK_LEFT,
                KeyEvent.VK_RIGHT,
                KeyEvent.VK_SPACE
        );
        gameSetting = GameSetting.instance;
    }
    public void replaceScene(GameScene newScen,boolean addToBackStack){
        if (addToBackStack && currentScene != null){
            gameSceneStack.push(currentScene);
        }
        currentScene  = newScen;
        currentScene.setSceneListener(this);
    }
    public void back(){
        if (!gameSceneStack.isEmpty()) {
            currentScene = gameSceneStack.pop();
            currentScene.setSceneListener(this);
        }
    }

    //Utilities


    @Override
    public void update(Graphics g) {
        // Prepare backbuffer
        Graphics backBufferGraphics = backBuffer.getGraphics();
        currentScene.update(backBufferGraphics);
        // Update window
        g.drawImage(backBuffer, 0, 0, gameSetting.getWidth(), gameSetting.getHeight(), null);
    }

    @Override
    public void run() {
        while (true) {
            try {
                this.repaint();
                Thread.sleep(17);
                currentScene.run();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
