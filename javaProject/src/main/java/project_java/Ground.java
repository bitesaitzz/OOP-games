package project_java;

import java.awt.*;

public class Ground extends Organizm{
    public Ground(){
        sign = '0';
    };
    public Ground (World world, Point position){
        super(world, position);
        sign = '0';
    }
    public Color getColor(){
        return new Color (206, 164, 129);
    }

    @Override
    public void Akcja() {

    }

    @Override
    public void Kolizja(Organizm org) {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public Image getImage() {
        return null;
    }

}
