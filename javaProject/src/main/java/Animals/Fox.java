package Animals;

import project_java.Animal;
import project_java.Point;
import project_java.World;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

public class Fox extends Animal {
    public Fox(World world, Point position){
        super(world,position);
        age = 0;
        power = 3;
        inicjatywa = 7;
        sign = 'f';
        name = "Fox";
        isAnimal = true;
        typ = 4;
    }
    public Fox(World world,Point position, int age, int power, int init){
        super(world,position,age,power,init);
        sign = 'f';
        name = "Fox";
        isAnimal = true;
        typ = 4;

        //oldPosition = new Point(0,0);
    }
    public Color getColor(){
        return new Color(208, 152, 22);
    }

    public void Akcja(){
        boolean left = true;
        boolean right = true;
        boolean up = true;
        boolean down = true;
        Point oldPosition = position;
        if (0+this.getPosition().getX() - 1 < 0) {
            left = false;
        }
        else if (0 + this.getPosition().getX() + 2> 0 + world.getX()) {
            right = false;
        }
        if (this.getPosition().getY() - 1 < 0) {
            up = false;
        }
        else if (this.getPosition().getY()+ 2> 0 + world.getY()) {
            down = false;
        }

        //Point oldPosition = new Point(position.getX(), position.getY());
        Point temp1 = new Point(position.getX(), position.getY()-1);
        Point temp2 = new Point(position.getX()-1, position.getY());
        Point temp3 = new Point(position.getX()+1, position.getY());
        Point temp4 = new Point(position.getX(), position.getY()+1);


        Random random = new Random();
        int a = random.nextInt(100);

        if (a >= 0 && a < 25 && up == true && (world.whoIs(temp1, this) == null || world.whoIs(temp1, this).getSila() < this.getSila())) {
            position.setPositoion(temp1);
            if(world.whoIs(temp1, this) != null)
                world.whoIs(temp1, this).Kolizja(this);

        }
        else if (a >= 25 && a < 50 && left == true && (world.whoIs(temp2, this) == null || world.whoIs(temp2, this).getSila() < this.getSila())) {
            position.setPositoion(temp2);
            if(world.whoIs(temp2, this) != null)
                world.whoIs(temp2, this).Kolizja(this);

        }

        else if (a >= 50 && a < 75 && right == true && (world.whoIs(temp3, this) == null || world.whoIs(temp3, this).getSila() < this.getSila())) {
            position.setPositoion(temp3);
            if(world.whoIs(temp3, this) != null)
                world.whoIs(temp3, this).Kolizja(this);

        }

        else if (a >= 75 && a < 100 && down == true && (world.whoIs(temp4, this) == null || world.whoIs(temp4, this).getSila() < this.getSila())) {
            position.setPositoion(temp4);
            if(world.whoIs(temp4, this) != null)
                world.whoIs(temp4, this).Kolizja(this);

        }

    }
    public String getName(){
        return "Fox";
    }
    public Image getImage()  {

        // String fileName = "file:/Users/bitesaitzzz/IdeaProjects/demo/src/main/java/Animals/images/man.png";
        URL url = null;
        try {
            url = new URL("file:" + System.getProperty("user.dir") + "/src/main/java/images/fox.png");

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
