package project_java;

import java.awt.*;
import java.net.MalformedURLException;
import java.util.Random;

public abstract class Animal extends Organizm{
    //private static final Point position = ;

    public Animal(){}

    public Animal(World world,Point position, int age, int power, int init){
        super(world,position,age,power,init);
        isAnimal = true;
        oldPosition = position;
        //oldPosition = new Point(0,0);
    }
    public Animal(World world, Point position){
        super(world, position);
    }
    @Override
    public Color getColor() {
        return null;
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

        }
        /*
	else if(world->getElementInMap(this->getPozycja()) != nullptr && world->getElementInMap(this->getPozycja())->getModel() == this->getModel() && this->getAge() > 10 && world->getElementInMap(this->getPozycja())->getAge() > 10){

            Breeding(world->getElementInMap(this->getPozycja()));
            this->SetPozycja(getOldPosition().getX(), getOldPosition().getY());
        }
        */

        plusAge();

    }

    @Override
    public void Kolizja(Organizm org) {
        if (this.getSila()>org.getSila()) {
            world.deleteOrganizm(org);
            if (org.getSila() > 0) {
                //String result = this.getName()+" killed "+org.getName()+" on position " + this.getPosition().getStringPosition()+".";
                world.addInformation(this.getName()+" killed "+org.getName()+" on position "
                        + this.getPosition().getStringPosition()+".\n");

            }
        }
	else if (this.getSila() < org.getSila()) {

            world.addInformation(org.getName()+" killed "+this.getName()+" on position "
                    + this.getPosition().getStringPosition()+".\n");
            world.deleteOrganizm(this);
        }
	else if (this.getAge() > org.getAge()) {
            world.addInformation(this.getName()+" killed "+org.getName()+" on position "
                    + this.getPosition().getStringPosition()+".\n");
            world.deleteOrganizm(org);

        }
	else {
            world.addInformation(org.getName()+" killed "+this.getName()+" on position "
                    + this.getPosition().getStringPosition()+".\n");
            world.deleteOrganizm(this);
        }

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public Image getImage() {
        return null;
    }

    public void breeding(Organizm org){
        boolean left = true;
        boolean right = true;
        boolean up = true;
        boolean down = true;
        if (this.getPosition().getX() -2 < 0) {
            left = false;
        }
        else if (0 + this.getPosition().getX() + 2> 0 + world.getX()) {
            right = false;
        }
        if (this.getPosition().getY() - 2 < 0) {
            up = false;
        }
        else if (this.getPosition().getY()+ 2> 0 + world.getY()) {
            down = false;
        }
        Point newPosition = new Point(1,1);
        if (world.whoIs(new Point(position.getX()+1, position.getY())) == null && right == true) {
            newPosition.setX(position.getX() + 1);
            newPosition.setY(position.getY());
        }
	else if (world.whoIs(new Point( position.getX() - 1, position.getY() )) == null && left == true) {
            newPosition.setX(position.getX() - 1);
            newPosition.setY(position.getY());
        }
        else if (world.whoIs(new Point( position.getX(), position.getY()-1 )) == null && up == true) {
            newPosition.setX(position.getX());
            newPosition.setY(position.getY()-1);
        }
        else if (world.whoIs(new Point( position.getX() , position.getY()+1 )) == null && down == true) {
            newPosition.setX(position.getX() );
            newPosition.setY(position.getY()+1);
        }
	else {
            return;
        }
        world.createOrganizm(getTyp(), newPosition);
    world.addInformation("A new "+this.getName()+" was born in the position "+newPosition.getStringPosition()+"\n");

    }

    }


