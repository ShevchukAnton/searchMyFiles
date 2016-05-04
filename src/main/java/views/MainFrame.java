package views;

import javax.swing.*;
import java.awt.*;

/**
 * @author anton
 * @date 27.04.16.
 */
public class MainFrame extends JFrame {
    private Button search;
    private Button folderSearch;
    private Button folder;
    private Button copyPath;
    private Button openFolder;
    private Checkbox enableFolder;
    private TextField selectedFolder;
    private TextField searchInput;
    private TextField outputField;

    public MainFrame() {
        super.setTitle("Search My Files");
        Container container = new Container();

        search = new Button("SEARCH", new Point(400, 50), new Point(150, 30),
                new Font("Times New Roman", Font.PLAIN, 18), new ImageIcon("src/main/resources/search_icon.png"), true);
        container.add(search);
        folderSearch = new Button("SEARCH", new Point(400, 150), new Point(150, 30),
                new Font("Times New Roman", Font.PLAIN, 18), new ImageIcon("src/main/resources/search_icon.png"), false);
        container.add(folderSearch);
        folder = new Button("Folder", new Point(100, 122), new Point(100, 25), null,
                new ImageIcon("src/main/resources/folder_icon.png"), false);
        container.add(folder);
        copyPath = new Button("Copy Path", new Point(310, 210), new Point(110, 20), null, null, false);
        container.add(copyPath);
        openFolder = new Button("Open Folder", new Point(425, 210), new Point(125, 20), null, null, false);
        container.add(openFolder);

        searchInput = new TextField("", new Point(0, 50), new Point(400, 30), false, true, true, null);
        container.add(searchInput);
        TextField searchInFolder = new TextField("", new Point(0, 150), new Point(400, 30), false, false, false, null);
        container.add(searchInFolder);

        enableFolder = new Checkbox(new Point(0, 125), new Point(20, 20));
        container.add(enableFolder);

        TextField checkboxLabel = new TextField("Search in :", new Point(20, 125), new Point(80, enableFolder.getHeight()),
                true, true, false, null);
        container.add(checkboxLabel);
        selectedFolder = new TextField("", new Point(200, 125), new Point(350, 20), true, true, false, null);
        container.add(selectedFolder);
        TextField outputLabel = new TextField("Results :", new Point(0, 210), new Point(70, 20), true, true, false, null);
        container.add(outputLabel);
        outputField = new TextField("", new Point(0, 230), new Point(550, 220), false, false, false,
                new Color(255, 255, 255));
        container.add(outputField);

        add(container);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(550, 450));
        setResizable(false);
        pack();
        setVisible(true);
    }

    public Button getSearch() {
        return search;
    }

    public Button getFolderSearch() {
        return folderSearch;
    }

    public Button getFolder() {
        return folder;
    }

    public Button getCopyPath() {
        return copyPath;
    }

    public Button getOpenFolder() {
        return openFolder;
    }

    public Checkbox getEnableFolder() {
        return enableFolder;
    }

    public TextField getSelectedFolder() {
        return selectedFolder;
    }

    public TextField getSearchInput() {
        return searchInput;
    }

    public TextField getOutputField() {
        return outputField;
    }
}
