package controller.managers;

import controller.Body;
import model.Model;

import java.util.Vector;

/**
 * Created by Dell on 14/12/2016.
 */
public class BodyManager {
    private Vector<Body> bodies;

    public static  final BodyManager instance = new BodyManager();
    private BodyManager(){
        bodies = new Vector<>();
    }
    public void register(Body body){
        this.bodies.add(body);
    }

    public void checkContact() {
        for (int i = 0; i < bodies.size() - 1; i++) {
            for (int j = i + 1; j < bodies.size(); j++) {
                Body bodyi = bodies.get(i);
                Body bodyj = bodies.get(j);
                Model modeli = bodyi.getModel();
                Model modelj = bodyj.getModel();

                if (modeli.intersects(modelj)) {
                    bodyi.onContact(bodyj);
                    bodyj.onContact(bodyi);
                }
            }
        }
    }
    public void remove(Body body){
        this.bodies.remove(body);
    }
}
