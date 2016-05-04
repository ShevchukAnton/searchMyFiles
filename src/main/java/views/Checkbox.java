package views;

import javax.swing.*;
import java.awt.*;

/**
 * Created by anton on 04.05.16.
 */
public class Checkbox extends JCheckBox {

    Checkbox(Point location, Point size) {
        super.setLocation(location);
        super.setSize(size.x, size.y);
    }
}
