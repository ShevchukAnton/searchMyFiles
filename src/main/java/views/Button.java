package views;

import javax.swing.*;
import java.awt.*;

/**
 * @author anton
 * @date 27.04.16.
 */
public class Button extends JButton {

    public Button(String label, Point location, Point size, Font font, ImageIcon icon, boolean isEnabled) {

        if (font != null) {
            super.setFont(font);
        }
        if (icon != null) {
            super.setIcon(icon);
        }
        super.setText(label);
        super.setSize(size.x, size.y);
        super.setLocation(location);
        super.setEnabled(isEnabled);
    }
}
