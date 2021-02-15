package ru.geekbrains.lesson8.hw2.Library;

public class Books {
    private final String name;
    private final String author;


    public Books(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }
}
