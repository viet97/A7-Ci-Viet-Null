package Planemodel;

/**
 * Created by Dell on 05/12/2016.
 */
public class Bulletmodel {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Bulletmodel(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void move(int dx,int dy){
        x+=dx;
        y+=dy;
    }
}
