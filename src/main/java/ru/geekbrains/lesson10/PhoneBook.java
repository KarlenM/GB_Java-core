package ru.geekbrains.lesson10;

import java.util.*;

public class PhoneBook {
    private final Map<String, ArrayList<String>> phoneBook = new HashMap<>();

    public void add(String familyName, String phone) {
        if (phoneBook.get(familyName) == null) {
            ArrayList<String> phones = new ArrayList<>();
            phones.add(phone);

            phoneBook.put(familyName, phones);
        } else {
            phoneBook.get(familyName).add(phone);
        }
    }

    public void get(String familyName) {
        System.out.println(
                "Family name: " + familyName + ", " +
                "Phone: " + phoneBook.get(familyName)
        );
    }
}
