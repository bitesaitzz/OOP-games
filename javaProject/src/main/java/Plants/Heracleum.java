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

public class Heracleum extends Plant {
    public Heracleum(World world, Point position) {
        super(world, position);
        inicjatywa = 0;
        sign = 'h';
        name = "Heracleum";
        typ = 10;
    }
    public Heracleum(World world,Point position, int age, int power, int init){
        super(world,position,age,power,init);
        isAnimal = false;
        sign = 'h';
        name = "Heracleum";
        typ = 10;

        //oldPosition = new Point(0,0);
    }

    @Override
    public Color getColor() {
        return new Color(162, 241, 84);
    }
    public void Akcja(){
        if (world.whoIs(new Point(position.getX(), position.getY()-1), this) != null
                && world.whoIs(new Point(position.getX(), position.getY()-1), this).getIsAnimal() == true ) {
            Organizm temp = world.whoIs(new Point(position.getX(), position.getY()-1), this);
            world.addInformation(temp.getName()+" touched "+this.getName()+ " and dead ont the position " + position.getStringPosition());
            world.deleteOrganizm(temp);

        }
        if (world.whoIs(new Point(position.getX(), position.getY()+1), this) != null
                && world.whoIs(new Point(position.getX(), position.getY()+1), this).getIsAnimal() == true ) {
            Organizm temp = world.whoIs(new Point(position.getX(), position.getY()+1), this);
            world.addInformation(temp.getName()+" touched "+this.getName()+ " and dead ont the position " + position.getStringPosition());
            world.deleteOrganizm(temp);

        }
        if (world.whoIs(new Point(position.getX()-1, position.getY()), this) != null
                && world.whoIs(new Point(position.getX()-1, position.getY()), this).getIsAnimal() == true ) {
            Organizm temp = world.whoIs(new Point(position.getX()-1, position.getY()), this);
            world.addInformation(temp.getName()+" touched "+this.getName()+ " and dead ont the position " + position.getStringPosition());
            world.deleteOrganizm(temp);

        }
        if (world.whoIs(new Point(position.getX()+1, position.getY()), this) != null
                && world.whoIs(new Point(position.getX()+1, position.getY()), this).getIsAnimal() == true ) {
            Organizm temp = world.whoIs(new Point(position.getX()+1, position.getY()), this);
            world.addInformation(temp.getName()+" touched "+this.getName()+ " and dead ont the position" + position.getStringPosition());
            world.deleteOrganizm(temp);

        }
	else {
            super.Akcja();
        }
    }
    public void Kolizja(Organizm org){
        world.addInformation(org.getName()+" ate "+this.getName()+" and dead on the position "+position.getStringPosition());
        world.deleteOrganizm(org);
        world.deleteOrganizm(this);
    }
    public String getName(){
        return "Heracleum";
    }
    public Image getImage()  {

        // String fileName = "file:/Users/bitesaitzzz/IdeaProjects/demo/src/main/java/Animals/images/man.png";
        URL url = null;
        try {

            url = new URL("file:" + System.getProperty("user.dir") + "/src/main/java/images/heracleum.png");
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
