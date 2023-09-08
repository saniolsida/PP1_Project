package org.example;

import java.util.ArrayList;

public interface ICRUD {
    public void listAll();

    // search
    ArrayList<Integer> listAll(String keyword);

    // search
    void listAll(int slevel);

    public void add();

    // search
    public void search(String keyword);
    public void updateWord();

    public void deleteWord();

}
