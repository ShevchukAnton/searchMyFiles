package views;

import javax.swing.*;
import java.awt.*;

/**
 * @author anton
 * @date 27.04.16.
 */
public class MainFrame {

    public MainFrame() {
        final JFrame app = new JFrame("Search My Files");
        Container container = new Container();

        Button search = new Button("SEARCH", new Point(400, 50), new Point(150, 30),
                new Font("Times New Roman", Font.PLAIN, 18), new ImageIcon("src/main/resources/search_icon.png"), true);
        container.add(search.getButton());
        Button folderSearch = new Button("SEARCH", new Point(400, 150), new Point(150, 30),
                new Font("Times New Roman", Font.PLAIN, 18), new ImageIcon("src/main/resources/search_icon.png"), false);
        container.add(folderSearch.getButton());
        Button folder = new Button("Folder", new Point(100, 122), new Point(100, 25), null,
                new ImageIcon("src/main/resources/folder_icon.png"), false);
        container.add(folder.getButton());
        Button copyPath = new Button("Copy Path", new Point(310, 210), new Point(110, 20), null, null, false);
        container.add(copyPath.getButton());
        Button openFolder = new Button("Open Folder", new Point(425, 210), new Point(125, 20), null, null, false);
        container.add(openFolder.getButton());

        TextField searchInput = new TextField("", new Point(0, 50), new Point(400, 30), false, true, false, null);
        container.add(searchInput.getField());
        TextField searchInFolder = new TextField("", new Point(0, 150), new Point(400, 30), false, false, false, null);
        container.add(searchInFolder.getField());

        JCheckBox enableFolder = new JCheckBox();
        enableFolder.setLocation(0, 125);
        enableFolder.setSize(20, 20);
        container.add(enableFolder);

        TextField checkboxLabel = new TextField("Search in :", new Point(20, 125), new Point(80, enableFolder.getHeight()),
                true, true, false, null);
        container.add(checkboxLabel.getField());
        TextField selectedFolder = new TextField("", new Point(200, 125), new Point(350, 20), true, true, false, null);
        container.add(selectedFolder.getField());
        TextField outputLabel = new TextField("Results :", new Point(0, 210), new Point(70, 20), true, true, false, null);
        container.add(outputLabel.getField());
        TextField outputField = new TextField("", new Point(0, 230), new Point(550, 220), false, false, false,
                new Color(255, 255, 255));
        container.add(outputField.getField());

        app.add(container);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setPreferredSize(new Dimension(550, 450));
        app.setResizable(false);
        app.pack();
        app.setVisible(true);
    }
}
