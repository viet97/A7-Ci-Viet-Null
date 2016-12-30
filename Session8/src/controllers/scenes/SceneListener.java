package controllers.scenes;

/**
 * Created by Dell on 28/12/2016.
 */
public interface SceneListener {
    void replaceScene(GameScene newScen,boolean addToBackStack);
    void back();
}
