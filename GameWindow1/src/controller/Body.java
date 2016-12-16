package controller;

import model.Model;

/**
 * Created by Dell on 14/12/2016.
 */
public interface Body { // thuan ao
     Model getModel();
     void onContact(Body other);
}
