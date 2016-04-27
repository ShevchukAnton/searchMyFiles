package views;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * @author anton
 * @date 27.04.16.
 */
public class Buttons {
    private ArrayList<Component> buttons = new ArrayList<Component>();

    public Buttons() {

        JButton search = new JButton("SEARCH");
        search.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        search.setIcon(new ImageIcon("src/main/resources/search_icon.png"));
        search.setSize(150, 30);
        search.setLocation(400, 50);
        buttons.add(search);

        JButton folderSearch = new JButton("SEARCH");
        folderSearch.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        folderSearch.setIcon(new ImageIcon("src/main/resources/search_icon.png"));
        folderSearch.setSize(150, 30);
        folderSearch.setLocation(400, 150);
        folderSearch.setEnabled(false);
        buttons.add(folderSearch);

        JButton folder = new JButton("Folder");
        folder.setIcon(new ImageIcon("src/main/resources/folder_icon.png"));
        folder.setLocation(100, 122);
        folder.setSize(100, 25);
        folder.setEnabled(false);
        buttons.add(folder);

        JButton copyPath = new JButton("Copy Path");
        copyPath.setLocation(310, 210);
        copyPath.setSize(110, 20);
        copyPath.setEnabled(false);
        buttons.add(copyPath);

        JButton openFolder = new JButton("Open Folder");
        openFolder.setLocation(425, 210);
        openFolder.setSize(125, 20);
        openFolder.setEnabled(false);
        buttons.add(openFolder);
    }

    public ArrayList<Component> getButtons() {
        return buttons;
    }
}
