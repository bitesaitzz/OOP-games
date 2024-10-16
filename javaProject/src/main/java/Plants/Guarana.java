package Plants;

import project_java.Organizm;
import project_java.Plant;
import project_java.Point;
import project_java.World;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Guarana extends Plant {

    public Guarana(World world, Point position) {
        super(world, position);
        age = 0;
        power = 0;
        inicjatywa = 0;
        sign = 'g';
        typ=8;
        name = "Guarana";

    }
    public Guarana(World world,Point position, int age, int power, int init){
        super(world,position,age,power,init);
        isAnimal = false;
        sign = 'g';
        typ=8;
        name = "Guarana";

        //oldPosition = new Point(0,0);
    }
    public Color getColor(){
    return new Color(255, 60, 60);}
    public void Kolizja(Organizm org){
        org.setPower(org.getSila()+3);
        world.addInformation(org.getName()+" ate Guarana on position "+ position.getStringPosition());
         world.deleteOrganizm(this);

    }
    public String getName(){
        return "Guarana";
    }
    public Image getImage()  {

        // String fileName = "file:/Users/bitesaitzzz/IdeaProjects/demo/src/main/java/Animals/images/man.png";
        URL url = null;
        try {

            url = new URL("file:" + System.getProperty("user.dir") + "/src/main/java/images/guarana.png");
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
