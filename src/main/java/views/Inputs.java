package views;

import javax.swing.*;
import java.awt.*;

/**
 * @author anton
 * @date 26.04.16.
 */
public class Inputs {

    public Container addElements() {

        Container cont = new Container();

        JTextField searchInput = new JTextField();
        searchInput.setSize(400, 30);
        searchInput.setLocation(0, 100);
        cont.add(searchInput);

        JButton search = new JButton("SEARCH");
        search.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        search.setIcon(new ImageIcon("src/main/resources/search_icon.png"));
        search.setSize(150, 30);
        search.setLocation(400, 100);
        cont.add(search);

        JTextField folderInput = new JTextField();
        folderInput.setSize(400, 30);
        folderInput.setLocation(0, 200);
        cont.add(folderInput);

        JButton folder = new JButton("FOLDER");
        folder.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        folder.setIcon(new ImageIcon("src/main/resources/folder_icon.png"));
        folder.setSize(150, 30);
        folder.setLocation(400, 200);
        folder.setEnabled(false);
        cont.add(folder);

        JCheckBox enableFolder = new JCheckBox();
        enableFolder.setLocation(0, 175);
        enableFolder.setSize(20, 20);
        cont.add(enableFolder);

        JTextField checkBoxLabel = createJTextFieldWithEmptyBorders("Search in :");
        checkBoxLabel.setSize(80, enableFolder.getHeight());
        checkBoxLabel.setEditable(false);
        checkBoxLabel.setLocation(20, 175);
        cont.add(checkBoxLabel);

        JTextField outputLabel = createJTextFieldWithEmptyBorders("Results :");
        outputLabel.setEditable(false);
        outputLabel.setSize(70, 20);
        outputLabel.setLocation(0, 280);
        cont.add(outputLabel);

        JTextField outputField = new JTextField();
        outputField.setLocation(0, 300);
        outputField.setSize(550, 150);
        outputField.setBackground(new Color(255, 255, 255));
        outputField.setEditable(false);
        cont.add(outputField);

        return cont;
    }

    private static JTextField createJTextFieldWithEmptyBorders(String text) {
        JTextField field = new JTextField();
        field.setBorder(BorderFactory.createEmptyBorder());
        field.setText(text);
        return field;
    }
}
