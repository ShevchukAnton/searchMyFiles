package models;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author anton
 * @date 26.04.16.
 */
public class Search {
    private List<String> paths;


    public Search() {
        paths = new ArrayList<String>();
    }

    public List<String> getPaths() {
        return paths;
    }

    public void find(String name, String dir) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null.");
        }
        File fileDir;
        if (dir == null) {
            fileDir = new File(System.getProperty("user.home"));
        } else {
            fileDir = new File(dir);
        }
        if (!fileDir.exists()) {
            throw new IllegalArgumentException("Directory does not exist.");
        }
        File[] files = fileDir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    find(name, file.toString());
                } else if (file.getName().toLowerCase().contains(name)) {
                    paths.add(file.getAbsolutePath());
                }
            }
        }
    }


}
