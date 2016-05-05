package Controllers;

import models.Search;
import views.Button;
import views.Checkbox;
import views.MainFrame;
import views.TextField;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by anton on 04.05.16.
 */
public class Controller{
    private MainFrame frame = new MainFrame();
    private Checkbox flag = frame.getEnableFolder();
    private Button folder = frame.getFolder();
    private Button folderSearch = frame.getFolderSearch();
    private TextField sFolder = frame.getSelectedFolder();
    private TextField searchInput = frame.getSearchInput();
    private TextField folderSearchInput = frame.getSearchInFolder();
    private Search searcher = new Search();
    private JList outList = frame.getList();

    private DefaultListModel model = frame.getListModel();

    public Controller() {
        flag.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (flag.isSelected()) {
                    folder.setEnabled(true);
                    folder.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    folderSearch.setEnabled(true);
                    folderSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    folderSearchInput.setEditable(true);
                    folderSearchInput.setEnabled(true);
                } else {
                    folder.setEnabled(false);
                    sFolder.setText("");
                    folderSearch.setEnabled(false);
                    folderSearchInput.setEditable(false);
                    folderSearchInput.setEnabled(false);
                    folderSearchInput.setText("");
                }
            }
        });

        folder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                final JFileChooser fc = new JFileChooser(System.getProperty("user.home"));
                fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int resp = fc.showOpenDialog(folder);

                if (resp == JFileChooser.APPROVE_OPTION) {
                    String path = fc.getSelectedFile().getAbsolutePath();
                    sFolder.setText(path);
                }
            }
        });

        Button search = frame.getSearch();
        search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = searchInput.getText();
                searcher.find(input, null);
                List<String> results = searcher.getPaths();
                for (String s : results) {
                    model.addElement(s);
                }
                frame.getCopyPath().setEnabled(true);
                frame.getOpenFile().setEnabled(true);
            }
        });

        folderSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = frame.getSearchInFolder().getText();
                String src = sFolder.getText();
                searcher.find(input, src);
                List<String> results = searcher.getPaths();
                for (String s : results) {
                    model.addElement(s);
                }
                frame.getCopyPath().setEnabled(true);
                frame.getOpenFile().setEnabled(true);
            }
        });

        frame.getOpenFile().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String file = outList.getSelectedValue().toString();
                try {
                    //noinspection Since15
                    Desktop.getDesktop().open(new File(file));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        frame.getCopyPath().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String file = outList.getSelectedValue().toString();
                StringSelection selection = new StringSelection(file);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(selection, selection);
            }
        });

    }
}
