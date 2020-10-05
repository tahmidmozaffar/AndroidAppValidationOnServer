package com.remotearth.server;

import java.util.ArrayList;
import java.util.List;

public class DummyData {

    public static List<Book> getDummyBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1,"Book1", "Genre1"));
        books.add(new Book(2,"Book2", "Genre2"));
        books.add(new Book(3,"Book3", "Genre3"));
        books.add(new Book(4,"Book4", "Genre4"));
        books.add(new Book(5,"Book5", "Genre5"));

        return books;
    }
}
