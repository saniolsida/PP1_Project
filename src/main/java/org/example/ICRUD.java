package org.example;

import java.util.ArrayList;

public interface ICRUD {
    public void listAll();
    public void add();
    public ArrayList<Integer> listAll(String keyword);
    public void updateWord();

    public void deleteWord();

}
