/**
 * Created by Dell on 05/12/2016.
 */
public class Program {

    public static void main(String[] args){
        System.out.println("hello Android 7");
        GameWindow gameWindow = new GameWindow();
        Thread thread = new Thread(gameWindow);
        thread.start();
    }
}
