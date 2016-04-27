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

    private JTextField selectedFolder;

    public Container addElements() {

        Container cont = new Container();

        JTextField searchInput = new JTextField();
        searchInput.setSize(400, 30);
        searchInput.setLocation(0, 50);
        cont.add(searchInput);

        JButton search = new JButton("SEARCH");
        search.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        search.setIcon(new ImageIcon("src/main/resources/search_icon.png"));
        search.setSize(150, 30);
        search.setLocation(400, 50);
        cont.add(search);

        JTextField folderInput = new JTextField();
        folderInput.setSize(400, 30);
        folderInput.setLocation(0, 150);
        folderInput.setEnabled(false);
        cont.add(folderInput);

        JButton folderSearch = new JButton("SEARCH");
        folderSearch.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        folderSearch.setIcon(new ImageIcon("src/main/resources/search_icon.png"));
        folderSearch.setSize(150, 30);
        folderSearch.setLocation(400, 150);
        folderSearch.setEnabled(false);
        cont.add(folderSearch);

        JCheckBox enableFolder = new JCheckBox();
        enableFolder.setLocation(0, 125);
        enableFolder.setSize(20, 20);
        cont.add(enableFolder);

        JTextField checkBoxLabel = createJTextFieldWithEmptyBorders("Search in :");
        checkBoxLabel.setSize(80, enableFolder.getHeight());
        checkBoxLabel.setEditable(false);
        checkBoxLabel.setLocation(20, 125);
        cont.add(checkBoxLabel);

        JButton folder = new JButton("Folder");
        folder.setIcon(new ImageIcon("src/main/resources/folder_icon.png"));
        folder.setLocation(100, 122);
        folder.setSize(100, 25);
        folder.addActionListener(this);
        folder.setEnabled(false);
        cont.add(folder);

        selectedFolder = createJTextFieldWithEmptyBorders(null);
        selectedFolder.setEditable(false);
        selectedFolder.setLocation(200, 125);
        selectedFolder.setSize(350, 20);
        cont.add(selectedFolder);

        JTextField outputLabel = createJTextFieldWithEmptyBorders("Results :");
        outputLabel.setEditable(false);
        outputLabel.setSize(70, 20);
        outputLabel.setLocation(0, 210);
        cont.add(outputLabel);

        JButton copyPath = new JButton("Copy Path");
        copyPath.setLocation(310, 210);
        copyPath.setSize(110, 20);
        copyPath.setEnabled(false);
        cont.add(copyPath);

        JButton openFolder = new JButton("Open Folder");
        openFolder.setLocation(425, 210);
        openFolder.setSize(125, 20);
        openFolder.setEnabled(false);
        cont.add(openFolder);

        JTextField outputField = new JTextField();
        outputField.setLocation(0, 230);
        outputField.setSize(550, 220);
        outputField.setBackground(new Color(255, 255, 255));
        outputField.setEditable(false);
        cont.add(outputField);

        return cont;
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

    public void actionPerformed(ActionEvent actionEvent) {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        chooser.setDialogTitle("Select Folder");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            selectedFolder.setText(chooser.getSelectedFile().getAbsolutePath());
        }
    }
}
