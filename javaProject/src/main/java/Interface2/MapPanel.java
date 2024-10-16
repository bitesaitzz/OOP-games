package Interface2;
import project_java.*;
import project_java.Point;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.Vector;
import javax.swing.*;

public class MapPanel extends JPanel  {
    private int width;
    private int height;
    private Organizm[][] map;
    private JTextArea infoArea;

    World world;
    public MapPanel(int width, int height, Organizm[][] map, World world) {
        this.width = width;
        this.height = height;
        this.map = map;
        this.world = world;
        addKeyListener(new MyKeyListener());
        setFocusable(true);
        infoArea = new JTextArea(15, 20);
        infoArea.setEditable(false);
        addMouseListener(new MyMouseListener());

// Создаем панель прокрутки для текстового поля
        JScrollPane scrollPane = new JScrollPane(infoArea);

// Добавляем панель прокрутки рядом с картой
        setLayout(new BorderLayout());
        scrollPane.setSize(280, 600);
        scrollPane.setPreferredSize(new Dimension(280, 600));
        add(scrollPane, BorderLayout.EAST);
        /*
        JTextArea infoArea = new JTextArea(10, 20);
        infoArea.setEditable(false);

// Создаем панель прокрутки для текстового поля
        JScrollPane scrollPane = new JScrollPane(infoArea);

// Добавляем панель прокрутки рядом с картой
        scrollPane.setPreferredSize(new Dimension(200, 200));
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.EAST);

         */

    }
    public void addInfo(String str){
        infoArea.append(str+"\n");
    }
    public void deleteInfo(){
        infoArea.setText("");
    }
    public void deleterScreen(){
    Window window = SwingUtilities.getWindowAncestor(this);
        if (window != null) {
        window.dispose(); // Удаляем окно
    }}
    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);


        int cellWidth = (getWidth() -280)/ width;
        int cellHeight = getHeight() / height;



        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {

               Organizm organism = map[x][y];


                // Вычисляем координаты клетки на панели
                int cellX = x * cellWidth;
                int cellY = y * cellHeight;

                // Рисуем клетку
                if (organism != null) {
                    if(organism.getImage() != null){
                    Image image = organism.getImage();
                    g.drawImage(image, cellX, cellY, cellWidth, cellHeight, null);}
                    else {
                    g.setColor(organism.getColor()); // устанавливаем цвет организма
                    g.fillRect(cellX, cellY, cellWidth, cellHeight); // рисуем прямоугольник
                } }else {
                    //g.setColor(Color.WHITE);
                    g.setColor(new Color(206, 164, 129));

                    g.fillRect(cellX, cellY, cellWidth, cellHeight);
                }
            }

            //infoArea.append(sb.toString());
        }
       // addInfo("LETS GO");
    }
    public void doSomethingWithCell(int x, int y) {
        // do something with the clicked cell, e.g.

        String[] Options = {"Sheep","Grass","Wolf","Fox","Turtle", "Antelope",   "Dandelion",  "Guarana", "Wolfberries", "Heracleum" };



        int selectedOptionIndex = JOptionPane.showOptionDialog(
                null,
                "Select an option",
                "Options",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                Options,
                Options[0]
        );
        if (selectedOptionIndex > -1) {
            int needTyp = selectedOptionIndex +1 ;
            world.createOrganizm(needTyp, new Point(x,y));
    }}

    public class MyMouseListener extends MouseAdapter{
        public void mousePressed(MouseEvent e) {
            // Получаем координаты точки, на которую кликнул пользователь
            int x = e.getX();
            int y = e.getY();

            // Вычисляем индексы клетки на основе координат точки
            int cellWidth = (getWidth() - 280) / width;
            int cellHeight = getHeight() / height;
            int cellX = x / cellWidth;
            int cellY = y / cellHeight;

            // Вызываем новый метод с координатами клетки в качестве параметров
            doSomethingWithCell(cellY, cellX);
        }
    }
    public class MyKeyListener extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    world.setTemp(1);
                    world.nextTurn();
                    break;
                case KeyEvent.VK_DOWN:
                    world.setTemp(4);
                    world.nextTurn();
                    // передвинуть организмы на одну клетку вниз
                    break;
                case KeyEvent.VK_LEFT:
                    world.setTemp(2);
                   // world.change();
                    world.nextTurn();
                    // передвинуть организмы на одну клетку влево
                    break;
                case KeyEvent.VK_RIGHT:
                    world.setTemp(3);
                    //world.change2();
                    world.nextTurn();
                    // передвинуть организмы на одну клетку вправо
                    break;
                case KeyEvent.VK_S:
                    world.setTemp(5);
                   world.nextTurn();
                    break;
                    case KeyEvent.VK_Q:
                        world.endGame();
                        break;
                case KeyEvent.VK_G:

                    String nameFile = input();
                    try {
                        world.saveTheGame(nameFile);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    world.nextTurn();
                    break;
                case KeyEvent.VK_L:
                nameFile = input();
                    try {
                        world.loadTheGame(nameFile);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    world.clearInformation();
                    world.nextTurn();
                    break;

            }
           repaint();
        }
    }
    public String input(){
        // Используем JOptionPane для получения строки от пользователя
        String input = JOptionPane.showInputDialog(null, "Enter the information:", "The name of file", JOptionPane.PLAIN_MESSAGE);
        // Проверяем, что пользователь ввел строку
        if (input != null && !input.isEmpty()) {
            // Используем JOptionPane для отображения окна с введенной информацией
            JOptionPane.showMessageDialog(null, input, "You wrote: ", JOptionPane.INFORMATION_MESSAGE);
            return input; // Возвращаем введенную пользователем строку
        }
        return null; // Если пользователь не ввел строку, возвращаем null
    }


}



