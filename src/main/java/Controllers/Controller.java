package Controllers;

import models.Search;
import views.Button;
import views.Checkbox;
import views.MainFrame;
import views.TextField;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by anton on 04.05.16.
 */
public class Controller{
    private MainFrame frame = new MainFrame();
    private Checkbox flag = frame.getEnableFolder();
    private Button folder = frame.getFolder();
    private Button search = frame.getSearch();
    private TextField sFolder = frame.getSelectedFolder();
    private TextField searchInput = frame.getSearchInput();
    private TextField out = frame.getOutputField();
    private Search searcher = new Search();

    public Controller() {
        flag.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (flag.isSelected()) {
                    folder.setEnabled(true);
                } else {
                    folder.setEnabled(false);
                    sFolder.setText("");
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

        search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = searchInput.getText();
                searcher.find(input, null);
                List<String> results = searcher.getPaths();
                for (String s : results) {
                    out.setText(s + "\n");
                }
            }
        });

    }
}
