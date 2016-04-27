package views;

import java.awt.*;
import java.util.ArrayList;

/**
 * @author anton
 * @date 27.04.16.
 */
public class MainContainer {
    public Container container = new Container();

    public Container getContainer() {
        return container;
    }

    public void addToContainer(ArrayList<Component> elements) {
        for (Component o : elements) {
            container.add(o);
        }
    }
}
