package ru.geekbrains.lesson11.task3.boxes;

import java.util.ArrayList;

public class Box<Fruit> {
    private final ArrayList<Fruit> box = new ArrayList<>();

    public void add(Fruit fruit) {
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
            weight += ((ru.geekbrains.lesson11.task3.fruits.Fruit) fruit).getWeight();
        }

        return weight;
    }

    public int getBoxSize() {
        return this.box.size();
    }

    public boolean compare(Box<Fruit> box) {
        return getWeight() == box.getWeight();
    }

    public void shiftFruitsToAnotherBox(Box<Fruit> box) {
        for (Fruit fruit : this.box) {
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
