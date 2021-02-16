/*
    1. Сделать тихого и шумного посетителя, доброго и злого библиотекаря.
    Так же в зале есть уровень шума при добавлении нового читателя,
    если шумный, то увеличивается на 2
    если обычный, то на 1
    если тихий, то вообще не увеличиваем
    если уровень шума выше знначения, которое указывается для каждого читального зала отдельно, то
    библиотекарь на это реагирует если добрый то реагирует мягко, а злой реагирует грубо.

    2. Сделать архив с книгами по аналогии с читальным залом и добавить возможность
    для библиотекаря выдавать книги читателю, если у него ещё нет никакой книги.
    Так же проверять доступность книги при выдаче
 */

package ru.geekbrains.lesson8.hw2;

import ru.geekbrains.lesson8.hw2.Library.Librarians;
import ru.geekbrains.lesson8.hw2.Library.LibraryRooms;
import ru.geekbrains.lesson8.hw2.Library.Visitors;

import java.util.Random;

public class Main {
    private static final Random random = new Random();

    public static void main(String[] args) {
        LibraryRooms[] libraryRooms = new LibraryRooms[2];
        libraryRooms[0] = new LibraryRooms("Load room", 10, 10);
        libraryRooms[1] = new LibraryRooms("Quite room", 2, 3);

        Librarians[] librarians = new Librarians[2];
        librarians[0] = new Librarians(true);
        librarians[1] = new Librarians(false);


        Visitors[] visitors = new Visitors[13];
        visitors[0] = new Visitors("Bugs", "noisy");
        visitors[1] = new Visitors("Micky", "usual");
        visitors[2] = new Visitors("Duffy", "quiet");
        visitors[3] = new Visitors("Marvel", "noisy");
        visitors[4] = new Visitors("Capitan America", "usual");
        visitors[5] = new Visitors("SpiderMan", "quiet");
        visitors[6] = new Visitors("Flash", "noisy");
        visitors[7] = new Visitors("IronMan", "usual");
        visitors[8] = new Visitors("WonderWomen", "noisy");
        visitors[9] = new Visitors("Grout", "noisy");
        visitors[10] = new Visitors("Lola", "usual");
        visitors[11] = new Visitors("Greg", "noisy");
        visitors[12] = new Visitors("Max", "noisy");


        for (Visitors visitor : visitors) {
            System.out.println();
            int randomNum = random.nextInt(2);

            librarians[randomNum].giveVisitorPlace(libraryRooms[randomNum], visitor);
        }
    }
}
