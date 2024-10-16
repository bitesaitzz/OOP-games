package project_java;

import java.awt.*;
import java.util.Random;

public abstract class Plant extends Organizm{
    public Plant(World world,Point position, int age, int power, int inicjatywa){
        super(world,position,age,power,inicjatywa);
        inicjatywa = 0;
        isAnimal = false;
    }
    public Plant(World world, Point position){
        super(world, position);
    }
    @Override
    public Color getColor() {
        return null;
    }

    @Override
    public void Akcja() {
        Random random = new Random();
        int a = random.nextInt(100);
        if(a>93){
            growth();
        }
    }

    @Override
    public void Kolizja(Organizm org) {
        world.deleteOrganizm(this);
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public Image getImage() {
        return null;
    }

    public void growth() {
        Random random = new Random();
        int a = random.nextInt(4);
        Point newTemp = this.position;
        switch (a) {
            case 0:
                if (position.getY() - 1 > 0 )
                newTemp = new Point(position.getX(), position.getY() - 1 );
                break;
            case 1:
                if (position.getX() - 1 > 0)
                newTemp = new Point(position.getX()-1, position.getY()  );
                break;
            case 2:
                if (position.getX() + 2 < world.getX())
                    newTemp = new Point(position.getX()+1, position.getY()  );
                break;
            case 3:
                if (position.getY() + 2 < world.getY())
                newTemp = new Point(position.getX(), position.getY() +1 );
                break;
            default:
                break;
        }
        if (world.whoIs(newTemp) == null) {
            world.createOrganizm(this.getTyp(), newTemp);

        }


    }
}
