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

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3));

        JTextField searchInput = new JTextField(1);
        panel.add(searchInput);

        JButton search = new JButton("SEARCH");
        search.setVerticalTextPosition(AbstractButton.CENTER);
        panel.add(search);

        JButton folder = new JButton("FOLDER");
        folder.setVerticalTextPosition(AbstractButton.CENTER);
        panel.add(folder);

        mainFrame.add(panel);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainFrame.setPreferredSize(new Dimension(550, 450));
        mainFrame.pack();
        mainFrame.setVisible(true);
    }


}
