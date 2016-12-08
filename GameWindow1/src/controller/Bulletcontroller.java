package controller;

import controller.Controller;
import model.Model;
import view.View;

import java.awt.*;

/**
 * Created by Dell on 05/12/2016.
 */
public class Bulletcontroller extends Controller {

    public Bulletcontroller(Model model, View view) {
        super(model, view);
    }

    public void move(){
        model.move(0,-5);
    }

}
