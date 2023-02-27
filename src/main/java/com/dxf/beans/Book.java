package com.dxf.beans;

public class Book {
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Book() {
    }

    public Book(int id, String name) {
        this.id = id;
        this.name = name;
    }

    int id;
    String name;
}
