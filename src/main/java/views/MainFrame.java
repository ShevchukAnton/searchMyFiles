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

        Container cont = new Container();
        cont.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.HORIZONTAL;
        JTextField searchInput = new JTextField(1);
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        cont.add(searchInput, c);

        JButton search = new JButton("SEARCH");
        search.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        search.setIcon(new ImageIcon("src/main/resources/search_icon.png"));
        c.weightx = 0.005;
        c.gridx = 1;
        c.gridy = 0;
        cont.add(search, c);

        JTextField fieldInput = new JTextField(1);
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 1;
        cont.add(fieldInput, c);

        JButton folder = new JButton("FOLDER");
        folder.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        folder.setIcon(new ImageIcon("src/main/resources/folder_icon.png"));
        c.weightx = 0.005;
        c.gridx = 1;
        c.gridy = 1;
        cont.add(folder, c);

        JCheckBox enableFolder = new JCheckBox();
        enableFolder.setLocation(0, 215);
        enableFolder.setSize(20, 20);
        mainFrame.add(enableFolder);

        JTextField checkBoxLabel = createJTextFieldWithEmptyBorders("Search in :");
        checkBoxLabel.setSize(80, enableFolder.getHeight());
        checkBoxLabel.setEditable(false);
        checkBoxLabel.setLocation(20, 215);
        mainFrame.add(checkBoxLabel);

        JTextField outputLabel = createJTextFieldWithEmptyBorders("Results :");
        outputLabel.setEditable(false);
        outputLabel.setSize(70, 20);
        outputLabel.setLocation(0, 280);
        mainFrame.add(outputLabel);

        JTextField outputField = new JTextField();
        outputField.setLocation(0, 300);
        outputField.setSize(550, 150);
        outputField.setBackground(new Color(255, 255, 255));
        outputField.setEditable(false);
        mainFrame.add(outputField);

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.add(cont);
        mainFrame.setPreferredSize(new Dimension(550, 450));
        mainFrame.setResizable(false);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    private static JTextField createJTextFieldWithEmptyBorders(String text) {
        JTextField field = new JTextField();
        field.setBorder(BorderFactory.createEmptyBorder());
        field.setText(text);
        return field;
    }
}
