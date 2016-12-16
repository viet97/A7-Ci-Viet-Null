package controller.managers;

import controller.Controller;

import java.awt.*;
import java.util.Iterator;
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

    public Vector<Controller> getControllers() {
        return controllers;
    }

    public void run(){
        Iterator<Controller> iterator = this.controllers.iterator();
       while(iterator.hasNext()){
            Controller controller = iterator.next();
            if (!controller.getModel().isAlive()){
                iterator.remove();
            }
        }
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
