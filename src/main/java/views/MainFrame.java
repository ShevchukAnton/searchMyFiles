package views;

import javax.swing.*;
import java.awt.*;

/**
 * @author anton
 * @date 18.04.16.
 */
public class MainFrame extends JFrame{

    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("Search My Files");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainFrame.setPreferredSize(new Dimension(550, 450));
        Inputs input = new Inputs();
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    static class Inputs extends JPanel {

        void fileNameInput() {
            JTextField fileName = new JTextField();
            fileName.setEditable(true);
            add(fileName);
        }
    }
}
