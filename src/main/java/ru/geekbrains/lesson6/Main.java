// Homework 6
/*
    1. Создать классы Собака и Кот с наследованием от класса Животное.
    2. Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия.
    Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
    3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.;
    плавание: кот не умеет плавать, собака 10 м.).
    4. * Добавить подсчет созданных котов, собак и животных.
*/
package ru.geekbrains.lesson6;

public class Main {
    public static void main(String[] args) {
        Animal cat = new Cat("Arnold", 200 , 0);
        Animal cat2 = new Cat("Strike", 200, 50);

        Animal dog = new Dog("Jeff", 500, 10);
        Animal dog2 = new Dog("Mark", 200, 0);

        System.out.println("\n- " + cat.getType() + " " + cat.getAnimalName() + " -");
        cat.run(150);
        cat.run(10);
        cat.swim(150);
        cat.swim(10);

        System.out.println("\n- " + cat2.getType() + " " + cat2.getAnimalName() + " -");
        cat2.run(150);
        cat2.run(10);
        cat2.swim(150);
        cat2.swim(25);

        System.out.println("\n- " + dog.getType() + " " + dog.getAnimalName() + " -");
        dog.run(150);
        dog.swim(10);
        dog.swim(100);

        System.out.println("\n- " + dog2.getType() + " " + dog2.getAnimalName() + " -");
        dog2.run(150);
        dog2.run(300);
        dog2.run(600);
        dog2.swim(10);

        System.out.println("\n- Quantity -");
        System.out.println(cat.getAnimalsQuantity());
        System.out.println(cat.getAnimalQuantity());
        System.out.println(dog.getAnimalQuantity());
    }

}
