package com.remotearth.server;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {
    @Id
    private Integer id;
    private String name;
    private String genre;

    public Book(String name, String genre) {
        this.name = name;
        this.genre = genre;
    }

    public Book(Integer id, String name, String genre) {
        this.id = id;
        this.name = name;
        this.genre = genre;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
