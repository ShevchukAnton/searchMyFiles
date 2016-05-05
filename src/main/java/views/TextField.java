package views;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * @author anton
 * @date 26.04.16.
 */
public class TextField extends JTextField{

    TextField(String label, Point location, Point size, boolean isEmptyBorder, boolean isEnabled, boolean isEditable) {

        if (isEmptyBorder) {
            super.setBorder(BorderFactory.createEmptyBorder());
        }
        super.setText(label);
        super.setLocation(location);
        super.setSize(size.x, size.y);
        super.setEnabled(isEnabled);
        super.setEditable(isEditable);
    }
}
