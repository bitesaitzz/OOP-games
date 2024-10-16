package Animals;

import project_java.Animal;
import project_java.Point;
import project_java.World;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Wolf extends Animal
{
    public Wolf(World world, Point position){
        super(world,position);
        age = 0;
        power = 9;
        inicjatywa = 5;
        sign = 'w';
        name = "Wolf";
        typ = 3;
        isAnimal = true;
    }
    public Wolf(World world,Point position, int age, int power, int init){
        super(world,position,age,power,init);
        isAnimal = true;
        sign = 'w';
        name = "Wolf";
        typ = 3;

        //oldPosition = new Point(0,0);
    }
    public Color getColor(){
        return new Color(103, 88, 88);
    }
    public String getName(){
        return "Wolf";
    }
    public Image getImage()  {

        // String fileName = "file:/Users/bitesaitzzz/IdeaProjects/demo/src/main/java/Animals/images/man.png";
        URL url = null;
        try {

            url = new URL("file:" + System.getProperty("user.dir") + "/src/main/java/images/wolf.png");
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



