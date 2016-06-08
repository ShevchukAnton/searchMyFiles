package models;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author anton
 * @date 26.04.16.
 */
public class Search {
    private List<String> paths;
    private List<String> dirs;
    private String name;
    private String dir;

    public Search(String name, String dir) {
        dirs = new ArrayList<>();
        paths = new ArrayList<>();
        this.name = name;
        this.dir = dir;
    }

    public List<String> getPaths() {
        return paths;
    }

    private void find(String src) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null.");
        }
        File fileDir;
        fileDir = new File(src);

        if (!fileDir.exists()) {
            throw new IllegalArgumentException("Directory does not exist.");
        }
        File[] files = fileDir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.getName().toLowerCase().contains(name)) {
                    paths.add(file.getAbsolutePath());
                }
            }
        }
    }

    private void index() {
        File fileDir;
        if (dir == null) {
            String isWindows = System.getProperty("os.name");
            if (isWindows.contains("Windows")) {
                fileDir = new File("C:\\");
            } else {
                fileDir = new File(System.getProperty("user.home"));
            }
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
                    dirs.add(file.getAbsolutePath());
                }
            }
        }
    }

    public void exec() {
        index();
        for (int i = 0; i < dirs.size(); i++) {
            find(dirs.get(i));
        }
    }
}
