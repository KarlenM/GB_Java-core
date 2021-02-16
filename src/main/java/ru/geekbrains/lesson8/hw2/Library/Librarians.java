package ru.geekbrains.lesson8.hw2.Library;

import ru.geekbrains.lesson7.Colorize;

public class Librarians {
    private final boolean angry;

    public Librarians(boolean angry) {
        this.angry = angry;
    }

    public void giveVisitorPlace(LibraryRooms libraryRoom, Visitors visitor) {
        libraryRoom.addNewVisitor(visitor);
        checkNoise(libraryRoom);
        giveBook(libraryRoom, visitor);
    }

    private void checkNoise(LibraryRooms libraryRooms) {
        if (libraryRooms.isNoisyInRoom()) {
            String result = angry
                    ? "Silence in the hall!!!"
                    : "Please, let's be quiet";

            System.out.println(
                    Colorize.make("error", result)
            );
        }
    }

    // Выдачу книг сделал автоматическую, но можно и из главного метода, поэтому public
    public void giveBook(LibraryRooms libraryRoom, Visitors visitor) {
        libraryRoom.bookArchive.giveBook(libraryRoom, visitor);
    }


}
