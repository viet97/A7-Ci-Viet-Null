package controller.managers;

import controller.Controller;

import java.awt.*;
import java.util.Vector;

/**
 * Created by Dell on 10/12/2016.
 */
public class ControllerManager {
    protected Vector<Controller> controllers;

    public ControllerManager(){
        controllers= new Vector<>();
    }

    public void draw(Graphics g){
        for(Controller controller : controllers)
            controller.draw(g);
    }

    public void run(){
        for(Controller controller : controllers)
            controller.run();
    }
    public void add(Controller controller){
        controllers.add(controller);
    }
    public void remove(Controller controller){
        controllers.remove(controller);
    }

}
