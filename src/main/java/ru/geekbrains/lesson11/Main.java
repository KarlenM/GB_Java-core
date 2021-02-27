/*
    1. Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
    2. Написать метод, который преобразует массив в ArrayList;
    3. Задача:
        a. Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;

        b. Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта,
        поэтому в одну коробку нельзя сложить и яблоки, и апельсины;

        c. Для хранения фруктов внутри коробки можно использовать ArrayList;

        d. Сделать метод getWeight(), который высчитывает вес коробки,
        зная вес одного фрукта и их количество: вес яблока – 1.0f,
        апельсина – 1.5f (единицы измерения не важны);

        e. Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку
        с той, которую подадут в compare() в качестве параметра. true – если их массы равны,
        false в противоположном случае. Можно сравнивать коробки с яблоками и апельсинами;

        f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
        Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами.
        Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты,
        которые были в первой;

        g. Не забываем про метод добавления фрукта в коробку.
 */
package ru.geekbrains.lesson11;

import ru.geekbrains.lesson11.task3.boxes.Box;
import ru.geekbrains.lesson11.task3.fruits.Apple;
import ru.geekbrains.lesson11.task3.fruits.Fruit;
import ru.geekbrains.lesson11.task3.fruits.Orange;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        String[] array = {"1", "2", "3", "4", "5", "6"};
//        Character[] array = {'1', '2', '3', '4', '5', '6'};
        Integer[] array = {1, 2, 3, 4, 5, 6};

        // Task 1
        swapper(array);

        // Task 2
        array2ArrayList(array);

        // Task 3
        Fruit apple = new Apple();
        Fruit orange = new Orange();

        List<Box<Fruit>> boxes = new ArrayList<>();
        boxes.add(new Box<>());
        boxes.add(new Box<>());
        boxes.add(new Box<>());
        boxes.add(new Box<>());
        boxes.add(new Box<>());

        System.out.println("- Box 1 -");
        boxes.get(0).add(apple);
        boxes.get(0).add(apple);
        boxes.get(0).add(apple);
        boxes.get(0).add(orange);

        System.out.println("\nr- Box 2 -");
        boxes.get(1).add(apple);
        boxes.get(1).add(apple);
        boxes.get(1).add(apple);

        System.out.println("\n- Box 3 -");
        boxes.get(2).add(orange);
        boxes.get(2).add(orange);
        boxes.get(2).add(apple);
        boxes.get(2).add(orange);

        if(boxes.get(0).compare(boxes.get(1))) {
            System.out.println("\nBoxes have same weight");
        }

        System.out.println();

        System.out.println("- Shift from Box 1 to Box 2 -");
        boxes.get(0).shiftFruitsToAnotherBox(boxes.get(1));
    }

    public static <T> void swapper(T[] array) {
        System.out.println("- Task 1 -\nBefore: " + Arrays.toString(array));

        List<T> list = new ArrayList<>(Arrays.asList(array));

        for (int i = 0; i < list.size(); i++) {
            if(i % 2 != 0) {
                T prevElement = list.get(i - 1);
                T currentElement = list.get(i);
                list.set(i - 1, currentElement);
                list.set(i, prevElement);
            }
        }

        System.out.println("After: " + list + "\n");
    }

    public static <T> void array2ArrayList(T[] array) {
        System.out.println("- Task 2 -\nМассив: " + Arrays.toString(array));

        List<T> arrayList = new ArrayList<>(Arrays.asList(array));

        System.out.println("ArrayList: " + arrayList);
    }
}
