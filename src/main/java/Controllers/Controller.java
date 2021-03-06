package Controllers;

import models.Search;
import views.*;
import views.Button;
import views.Checkbox;
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
    private TextField searchError = frame.getSearchError();
    private Search searcher;
    private ListOfElements outListOfElements = frame.getListOfElements();
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
                    sFolder.setText(null);
                    folderSearch.setEnabled(false);
                    folderSearchInput.setEditable(false);
                    folderSearchInput.setEnabled(false);
                    folderSearchInput.setText(null);
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

        final Button search = frame.getSearch();
        search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (searchInput.getText().length() <= 0) {
                    searchError.setText("Enter what do you want to search");
                    searchError.setBackground(new Color(253, 152, 152));
                } else {
                    model.clear();
                    searchError.setText(null);
                    searchError.setBackground(new Color(236, 236, 236));
                    String input = searchInput.getText();
                    searcher = new Search(input, null);
                    searcher.exec();
                    List<String> results = searcher.getPaths();
                    for (String s : results) {
                        model.addElement(s);
                    }
                    results.clear();
                    frame.getCopyPath().setEnabled(true);
                    frame.getCopyPath().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    frame.getOpenFile().setEnabled(true);
                    frame.getOpenFile().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                }
            }
        });

        folderSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (frame.getSelectedFolder().getText().length() <= 0) {
                    searchError.setText("Select directory where do you want to search file!");
                    searchError.setBackground(new Color(253, 152, 152));
                } else if (frame.getSearchInFolder().getText().length() <= 0) {
                    searchError.setText("Enter what do you want to search");
                    searchError.setBackground(new Color(253, 152, 152));
                } else {
                    model.clear();
                    searchError.setText(null);
                    searchError.setBackground(new Color(236, 236, 236));
                    String input = frame.getSearchInFolder().getText();
                    String src = sFolder.getText();
                    searcher = new Search(input, src);
                    searcher.exec();
                    List<String> results = searcher.getPaths();
                    for (String s : results) {
                        model.addElement(s);
                    }
                    results.clear();
                    frame.getCopyPath().setEnabled(true);
                    frame.getCopyPath().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    frame.getOpenFile().setEnabled(true);
                    frame.getOpenFile().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                }
            }
        });

        frame.getOpenFile().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (outListOfElements.getSelectedValue() == null) {
                    frame.getFileActionError().setText("Select file that you want to open & then press button");
                    frame.getFileActionError().setBackground(new Color(253, 152, 152));
                } else {
                    frame.getFileActionError().setBackground(new Color(236, 236, 236));
                    frame.getFileActionError().setText(null);
                    String file = outListOfElements.getSelectedValue().toString();
                    //noinspection Since15
                    if (!Desktop.isDesktopSupported()) {
                        frame.getFileActionError().setText("Your platform doesn't support this function." +
                                " Copy file path manually");
                        frame.getFileActionError().setBackground(new Color(57, 253, 64));
                    } else {
                        try {
                            //noinspection Since15
                            Desktop.getDesktop().open(new File(file));
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            }
        });

        frame.getCopyPath().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (outListOfElements.getSelectedValue() == null) {
                    frame.getFileActionError().setText("There is nothing to copy. First select file.");
                    frame.getFileActionError().setBackground(new Color(253, 152, 152));
                } else {
                    frame.getFileActionError().setBackground(new Color(236, 236, 236));
                    frame.getFileActionError().setText(null);
                    String file = outListOfElements.getSelectedValue().toString();
                    StringSelection selection = new StringSelection(file);
                    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                    clipboard.setContents(selection, selection);
                }
            }
        });

    }
}
