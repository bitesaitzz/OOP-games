package project_java;

import javax.swing.text.Position;
import java.awt.*;
import java.net.MalformedURLException;

public abstract class Organizm {
    protected Point position;
    protected int age;
    protected int power;
    protected Point oldPosition;
    protected int inicjatywa;
    protected World world;
    private Color color;
    protected String name;
    protected char sign;
    protected int typ;
    protected boolean isAnimal;
    public Organizm(){};
   public Organizm(World world, Point position, int age, int power, int init){
       this.world = world;
       this.position = position;
       this.age = age;
       this.power = power;
       this.inicjatywa = init;
   };
    Organizm(World world, Point position){
        this.world = world;
        this.position = position;
        this.oldPosition = position;
        this.age = 0;

    }
    public void setPosition(Point _position){
        position.setX(_position.getX());
        position.setY(_position.getY());
    }
    public void setWorld(World world){
        world = world;
    }
    abstract public Color getColor();

    abstract public void Akcja();

    abstract public void Kolizja(Organizm org);
   public Point getPosition(){
   return position;
   }
   public void plusAge(){
       age++;
   }
   public char getSign(){
       return sign;
   }
   public int getSila(){
       return power;
   }
   public int getAge(){
       return age;
   }
   public int getInicjatywa(){
       return inicjatywa;
   }
   abstract public String getName();

   public int getTyp(){
       return typ;
   }
    public Point getOldPosition(){
       return oldPosition;
    }
    public void setOldPosition(Point x){
       this.oldPosition.setX(x.getX());
       this.oldPosition.setY(x.getY());
    }
    public void setPower(int power){
       this.power = power;
    }
    public boolean getIsAnimal(){
       return isAnimal;
    }
    public int getSkillCounter(){
        return 0;
    }
    public void setSkillCounter(int a){

    }
    abstract public Image getImage() ;

}
