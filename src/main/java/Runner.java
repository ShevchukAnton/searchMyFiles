import views.Elements;

import javax.swing.*;
import java.awt.*;

/**
 * @author anton
 * @date 26.04.16.
 */
public class Runner {

    public static void main(String[] args) {
        final JFrame app = new JFrame();
        Elements elements = new Elements();
        app.add(elements.addElements());

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
