package ru.geekbrains.lesson8.hw2.Library;

import ru.geekbrains.lesson7.Colorize;

public class Journal {
    private int places;
    private final Visitors[] visitors;

    public Journal(int places) {
        this.visitors = new Visitors[places];
        this.places = places;
    }

    public void signNewVisitor(LibraryRooms libraryRoom, Visitors visitor) {
        if (isVisitorAlreadySign(visitor)) {
            System.out.println(Colorize.make(
                    "error",
                    "Visitor " + visitor.getVisitorName() + " already sign")
            );
        } else if (isNotEnoughPlaces()) {
            System.out.println(
                    Colorize.make(
                            "error",
                            "Sorry " + visitor.getVisitorName() + ", no seats available"
                    )
            );
        } else addVisitor(libraryRoom, visitor);
    }

    public void addVisitor(LibraryRooms libraryRoom, Visitors visitor) {
        places--;

        this.visitors[places] = visitor;

        System.out.println(
                Colorize.make(
                        "ok",
                        "Have a seat please " + visitor.getVisitorName()
                ) + " in Library: " + libraryRoom.getRoomName() + "."
        );
    }

    public void removeVisitor(Visitors visitor) {
        places++;
        removeVisitorFromList(visitor);

        System.out.println(Colorize.make(
                "ok",
                "Bye bye " + visitor.getVisitorName() + ".")
        );
    }

    public boolean isVisitorAlreadySign(Visitors signVisitor) {
        for (Visitors visitor : this.visitors)
            if (visitor == signVisitor)
                return true;

        return false;
    }

    public boolean isNotEnoughPlaces() {
        return places <= 0;
    }

    public void removeVisitorFromList(Visitors visitor) {
        for (Visitors signVisitor : this.visitors) {
            if (visitor == signVisitor) {
                visitor = null;

                break;
            }
        }
    }
}
