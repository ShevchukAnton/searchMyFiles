package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * @author anton
 * @date 26.04.16.
 */
public class Elements extends Component implements ActionListener {

    private JTextField folderInput;

    public Container addElements() {

        Container cont = new Container();

        JTextField searchInput = new JTextField();
        searchInput.setSize(400, 30);
        searchInput.setLocation(0, 100);
        cont.add(searchInput);

        JButton search = new JButton("SEARCH");
        search.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        search.setIcon(new ImageIcon("src/main/resources/search_icon.png"));
        search.setSize(150, 30);
        search.setLocation(400, 100);
        cont.add(search);

        folderInput = new JTextField();
        folderInput.setSize(400, 30);
        folderInput.setLocation(0, 200);
        folderInput.setEnabled(false);
        cont.add(folderInput);

        JButton folderSearch = new JButton("SEARCH");
        folderSearch.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        folderSearch.setIcon(new ImageIcon("src/main/resources/search_icon.png"));
        folderSearch.setSize(150, 30);
        folderSearch.setLocation(400, 200);
        folderSearch.setEnabled(false);
        cont.add(folderSearch);

        JCheckBox enableFolder = new JCheckBox();
        enableFolder.setLocation(0, 175);
        enableFolder.setSize(20, 20);
        cont.add(enableFolder);

        JTextField checkBoxLabel = createJTextFieldWithEmptyBorders("Search in :");
        checkBoxLabel.setSize(80, enableFolder.getHeight());
        checkBoxLabel.setEditable(false);
        checkBoxLabel.setLocation(20, 175);
        cont.add(checkBoxLabel);

        JButton folder = new JButton("Folder");
        folder.setLocation(100, 175);
        folder.setSize(80, 25);
        folder.addActionListener(this);
        folder.setEnabled(false);
        cont.add(folder);

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

    public void actionPerformed(ActionEvent actionEvent) {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        chooser.setDialogTitle("Select Folder");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            folderInput.setText(chooser.getSelectedFile().getAbsolutePath());
        }
    }
}
