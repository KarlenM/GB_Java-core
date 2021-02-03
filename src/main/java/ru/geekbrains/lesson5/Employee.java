// Homework 5. Introduction to OOP
package ru.geekbrains.lesson5;

/*
    1. Создать класс "Сотрудник" с полями: ФИО, должность, email,
    телефон, зарплата, возраст.
 */
public class Employee {
    protected String fio;
    protected String position;
    protected String email;
    protected int salary;
    protected int age;


    // 2. Конструктор класса должен заполнять эти поля при создании объекта.
    public Employee(String fio, String position, String email, int salary, int age) {
        this.fio = fio;
        this.position = position;
        this.email = email;
        this.salary = salary;
        this.age = age;

//        getObjectInfo();
    }

    // 3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
    public void getObjectInfo() {
        System.out.println(
            "- Информация об объекте -\n" +
            "ФИО: " + this.fio + "\n" +
            "Должность: " + this.position + "\n" +
            "Email: " + this.email +
            "Зарплата: " + this.salary + "\n" +
            "Возраст: " + this.age + "\n"
        );
    }
}
