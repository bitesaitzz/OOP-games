package Animals;

import project_java.Animal;
import project_java.Organizm;
import project_java.Point;
import project_java.World;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

public class Turtle extends Animal {
    public Turtle(World world, Point position){
        super(world,position);
        age = 0;
        power = 2;
        inicjatywa = 1;
        sign = 't';
        name = "turtle";
        typ = 5;
        isAnimal = true;
    }
    public Turtle(World world,Point position, int age, int power, int init){
        super(world,position,age,power,init);
        isAnimal = true;
        sign = 't';
        name = "turtle";
        typ = 5;

        //oldPosition = new Point(0,0);
    }
    public Color getColor(){
        return new Color(96, 85, 10);
    }

    @Override
    public void Akcja() {
        boolean left = true;
        boolean right = true;
        boolean up = true;
        boolean down = true;
     oldPosition = position;
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

        Random random = new Random();
        int ifGo = random.nextInt(100);
        if(ifGo> 75){
        while (true) {



            int a = random.nextInt(100);

            if (a >= 0 && a < 25 && up == true) {
                position.changePositionUp();

                break;
            }
            else if (a >= 25 && a < 50 && down == true) {
                position.changePositionDown();
                break;
            }

            else if (a >= 50 && a < 75 && left == true) {
                position.changePositionLeft();
                break;
            }
            else if (a >= 75 && right == true) {
                position.changePositionRight();
                break;
            }

        }
        if (world.whoIs(this.getPosition(), this) != null && world.whoIs(this.getPosition(), this).getSign() != this.getSign()) {
            world.whoIs(this.getPosition(), this).Kolizja(this);
        }
        else if(world.whoIs(this.getPosition(), this) != null && world.whoIs(this.getPosition(), this).getSign() == this.getSign() && this.getAge() > 10 && world.whoIs(this.getPosition(), this).getAge()> 10){
            breeding(world.whoIs(this.position, this));
            this.setPosition(oldPosition);

        }}



        plusAge();
    }
    public void Kolizja(Organizm org){
        if (org.getSila() > 5) {
            world.deleteOrganizm(this);
            world.addInformation(org.getName()+" killed "+this.getName() + " on position "+ this.position.getStringPosition() +"\n");

        }
        else {
            //org.getPosition().setPositoion(org.goldPosition);
            org.getPosition().changePositionLeft();
         // org.setPosition(org.getOldPosition());
            world.addInformation(this.getName()+" kicked out  "+org.getName() + " from position "+ this.position.getStringPosition() +"\n");
        }
    }
    public String getName(){
        return "Turtle";
    }
    public Image getImage()  {

        // String fileName = "file:/Users/bitesaitzzz/IdeaProjects/demo/src/main/java/Animals/images/man.png";
        URL url = null;
        try {
            url = new URL("file:" + System.getProperty("user.dir") + "/src/main/java/images/turtle.png");

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
