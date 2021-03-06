// Homework 5. Introduction to OOP
package ru.geekbrains.lesson5;

/*
    4. Создать массив из 5 сотрудников. Пример: Person[] persArray = new Person[5];
    // Вначале объявляем массив объектов
    persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30);

    // потом для каждой ячейки массива задаем объект
    persArray[1] = new Person(...); ... persArray[4] = new Person(...);
    С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
*/
public class Main {
    public static void main(String[] args) {
        Employee[] employees = createArrayWithEmployees();

        printEmployeesByAge(employees, 40);
    }

    private static Employee[] createArrayWithEmployees () {
        Employee[] employees = new Employee[5];

        employees[0] = new Employee(
                "Иванов Иван Иванович",
                "директор",
                "ivan@ivanovich.ru",
                "+7 (999) 777-77-77",
                2000, 50
        );

        employees[1] = new Employee(
                "Смирнов Павел Павлович",
                "менджер",
                "pavel@smirnov.ru",
                "+7 (999) 377-77-77",
                1000,
                35
        );

        employees[2] = new Employee(
                "Кузнецов Андрей Андреевич ",
                "инспектор",
                "andrei@kyznetsov.ru",
                "+7 (999) 277-77-77",
                500,
                42
        );

        employees[3] = new Employee(
                "Попов Сергей Сергеевич",
                "аналитик",
                "sergei@popov.ru",
                "+7 (999) 777-77-78",
                500,
                25
        );

        employees[4] = new Employee(
                "Васильев Василий Васильевич",
                "программист",
                "vasilievich@vadiliev.ru",
                "+7 (999) 777-77-79",
                500,
                23
        );

        return employees;
    }

    private static void printEmployeesByAge(Employee[] employees, int age) {
        System.out.println("\n- Ввод сотрудников старше " + age + " лет -\n");

        for (Employee employee : employees) {
            if(employee.getAge() >= 40) {
                employee.getObjectInfo();
            }
        }
    }
}
