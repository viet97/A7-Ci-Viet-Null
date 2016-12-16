package controller;

import model.Model;
import view.View;

import java.awt.*;

/**
 * Created by Dell on 07/12/2016.
 */
public class Controller {
    protected Model model;
    protected View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void run(){

    }
    public void draw(Graphics g){

            view.draw(g, model);
    }

    public Model getModel() {
        return model;
    }

    public View getView() {
        return view;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void setView(View view) {
        this.view = view;
    }
}
