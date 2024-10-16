package Plants;

import project_java.Plant;
import project_java.Point;
import project_java.World;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Grass extends Plant {

    public Grass(World world, Point position) {
        super(world, position);
        power = 0;
        inicjatywa = 0;
        sign = 'r';
        name = "Grass";
        typ = 2;
    }
    public Grass(World world,Point position, int age, int power, int init){
        super(world,position,age,power,init);
        isAnimal = false;
        sign = 'r';
        typ=2;
        name = "Grass";

        //oldPosition = new Point(0,0);
    }

    public Color getColor(){
        return new Color(0, 255, 0);
    }
    public String getName(){
        return "Grass";

    }
    public Image getImage()  {

        // String fileName = "file:/Users/bitesaitzzz/IdeaProjects/demo/src/main/java/Animals/images/man.png";
        URL url = null;
        try {
            url = new URL("file:" + System.getProperty("user.dir") + "/src/main/java/images/grass.png");

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        if (url == null) {
            throw new RuntimeException("Resource not found: ");
        }
        try {
            return ImageIO.read(url);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load image: ", e);
        }
    }
}
