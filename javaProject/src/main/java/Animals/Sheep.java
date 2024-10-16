package Animals;
import project_java.*;
import project_java.Point;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Sheep extends Animal {
    public Sheep(World world, Point position){
        super(world,position);
        age = 0;
        power = 4;
        inicjatywa = 4;
        sign = 's';
        name = "sheep";
        typ = 1;
        isAnimal = true;
    }
    public Sheep(World world,Point position, int age, int power, int init){
        super(world,position,age,power,init);
        isAnimal = true;
        sign = 's';
        name = "sheep";
        typ = 1;

        //oldPosition = new Point(0,0);
    }
    public Color getColor(){
        return new Color(255, 255, 255);
    }
    public String getName(){
        return "Sheep";
    }
    public Image getImage()  {

        // String fileName = "file:/Users/bitesaitzzz/IdeaProjects/demo/src/main/java/Animals/images/man.png";
        URL url = null;
        try {

            url = new URL("file:" + System.getProperty("user.dir") + "/src/main/java/images/sheep.png");
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
