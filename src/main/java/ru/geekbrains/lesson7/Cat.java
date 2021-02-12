package ru.geekbrains.lesson7;

public class Cat {
    private final String animalName;
    private final int appetite;
    private boolean fullness = false;


    public Cat(String name, int appetite) {
        this.animalName = name;
        this.appetite = appetite;
    }

    public void eat(Plate plate) {
        fullness = plate.decreaseFood(animalName, appetite);
    }

    public void info() {
        String fullness = this.fullness
            ? Colorize.make("ok", Boolean.toString(this.fullness))
            : Colorize.make("error", Boolean.toString(this.fullness));

        System.out.println(
            "Name: " + animalName + "\n" +
            "Appetite: " + appetite + "\n" +
            "Fullness: " + fullness +  "\n"
        );
    }
}