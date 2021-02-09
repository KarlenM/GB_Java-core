// Homework 7

/*
1. Расширить задачу про котов и тарелки с едой.

2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды
(например, в миске 10 еды, а кот пытается покушать 15-20).

3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны).
Если коту удалось покушать (хватило еды), сытость = true.

4. Считаем, что если коту мало еды в тарелке, то он её просто не трогает,
то есть не может быть наполовину сыт (это сделано для упрощения логики программы).

5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки
и потом вывести информацию о сытости котов в консоль.

6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку.
 */
package ru.geekbrains.lesson7;

public class Main {
    private static final Cat[] cats = new Cat[6];
    private static final Plate plate = new Plate(100);

    public static void main(String[] args) {
        createCats();
        plate.info();

        feedAllCats();
        infoAllCats();

        plate.addFood(1000);
        plate.info();

        feedAllCats();
        infoAllCats();
        plate.info();
    }

    private static void createCats() {
        cats[0] = new Cat("Jeff", 5);
        cats[1] = new Cat("Stark", 15);
        cats[2] = new Cat("Robi", 25);
        cats[3] = new Cat("Dudi", 60);
        cats[4] = new Cat("Mall", 30);
        cats[5] = new Cat("Kasper", 10);
    }

    private static void feedAllCats() {
        for (Cat cat : cats)
            cat.eat(plate);
    }

    private static void infoAllCats() {
        for (Cat cat : cats)
            cat.info();
    }
}
