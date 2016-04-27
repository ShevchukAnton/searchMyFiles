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
        TextFields textFields = new TextFields();
        Buttons buttons = new Buttons();
        MainContainer container = new MainContainer();
        container.addToContainer(buttons.getButtons());
        container.addToContainer(textFields.getFields());
        app.add(container.getContainer());

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                app.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
                app.setPreferredSize(new Dimension(550, 450));
                app.setResizable(false);
                app.pack();
                app.setVisible(true);
            }
        });
    }
}
