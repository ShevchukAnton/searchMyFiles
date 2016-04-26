package models;

import java.util.ArrayList;

/**
 * @author anton
 * @date 26.04.16.
 */
public class Search {

    private String path;
    private ArrayList<String> searchResult;

    public ArrayList<String> searchFile() {

        return searchResult;
    }

    public ArrayList<String> searchFile(String path) {
        this.path = path;
        return searchResult;
    }
}
