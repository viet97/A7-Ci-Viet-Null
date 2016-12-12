package model;

/**
 * Created by Dell on 07/12/2016.
 */
public class Model {
    private int n;
    private int x;
    private int y;
    private int width;
    private int height;

    public int getN() {
        return n;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getMidx(){
        return this.x +this.width/2;
    }
    public int getMidy(){
        return this.y +this.height/2;
    }
    public Model(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

    }

    public void move(int dx, int dy) {
        x+=dx;
        y+=dy;
    }

}
