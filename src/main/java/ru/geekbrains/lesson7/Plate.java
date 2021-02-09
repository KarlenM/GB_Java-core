package ru.geekbrains.lesson7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public boolean decreaseFood(String animalName, int appetite) {
        if (isEnoughFood(appetite)) {
            food -= appetite;
            return true;
        }

        System.out.println(
                Colorize.make(
                    "warning",
                    "Food is not enough for " + animalName + "\n"
                )
        );

        return false;
    }

    public boolean isEnoughFood(int appetite) {
        return food >= appetite;
    }

    public void addFood(int quantity) {
        food += quantity;
        System.out.println(
                Colorize.make(
                    "ok",
                    "You add " + quantity + " food\n"
                )
        );
    }

    public void info() {
        System.out.println("Food in plate: " + food + "\n");
    }
}
