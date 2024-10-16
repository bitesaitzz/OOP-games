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


public class Antelope extends Animal {
    public Antelope(World world, Point position){
        super(world, position);
        this.power = 4;
        this.inicjatywa = 4;
        this.name = "Antelope";
        this.sign = 'A';
        this.age = 0;
        isAnimal = true;
        typ = 6;
    }
    public Antelope(World world,Point position, int age, int power, int init){
        super(world,position,age,power,init);
        isAnimal = true;
        this.name = "Antelope";
        this.sign = 'A';

        isAnimal = true;
        typ = 6;
        //oldPosition = new Point(0,0);
    }

    public void Akcja() {
        boolean left = true;
        boolean right = true;
        boolean up = true;
        boolean down = true;
        oldPosition.setPositoion(position);
        if ( this.getPosition().getX() - 3 < 0) {
            left = false;
        }
        else if ( this.getPosition().getX() + 3 > world.getX()) {
            right = false;
        }
        if (this.getPosition().getY() - 3 < 0) {
            up = false;
        }
        else if (this.getPosition().getY() + 4  > world.getY()) {
            down = false;
        }
        Random random = new Random();


        while (true) {
            int a = random.nextInt(100);


            if (a >= 0 && a < 25 && up == true) {
                this.position.setPositoion(new Point(this.position.getX(), position.getY() -2));
                break;
            }
            else if (a >= 25 && a < 50 && down == true) {
                this.position.setPositoion(new Point(this.position.getX(), position.getY() +2));

                break;
            }

            else if (a >= 50 && a < 75 && left == true) {
                this.position.setPositoion(new Point(this.position.getX()-2, position.getY() ));

                break;
            }
            else if (a >= 75 && right == true) {
                this.position.setPositoion(new Point(this.position.getX()+2, position.getY()));
                break;
            }

        }
        if (world.whoIs(this.getPosition(), this) != null && world.whoIs(this.getPosition(), this).getSign() != this.getSign()) {
            world.whoIs(this.getPosition(), this).Kolizja(this);
        }
        else if(world.whoIs(this.getPosition(), this) != null && world.whoIs(this.getPosition(), this).getSign() == this.getSign() && this.getAge() > 10 && world.whoIs(this.getPosition(), this).getAge()> 10){
            breeding(world.whoIs(this.position, this));
            this.setPosition(oldPosition);

        }
        this.plusAge();
    }


    public void Kolizja(Organizm org) {
        Random random = new Random();
        int a = random.nextInt(100);
        if (a >= 50) {
            boolean left = true;
            boolean right = true;
            boolean up = true;
            boolean down = true;

            if (0 + this.getPosition().getX() - 1 < 0) {
                left = false;
            } else if (0 + this.getPosition().getX() + 2 > 0 + world.getX()) {
                right = false;
            }
            if (this.getPosition().getY() - 1 < 0) {
                up = false;
            } else if (this.getPosition().getY() + 2 > 0 + world.getY()) {
                down = false;
            }


            if (up == true && world.whoIs(new Point(position.getX(), position.getY() - 1), this) == null) {
                position.setPositoion(new Point(position.getX(), position.getY() - 1));
                world.addInformation(this.getName() + "ran away from " + org.getName() + " to the position " + position.getStringPosition() + ".");


            } else if (down == true && world.whoIs(new Point(position.getX(), position.getY() + 1), this) == null) {
                position.setPositoion(new Point(position.getX(), position.getY() + 1));
                world.addInformation(this.getName() + "ran away from " + org.getName() + " to the position " + position.getStringPosition() + ".");


            } else if (left == true && world.whoIs(new Point(position.getX() - 1, position.getY()), this) == null) {
                position.setPositoion(new Point(position.getX() - 1, position.getY()));
                world.addInformation(this.getName() + "ran away from " + org.getName() + " to the position " + position.getStringPosition() + ".");


            } else if (right == true && world.whoIs(new Point(position.getX() + 1, position.getY()), this) == null) {
                position.setPositoion(new Point(position.getX() + 1, position.getY()));
                world.addInformation(this.getName() + "ran away from " + org.getName() + " to the position " + position.getStringPosition() + ".");


            } else {
                a = 49;
            }
        }
        if (a < 50) {
            super.Kolizja(org);


        }
    }

    public Color getColor(){
        return new Color(168, 66, 0);
    }
    public String getName(){
        return "Antelope";
    }
    public Image getImage()  {

        // String fileName = "file:/Users/bitesaitzzz/IdeaProjects/demo/src/main/java/Animals/images/man.png";
        URL url = null;
        try {
            url = new URL("file:" + System.getProperty("user.dir") + "/src/main/java/images/antelope.png");

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
