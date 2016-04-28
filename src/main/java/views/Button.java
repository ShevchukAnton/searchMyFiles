package views;

import javax.swing.*;
import java.awt.*;

/**
 * @author anton
 * @date 27.04.16.
 */
public class Button extends JButton {
    private JButton button = new JButton();

    public Button(String label, Point location, Point size, Font font, ImageIcon icon, boolean isEnabled) {

        if (font != null) {
            button.setFont(font);
        }
        if (icon != null) {
            button.setIcon(icon);
        }
        button.setText(label);
        button.setSize(size.x, size.y);
        button.setLocation(location);
        button.setEnabled(isEnabled);
    }

    public JButton getButton() {
        return button;
    }
}
