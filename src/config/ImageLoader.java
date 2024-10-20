package config;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;



public class ImageLoader {

    public static Image ship(int id) {
        return loadImage("ship" + id);
    }
    public static Image heavyBullet() {
        return loadImage("heavy-bullet");
    }
    public static Image fastBullet() {
        return loadImage("fast-bullet");
    }
    public static Image coin() {return loadImage("coin");}

    private static Image loadImage(String filename) {
        try {
            return ImageIO.read(new File("resource/" + filename + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
