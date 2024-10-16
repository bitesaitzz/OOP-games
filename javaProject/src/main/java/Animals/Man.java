package Animals;
import project_java.*;
import project_java.Point;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Man extends Animal{
    //private boolean skillActivated;
    private int skillCounter;
    public Man(World world, Point position){
        super(world,position);
   age = 0;
    power = 5;
    inicjatywa = 4;
    sign = 'm';
    name = "Man";
    typ = 0;
        isAnimal = true;
    //skillActivated = false;
         skillCounter = 5;
    //oldPosition = position;
    //setOldPosition(new Point(1,1));

    }
    public Man(World world,Point position, int age, int power, int init){
        super(world,position,age,power,init);
        isAnimal = true;
        sign = 'm';
        name = "Man";
        //oldPosition = new Point(0,0);
    }


    public void Akcja(){
        boolean left = true;
        boolean right = true;
        boolean up = true;
        boolean down = true;
        oldPosition.setPositoion(position);
        //setOldPosition(position);
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
        switch(this.world.getTemp()){
            case 2:

               //this.position.setY(position.getY()-1);
                if(up == true)
                position.changePositionUp();
                break;
            case 1:
                if( left == true)
                position.changePositionLeft();
                break;
            case 4:
                if(right == true)
                position.changePositionRight();
               // world.change();
                break;
            case 3:
                if(down == true)
                position.changePositionDown();
               // world.change2();
                break;
            case 5:
               skill();
                break;
            default:
                break;
        }

        if(world.skillActivated()){
            skill();
        }
        if (world.whoIs(this.getPosition(), this) != null && world.whoIs(this.getPosition(), this).getSign() != this.getSign()) {
            world.whoIs(this.getPosition(), this).Kolizja(this);
        }
        skillCounter++;
    }
    public void skill(){
        if (skillCounter > 5 && world.skillActivated() == false) {
           world.setSkillActivated(true);
            world.addInformation("Man got skill!!!");

            skillCounter = 5;
        }
        else if (skillCounter > 10 && world.skillActivated() == true) {
           world.setSkillActivated(false);
            world.addInformation("Man lost skill.");

            skillCounter = 0;
        }
        else if (world.skillActivated()) {
            if (world.whoIs(this.position, this) != null) {

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

                if (up == true) {
                    world.whoIs(this.position, this).getPosition().changePositionUp();

                    //temp.setY(temp.getY() + 1);
                }
                else if (down == true) {
                    world.whoIs(this.position, this).getPosition().changePositionDown();
                    //temp.setY(temp.getY() -1);
                }
                else if (left == true) {
                    world.whoIs(this.position, this).getPosition().changePositionLeft();
                    //temp.setX(temp.getX() - 1);
                }
                else {
                    world.whoIs(this.position, this).getPosition().changePositionRight();
                    //temp.setX(temp.getX() + 1);
                }
                //world.addInformation("Man kicked out "+ world.whoIs(this.position, this).getName() + ", using his skill, from his position.");


            }




        }


    }

    public void Kolizja(Organizm org) {
        if (world.skillActivated() && org.getIsAnimal() == true) {
            while (position.isEqual(org.getPosition()) ) {


                    boolean left = true;
                    boolean right = true;
                    boolean up = true;
                    boolean down = true;

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

                    if (up == true) {
                        org.getPosition().changePositionUp();



                        //temp.setY(temp.getY() + 1);
                    }
                    else if (down == true) {
                        org.getPosition().changePositionDown();
                        //temp.setY(temp.getY() -1);
                    }
                    else if (left == true) {
                        org.getPosition().changePositionLeft();
                        //temp.setX(temp.getX() - 1);
                    }
                    else {
                        org.getPosition().changePositionRight();
                        //temp.setX(temp.getX() + 1);
                    }
            }
           world.addInformation("Man kicked out "+org.getName()+" from his position.");
        }
        else {
           super.Kolizja(org);
        }
    };
    public Color getColor(){
        return new Color(1, 1, 1);
    }
    public int getSkillCounter(){
        return skillCounter;
    }
    public String getName(){
        return "Man";
    }

    @Override
    public void setSkillCounter(int skillCounter) {
        this.skillCounter = skillCounter;
    }

    public Image getImage()  {

        // String fileName = "file:/Users/bitesaitzzz/IdeaProjects/demo/src/main/java/Animals/images/man.png";
        URL url = null;
        try {
            //how to get current dir

            url = new URL("file:" + System.getProperty("user.dir") + "/src/main/java/images/man.png");
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
