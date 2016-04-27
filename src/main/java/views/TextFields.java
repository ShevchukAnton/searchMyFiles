package views;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * @author anton
 * @date 26.04.16.
 */
public class TextFields {

    private JTextField selectedFolder;
    private JTextField searchInFolder;
    private JTextField searchInput;
    private ArrayList<Component> fields = new ArrayList<Component>();

    public TextFields() {

        searchInput = new JTextField();
        searchInput.setSize(400, 30);
        searchInput.setLocation(0, 50);
        fields.add(searchInput);

        searchInFolder = new JTextField();
        searchInFolder.setSize(400, 30);
        searchInFolder.setLocation(0, 150);
        searchInFolder.setEnabled(false);
        fields.add(searchInFolder);

        JCheckBox enableFolder = new JCheckBox();
        enableFolder.setLocation(0, 125);
        enableFolder.setSize(20, 20);
        fields.add(enableFolder);

        JTextField checkBoxLabel = createJTextFieldWithEmptyBorders("Search in :");
        checkBoxLabel.setSize(80, enableFolder.getHeight());
        checkBoxLabel.setEditable(false);
        checkBoxLabel.setLocation(20, 125);
        fields.add(checkBoxLabel);

        selectedFolder = createJTextFieldWithEmptyBorders(null);
        selectedFolder.setEditable(false);
        selectedFolder.setLocation(200, 125);
        selectedFolder.setSize(350, 20);
        fields.add(selectedFolder);

        JTextField outputLabel = createJTextFieldWithEmptyBorders("Results :");
        outputLabel.setEditable(false);
        outputLabel.setSize(70, 20);
        outputLabel.setLocation(0, 210);
        fields.add(outputLabel);

        JTextField outputField = new JTextField();
        outputField.setLocation(0, 230);
        outputField.setSize(550, 220);
        outputField.setBackground(new Color(255, 255, 255));
        outputField.setEditable(false);
        fields.add(outputField);
    }

    private static JTextField createJTextFieldWithEmptyBorders(String text) {
        JTextField field = new JTextField();
        if (text == null) {
            field.setText("");
        }
        field.setBorder(BorderFactory.createEmptyBorder());
        field.setText(text);
        return field;
    }

    public String getSelectedFolder() {
        return selectedFolder.getText();
    }

    public String getSearchInput() {
        return searchInput.getText();
    }

    public String getSearchInFolder() {
        return searchInFolder.getText();
    }

    public ArrayList<Component> getFields() {
        return fields;
    }
}
