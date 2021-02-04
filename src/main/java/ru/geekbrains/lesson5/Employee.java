// Homework 5. Introduction to OOP
package ru.geekbrains.lesson5;

/*
    1. Создать класс "Сотрудник" с полями: ФИО, должность, email,
    телефон, зарплата, возраст.
 */
public class Employee {
    private String fio;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;


    // 2. Конструктор класса должен заполнять эти поля при создании объекта.
    public Employee(String fio, String position, String email, String phone, int salary, int age) {
        this.fio = fio;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;

//        getObjectInfo();
    }

    // 3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
    public void getObjectInfo() {
        System.out.println(
            "ФИО: " + this.fio + "\n" +
            "Должность: " + this.position + "\n" +
            "Email: " + this.email + "\n" +
            "Телефон: " + this.phone + "\n" +
            "Зарплата: " + this.salary + "\n" +
            "Возраст: " + this.age + "\n"
        );
    }

    public int getAge() {
        return this.age;
    }
}
