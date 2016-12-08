package utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Dell on 07/12/2016.
 */
public class Utils {
    public static Image loadimage(String path) {
        Image image = null;
        try {
            image = ImageIO.read(new File(path));
            return image;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }
}
