/*
    1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
    Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
    Посчитать, сколько раз встречается каждое слово.

    2. Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и телефонных номеров.
    В этот телефонный справочник с помощью метода add() можно добавлять записи, а с помощью метода get() искать
    номер телефона по фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов
    (в случае однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.
    Желательно не добавлять лишний функционал (дополнительные поля (имя, отчество, адрес),
    взаимодействие с пользователем через консоль и т.д). Консоль использовать только для
    вывода результатов проверки телефонного справочника.
 */
package ru.geekbrains.lesson10;

import java.util.*;

public class Main {
    private static final String[] words = {
            "папа", "мама", "сын",
            "дочь", "кошка", "собака",
            "утро", "телефон", "компьютер",
            "осень", "зима", "лето",
            "каникулы", "улыбки", "смех",
            "счастье", "улыбки", "любовь",
            "школа", "утро"
    };

    public static void main(String[] args) {
        getUniqueAndSumDuplicates();
        phoneBook();
    }

    private static void getUniqueAndSumDuplicates() {
        System.out.println("- Task 1 -");

        Map<String, Integer> map = new HashMap<>();

        for (String word : Main.words) {
            map.merge(word, 1, Integer::sum);
        }

        for (Map.Entry<String, Integer> o : map.entrySet()) {
            System.out.println(
                "Слово: " + o.getKey() + ", " +
                "Количество повторений: " + o.getValue()
            );
        }

        System.out.println();
    }

    private static void phoneBook() {
        System.out.println("- Task2 -");

        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Karlen", "+7 (921) 777-77-77");
        phoneBook.add("Jeff", "+7 (911) 777-77-77");
        phoneBook.add("First", "+7 (905) 777-77-77");
        phoneBook.add("Karlen", "+7 (945) 777-77-77");

        phoneBook.get("Karlen");

        System.out.println();
    }

}
