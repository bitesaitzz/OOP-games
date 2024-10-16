package Interface2;

import javax.swing.*;
import java.awt.*;

public class Menu extends JPanel {

    private JTextArea infoText;

    public Menu() {
        // Устанавливаем layout панели
        setLayout(new BorderLayout());

        // Создаем текстовую область и добавляем ее на панель
        infoText = new JTextArea();
        infoText.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(infoText);
        add(scrollPane, BorderLayout.CENTER);

        // Устанавливаем размеры панели
        setPreferredSize(new Dimension(250, 50));
    }

    // Метод для добавления текста в информационную панель
    public void addText(String text) {
        infoText.append(text + "\n");
    }
}
