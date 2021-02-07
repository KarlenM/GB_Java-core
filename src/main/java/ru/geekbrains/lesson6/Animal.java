package ru.geekbrains.lesson6;

public abstract class Animal {
    private final int maxRun;
    private final int maxSwim;
    private final String animalName;
    public static int animalsQuantity;

    public Animal(String animalName, int maxRun, int maxSwim) {
        this.animalName = animalName;
        this.maxRun = maxRun;
        this.maxSwim = maxSwim;
        
        ++animalsQuantity;
    }

    abstract void run(int meters);

    abstract void swim(int meters);

    boolean canDoAction(int maxAction) {
        return maxAction > 0;
    }

    abstract String getAnimalQuantity();

    abstract String getType();

    public String getAnimalName() {
        return animalName;
    }

    public String getAnimalsQuantity() {
        return  "Animal's quantity: " + animalsQuantity;
    }

    public int getMaxRun() {
        return maxRun;
    }

    public int getMaxSwim() {
        return maxSwim;
    }
}
