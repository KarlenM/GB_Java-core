package ru.geekbrains.lesson8.hw2.Library;

import ru.geekbrains.lesson7.Colorize;

public class Visitors {
    private final String visitorName;
    private final String noiseType;
    private Books book;

    public Visitors(String visitorName, String noiseType) {
        this.visitorName = visitorName;
        this.noiseType = noiseType;
    }

    public int getNoiseVolume() {
        if (noiseType.equals("noisy"))
            return 2;

        else if (noiseType.equals("usual"))
            return 1;

        return 0;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public void takeBook(Books book) {
        if (isBookAlreadyTaken())
            System.out.println(
                    Colorize.make(
                            "error",
                            "Book already taken"
                    )
            );

        else {
            this.book = book;

            System.out.println(
                    Colorize.make(
                            "ok",
                            "Visitor " + visitorName + " take a book: "
                    ) + book.getAuthor() + " - " + book.getName()
            );
        }
    }

    private boolean isBookAlreadyTaken() {
        return book != null;
    }
}
