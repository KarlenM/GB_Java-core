package ru.geekbrains.lesson11.task3.boxes;

import ru.geekbrains.lesson11.task3.fruits.Fruit;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private final ArrayList<T> box = new ArrayList<>();

    public void add(T fruit) {
        String result;

        if (isRightFruit(fruit)) {
            box.add(fruit);

            result = "Fruit in the box";
        } else {
            result = "Wrong fruit type";
        }

        System.out.println(result);
    }

    public boolean isRightFruit(Fruit fruit) {
        for (Fruit value : box) {
            if (!fruit.equals(value)) {
                return false;
            }
        }

        return true;
    }

    public float getWeight() {
        float weight = 0.0f;

        for (Fruit fruit : box) {
            weight += fruit.getWeight();
        }

        return weight;
    }

    public int getBoxSize() {
        return this.box.size();
    }

    public boolean compare(Box<T> box) {
        return getWeight() == box.getWeight();
    }

    public void shiftFruitsToAnotherBox(Box<T> box) {
        for (T fruit : this.box) {
            if(!box.isRightFruit(fruit)) {
                System.out.println("This box for another fruits");

                return;
            }

            box.add(fruit);
        }

        this.box.clear();

        System.out.println("\nFruits in current box: " + getBoxSize());
        System.out.println("Fruits In the box into which they put: " + box.getBoxSize());
    }
}
