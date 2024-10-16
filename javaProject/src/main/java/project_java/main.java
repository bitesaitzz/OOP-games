package project_java;
import project_java.*;

import javax.swing.*;

public class main {
    public static void main(String[] args){
        JFrame frame = new JFrame("Enter World Parameters");

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel label1 = new JLabel("Enter world width:");
        JTextField textField1 = new JTextField(10);
        panel.add(label1);
        panel.add(textField1);

        JLabel label2 = new JLabel("Enter world height:");
        JTextField textField2 = new JTextField(10);
        panel.add(label2);
        panel.add(textField2);

        JButton button = new JButton("OK");
        button.addActionListener(e -> {
            int width = Integer.parseInt(textField1.getText());
            int height = Integer.parseInt(textField2.getText());
            World world = new World(width, height);
            frame.dispose();
            world.printWorld();

        });

        panel.add(button);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);


    }

}


