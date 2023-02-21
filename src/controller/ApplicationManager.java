package controller;

import java.util.List;

public interface ApplicationManager<T>
{

    List<T> readFile();


    void writeFile(List<T> dataList);

    void display();

    T  get(String code);

    boolean add(T t);

    void update(T t);

    void remove(T t);

    void sortByScoreAscending();

    void sortByScoreDescending();
}
