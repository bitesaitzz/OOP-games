package project_java;
public class Point {
    private int x;
    private int y;
    public Point(int _x, int _y){
        x = _x;
        y = _y;
    }
    public void setY(int _y){
        y = _y;
    }
    public void setX(int _x){
        x = _x;
    }
    public int getY(){
        return y;
    }
    public int getX(){
        return x;
    }
    public void setPositoion(Point _position){
        setX(_position.getX());
        setY(_position.getY());
    }

    public void changePositionUp(){
       y = y-1;
    }
    public void changePositionDown(){
       y = y+1;
    }
    public void changePositionLeft(){
       x = x-1;
    }
    public void changePositionRight(){
       x = x+1;
    }

    public boolean isEqual(Point position){
        if(this.x == position.getX() && this.y == position.getY()){
            return true;
        }
        else
            return false;
    }
    public String getStringPosition(){
        return "["+x+", "+y+"]";
    }
}
