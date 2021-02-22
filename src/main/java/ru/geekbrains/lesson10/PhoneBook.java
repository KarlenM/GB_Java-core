package ru.geekbrains.lesson10;

import java.util.*;

public class PhoneBook {
    private final Map<String, ArrayList<String>> phoneBook = new HashMap<>();

    public void add(String familyName, String phone) {
        phoneBook.merge(familyName, new ArrayList<>(Collections.singletonList(phone)),
                (oldPhones, newPhones) -> {

                oldPhones.addAll(newPhones);
                return oldPhones;
            }
        );
    }

    public void get(String familyName) {
        System.out.println(
                "Family name: " + familyName + ", " +
                "Phone: " + phoneBook.get(familyName)
        );
    }
}
