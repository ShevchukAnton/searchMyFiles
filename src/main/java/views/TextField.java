package views;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * @author anton
 * @date 26.04.16.
 */
public class TextField extends JTextField{

    private JTextField field = new JTextField();

    public TextField(String label, Point location, Point size, boolean isEmptyBorder, boolean isEnabled, boolean isEditable,
                     Color background) {

        if (isEmptyBorder) {
            field = createJTextFieldWithEmptyBorders();
        }
        if (background != null) {
            field.setBackground(background);
        }
        field.setText(label);
        field.setLocation(location);
        field.setSize(size.x, size.y);
        field.setEnabled(isEnabled);
        field.setEditable(isEditable);
    }

    private static JTextField createJTextFieldWithEmptyBorders() {
        JTextField field = new JTextField();
        field.setBorder(BorderFactory.createEmptyBorder());
        return field;
    }

    public JTextField getField() {
        return field;
    }
}
