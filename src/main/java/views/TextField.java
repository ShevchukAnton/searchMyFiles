package views;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * @author anton
 * @date 26.04.16.
 */
public class TextField extends JTextField{

    TextField(String label, Point location, Point size, boolean isEmptyBorder, boolean isEnabled, boolean isEditable,
              Color background) {

        if (isEmptyBorder) {
            super.setBorder(BorderFactory.createEmptyBorder());
        }
        if (background != null) {
            super.setBackground(background);
        }
        super.setText(label);
        super.setLocation(location);
        super.setSize(size.x, size.y);
        super.setEnabled(isEnabled);
        super.setEditable(isEditable);
    }
}
