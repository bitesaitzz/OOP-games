package project_java;
import javax.swing.*;
import java.awt.*;
import Interface2.*;
import Animals.*;
import Interface2.Menu;

import Plants.*;

import java.io.*;
import java.util.Random;
import java.util.Vector;
import java.util.Collections;
import java.util.Comparator;

public class World {
    private int x;
    private int y;
   private int Tour;
   private int temp;
   private boolean isSkillActivated;
   private Organizm[][] map;
    private boolean isGame;
    public JFrame frame;
    public MapPanel mapPanel;
    Vector <Organizm> alive;
    World(int _x, int _y){
        x = _x;
        y = _y;
        isGame = true;
        alive = new Vector<Organizm>();
        map = new Organizm[y][x];
        for (int i = 0 ; i < y; i ++){
            for (int j = 0 ; j < x; j++){

                map[i][j] = new Ground();

            }
        }
        createWorld();
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }


    public void printWorld(){
        if(isGame == true) {
            JFrame frame = new JFrame("My Game");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



            mapPanel = new MapPanel(x, y, map, this);

            //Menu menu = new Menu();
            frame.getContentPane().add(mapPanel);
            //frame.getContentPane().add(menu);
            frame.setSize(880, 600);
            frame.setPreferredSize(new Dimension(880, 600));


            frame.pack();
            frame.setVisible(true);
        }



    }
        public void setTemp(int temp){
        this.temp = temp;
        }
        public int getTemp(){
        return temp;
        }
        public void createWorld(){
        map[0][0] = new Man(this, new Point(0,0));

        alive.add(map[0][0]);
            //map[2][2] = new Antelope(this, new Point(5,5));

        for(int i = 0; i < getX()*getY()/20; i++){
            Random rand = new Random();

            int typ = rand.nextInt(10) + 1;

            int newX = rand.nextInt(getX()-2)+1;
            int newY = rand.nextInt(getY()-2)+1;
            createOrganizm(typ, new Point(newX, newY));

        }



        }

        public Organizm whoIs(Point position, Organizm exception){
           for(int i = 0 ; i < alive.size() ; i++){
               if(alive.get(i) != exception && alive.get(i).getPosition().isEqual(position)){
                   return alive.get(i);
               }
           }
           return null;
        }
    public Organizm whoIs(Point position){
        for(int i = 0 ; i < alive.size() ; i++){
            if(alive.get(i).getPosition().isEqual(position)){
                return alive.get(i);
            }
        }
        return null;
    }



    public void nextTurn(){

        sortVector();
        clearInformation();
       for(int i = 0 ; i < alive.size(); i++){
          // addInformation(alive.get(i).getName()+'\n');
                alive.get(i).Akcja();
               // map[org.position.getX()][org.position.getY()] = org;
            //}

        }
            for (int  i = 0; i < y; i++){
                for (int j = 0 ; j < x; j++){
                    map[i][j] = new Ground();
                }
            }

        for(int i = 0; i < alive.size(); i++){
           Organizm org = alive.get(i);
           map[org.position.getY()][org.position.getX()] = org;
        }}
    public void deleteOrganizm(Organizm org){
        alive.remove(org);
    }

    public void sortVector(){
        Collections.sort(alive, new Comparator<Organizm>() {
            public int compare(Organizm o1, Organizm o2) {
                return o2.getInicjatywa() - o1.getInicjatywa();
            }
        });
    }


    public void addInformation(String str){
        mapPanel.addInfo(str);
    }
    public void clearInformation(){
        mapPanel.deleteInfo();
    }

    public void createOrganizm(Organizm org){
        map[org.position.getY()][org.position.getX()] = org;
        alive.add(map[org.position.getY()][org.position.getX()]);
    }
    public void createOrganizm(int typ, Point position){
        switch (typ){
            case 1:
                map[position.getY()][position.getX()] = new Sheep(this, position);
                alive.add(map[position.getY()][position.getX()]);
                break;
            case 2:
                map[position.getY()][position.getX()] = new Grass(this, position);
                alive.add(map[position.getY()][position.getX()]);
                break;
            case 3:
                map[position.getY()][position.getX()] = new Wolf(this, position);
                alive.add(map[position.getY()][position.getX()]);
                break;
            case 4:
                map[position.getY()][position.getX()] = new Fox(this, position);
                alive.add(map[position.getY()][position.getX()]);
                break;
            case 5:
                map[position.getY()][position.getX()] = new Turtle(this, position);
                alive.add(map[position.getY()][position.getX()]);
                break;
            case 6:
                map[position.getY()][position.getX()] = new Antelope(this, position);
                alive.add(map[position.getY()][position.getX()]);
                break;
            case 7:
                map[position.getY()][position.getX()] = new Dandelion(this, position);
                alive.add(map[position.getY()][position.getX()]);
                break;
            case 8:
                map[position.getY()][position.getX()] = new Guarana(this, position);
                alive.add(map[position.getY()][position.getX()]);
                break;
            case 9:
                map[position.getY()][position.getX()] = new Wolfberries(this, position);
                alive.add(map[position.getY()][position.getX()]);
                break;
            case 10:
                map[position.getY()][position.getX()] = new Heracleum(this, position);
                alive.add(map[position.getY()][position.getX()]);
                break;
            default:
                break;

        }
    }

    public boolean skillActivated(){
        return isSkillActivated;
    }
    public void setSkillActivated(boolean temp){
        isSkillActivated = temp;
    }
    public void endGame(){
        isGame = false;
    }

    public void saveTheGame(String fileName) throws IOException {
       String save = "";
       save += (x + " " + y + " " + Tour + " "+ temp + " "+ isSkillActivated+ " "+alive.size() + "\n" );
       for(int i = 0 ; i < alive.size(); i++){
           if(alive.get(i).getSign() == 'm'){
               save += alive.get(i).getSign() + " ";
               save += alive.get(i).position.getX() + " ";
               save += alive.get(i).position.getY() + " ";
               save += alive.get(i).getAge() + " ";
               save += alive.get(i).getSila() + " ";
               save += alive.get(i).getInicjatywa() + " ";

              save += alive.get(i).getSkillCounter() + " ";

           }
           else {
           save += alive.get(i).getSign() + " ";
           save += alive.get(i).position.getX() + " ";
           save += alive.get(i).position.getY() + " ";
           save += alive.get(i).getAge() + " ";
           save += alive.get(i).getSila() + " ";
               save += alive.get(i).getInicjatywa() + " ";

          // save += alive.get(i).getName() + " ";
          }

            save += "\n";

       }
       //save += '\n';
        String[] elements = save.split("\n");
       // String path = ".\\src\\proj\\java\\saves\\" + fileName;
        // System.out.print(content);
        File file = new File(fileName);
        System.out.println("Write to " + fileName);
        file.createNewFile();
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        for(String it : elements){
            writer.write(it);
            writer.newLine();
        }
        writer.close();

    }


    public void clearGame() {
        mapPanel.deleterScreen();
        map = null;
        x = 0;
        y = 0;
        alive.clear();
    }

    public void loadTheGame(String fileName) throws IOException {


        File file = new File(fileName);
        if (file.exists()) {
            clearGame();
           map = null;
            alive.clear();
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            String[] elements = line.split(" ");

            x = Integer.parseInt(elements[0]);
           y = Integer.parseInt(elements[1]);
           Tour = Integer.parseInt(elements[2]);
           temp = Integer.parseInt(elements[3]);
            isSkillActivated = Boolean.parseBoolean(elements[4]);
            int tempSize = Integer.parseInt(elements[5]);


            map = new Organizm[y][x];
            for (int i = 0; i < y; i++) {
                for (int j = 0; j < x; j++) {
                    map[i][j] = new Ground();
                }
            }
            for (int i = 0; i < tempSize; i++) {
                line = reader.readLine();

                elements = line.split(" ");
                switch (elements[0]) {
                    case "m":
                        Organizm org = new Man(this,new Point(Integer.parseInt(elements[1]), Integer.parseInt(elements[2])),Integer.parseInt(elements[3]),//age
                                Integer.parseInt(elements[4]),//power
                                Integer.parseInt(elements[5])//initiative
                        );
                       org.setSkillCounter(Integer.parseInt(elements[6]));
                        createOrganizm(org);//turnsLeft


                        break;
                    case "a":
                        createOrganizm(new Antelope(this,//world
                                new Point(Integer.parseInt(elements[1]), Integer.parseInt(elements[2])),//posiiton
                                Integer.parseInt(elements[3]),//age
                                Integer.parseInt(elements[4]),//power
                                Integer.parseInt(elements[5])));//initiative
                        break;

                    case "w":
                        createOrganizm(new Wolf(this,//world
                                new Point(Integer.parseInt(elements[1]), Integer.parseInt(elements[2])),
                                Integer.parseInt(elements[3]),//age
                                Integer.parseInt(elements[4]),//power
                                Integer.parseInt(elements[5])));//initiative
                        break;
                    case "f":
                        createOrganizm(new Fox(this,//world
                                new Point(Integer.parseInt(elements[1]), Integer.parseInt(elements[2])),//posiiton
                                Integer.parseInt(elements[3]),//age
                                Integer.parseInt(elements[4]),//power
                                Integer.parseInt(elements[5])));//initiative
                        break;
                    case "s":
                        createOrganizm(new Sheep(this,//world
                                new Point(Integer.parseInt(elements[1]), Integer.parseInt(elements[2])),//posiiton
                                Integer.parseInt(elements[3]),//age
                                Integer.parseInt(elements[4]),//power
                                Integer.parseInt(elements[5])));//initiative
                        break;
                    case "t":
                        createOrganizm(new Turtle(this,//world
                                new Point(Integer.parseInt(elements[1]), Integer.parseInt(elements[2])),//posiiton
                                Integer.parseInt(elements[3]),//age
                                Integer.parseInt(elements[4]),//power
                                Integer.parseInt(elements[5])));//initiative
                        break;
                    case "h":
                        createOrganizm(new Heracleum(this,//world
                                new Point(Integer.parseInt(elements[1]), Integer.parseInt(elements[2])),//posiiton
                                Integer.parseInt(elements[3]),//age
                                Integer.parseInt(elements[4]),//power
                                Integer.parseInt(elements[5])));//initiative
                        break;
                    case "g":
                        createOrganizm(new Guarana(this,//world
                                new Point(Integer.parseInt(elements[1]), Integer.parseInt(elements[2])),//posiiton
                                Integer.parseInt(elements[3]),//age
                                Integer.parseInt(elements[4]),//power
                                Integer.parseInt(elements[5])));//initiative
                        break;
                    case "b":
                        createOrganizm(new Wolfberries(this,//world
                                new Point(Integer.parseInt(elements[1]), Integer.parseInt(elements[2])),//posiiton
                                Integer.parseInt(elements[3]),//age
                                Integer.parseInt(elements[4]),//power
                                Integer.parseInt(elements[5])));//initiative
                        break;
                    case "r":
                        createOrganizm(new Grass(this,//world
                                new Point(Integer.parseInt(elements[1]), Integer.parseInt(elements[2])),//posiiton
                                Integer.parseInt(elements[3]),//age
                                Integer.parseInt(elements[4]),//power
                                Integer.parseInt(elements[5])));//initiative
                        break;
                    case "d":
                        createOrganizm(new Dandelion(this,//world
                                new Point(Integer.parseInt(elements[1]), Integer.parseInt(elements[2])),//posiiton
                                Integer.parseInt(elements[3]),//age
                                Integer.parseInt(elements[4]),//power
                                Integer.parseInt(elements[5])));//initiative
                        break;
                    //
                }
            }
            printWorld();

        }
    }




}
