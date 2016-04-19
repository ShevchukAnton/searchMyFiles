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
        search.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        search.setIcon(new ImageIcon("src/main/resources/search_icon.png"));
        search.setVerticalTextPosition(AbstractButton.CENTER);
        panel.add(search);

        JButton folder = new JButton("FOLDER");
        folder.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        folder.setIcon(new ImageIcon("src/main/resources/folder_icon.png"));
        folder.setVerticalTextPosition(AbstractButton.CENTER);
        panel.add(folder);

        mainFrame.add(panel);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainFrame.setPreferredSize(new Dimension(550, 450));
        mainFrame.pack();
        mainFrame.setVisible(true);
    }


}
