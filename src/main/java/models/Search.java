package models;

import java.util.ArrayList;

/**
 * @author anton
 * @date 26.04.16.
 */
public class Search {

    private String path;
    private String fileName;
    private ArrayList<String> searchResult;

    Search(String fileName) {
        this.fileName = fileName;
    }

    Search(String fileName, String path) {
        this.fileName = fileName;
        this.path = path;
    }

    public ArrayList<String> searchFile() {

        return searchResult;
    }
}
