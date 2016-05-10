package views;

import javax.swing.*;
import java.awt.*;

/**
 * Created by anton on 10.05.16.
 */
public class ScrollPanel extends JScrollPane {

    public ScrollPanel(Component comp, Point location, Point size) {
        super(comp);
        super.setLocation(location);
        super.setSize(size.x, size.y);
    }
}
