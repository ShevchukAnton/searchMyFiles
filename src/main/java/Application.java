import Controllers.Controller;
import views.MainFrame;

import javax.swing.*;

/**
 * @author anton
 * @date 26.04.16.
 */
public class Application {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Controller();
            }
        });
    }
}
